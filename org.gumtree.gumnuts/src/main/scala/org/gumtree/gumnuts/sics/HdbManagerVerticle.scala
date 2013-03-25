package org.gumtree.gumnuts.sics

import java.io.ByteArrayInputStream
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.immutable.TreeMap
import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.Handler
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.json.JsonObject
import ch.psi.sics.hipadaba.Component
import ch.psi.sics.hipadaba.SICS
import scala.collection.JavaConversions._
import org.vertx.java.core.json.JsonArray

object HdbManagerVerticle {

  val EVENT_GET_OBJECTS = "gumtree.sics.hdb.getObjects"

  val EVENT_GET_OBJECT_BY_PATH= "gumtree.sics.hdb.getObjectByPath"
    
  val EVENT_GET_OBJECT_BY_DEVICE= "gumtree.sics.hdb.getObjectByDevice"
    
}

/**
 * Supported events:
 *
 */
class HdbManagerVerticle extends ScalaVerticle {

  var model: SICS = _
  var pathMap: Map[String, HdbObject] = _ 
  var deviceMap: Map[String, HdbObject] = _

  def start() = {
    // Load model
    eventBus.send(SicsChannelVerticle.EVENT_SEND + "." + CONST_SICS_CHANNEL_GENERAL,
      new JsonObject().putString("command", "getgumtreexml /"), { m: Message[JsonObject] =>
        val text = m.body.getString("data")
        // Convert XML into model
        model = SicsUtils.loadSICSModel(new ByteArrayInputStream(text.getBytes()))
        // Convert model into hdb object and cache into maps
        pathMap = TreeMap[String, HdbObject]()
        deviceMap = TreeMap[String, HdbObject]()
        model.getComponent().foreach(parseComponentModel(_))
        logger.info("Hipadaba model loaded")
      })

    // Handle value update from SICS
    eventBus.registerHandler(SicsStatusVerticle.EVENT_HDB_UPDATE_VALUE, { m: Message[JsonObject] =>
      val path = m.body.getString("path")
      val hdbObject = pathMap(path)
      if (hdbObject != null) hdbObject.value = m.body.getString("value")
    })
    
    // Handle get objects request
    eventBus.registerHandler(HdbManagerVerticle.EVENT_GET_OBJECTS, { m: Message[JsonObject] =>
      val paths = m.body.getArray("paths")
      val devices = m.body.getArray("devices")
      
    })
    
    // Handle get object by path request
    eventBus.registerHandler(HdbManagerVerticle.EVENT_GET_OBJECT_BY_PATH, { m: Message[JsonObject] =>
      val path = m.body.getString("path")
      val hdbObject = pathMap(path)
      m.reply(new JsonObject().putObject("hdb", hdbObject.createJsonObject))
    })
    
    // Handle get object by device request
    eventBus.registerHandler(HdbManagerVerticle.EVENT_GET_OBJECT_BY_DEVICE, { m: Message[JsonObject] =>
      val paths = m.body.getArray("paths")
      val devices = m.body.getArray("devices")
      
    })
  }
  
  /**
   * **************************************************************************
   * Utilities
   * **************************************************************************
   */
  
  private def parseComponentModel(component: Component, parent: HdbObject = null): Unit = {
    // Create hdb object
    val basePath = if (parent == null) "" else parent.path
    val path = basePath + "/" + component.getId()
    val hdbObject = new HdbObject(path, parent, convertComponentToJson(component))
    if (parent != null) parent.addChild(hdbObject)
    // Cache to path map
    pathMap += (path -> hdbObject)
    // Cache to device map
    val deviceId = SicsUtils.getDeviceId(component)
    if (deviceId != null) deviceMap += (deviceId -> hdbObject)
    // Recursion
    component.getComponent().foreach(parseComponentModel(_, hdbObject))
  }
  
  private def convertComponentToJson(component: Component): JsonObject = {
    val json = new JsonObject
    json.putString("id", component.getId())
    json.putString("dataType", component.getDataType().getName())    
    val properties = new JsonObject
    json.putObject("properties", properties)
    component.getProperty().foreach(p => properties.putArray(p.getId(), new JsonArray(p.getValue().toArray())))
    return json
  }

}