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
import org.gumtree.gumnuts.VerticleConstants
import ch.psi.sics.hipadaba.DataType
import java.lang.Exception

object HdbManagerVerticle {

  val EVENT_GET_ALL = "gumtree.sics.hdb.getAll"

  val EVENT_GET_OBJECTS = "gumtree.sics.hdb.getObjects"

  val EVENT_GET_OBJECT_BY_PATH = "gumtree.sics.hdb.getObjectByPath"

  val EVENT_GET_OBJECT_BY_DEVICE = "gumtree.sics.hdb.getObjectByDevice"

  val EVENT_SET_OBJECT_BY_PATH = "gumtree.sics.hdb.setObjectByPath"
    
  val EVENT_OBJECT_UPDATE = "gumtree.sics.hdb.objectUpdate"

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
        val parent = new HdbObject("/")
        pathMap += ("/" -> parent)
        model.getComponent().foreach(parseComponentModel(_, parent))
        // Get initial values
        for (value <- pathMap.values) {
          fetchHdbObjectValue(value)
          // Slow down ... not to overflow SICS
          Thread.sleep(1)
        }
        logger.info("Hipadaba model loaded")
      })

    // Handle value update from SICS
    eventBus.registerHandler(SicsStatusVerticle.EVENT_HDB_UPDATE_VALUE, { m: Message[JsonObject] =>
      val path = m.body.getString("path")
      val hdbObject = pathMap(path)
      if (hdbObject != null) { 
        hdbObject.value = m.body.getString("value")
        eventBus.publish(HdbManagerVerticle.EVENT_OBJECT_UPDATE, new JsonObject().putString("path", path).putString("value", m.body.getString("value")))
      }
    })

    // Handle state update from SICS
    eventBus.registerHandler(SicsStatusVerticle.EVENT_HDB_UPDATE_STATE, { m: Message[JsonObject] =>
      val path = m.body.getString("path")
      val state = m.body.getString("state")
      val hdbObject = pathMap(path)
      state match {
        case "STARTED" => hdbObject.state = HdbObject.STATUS_RUNNING
        case "FINISH" => hdbObject.state = HdbObject.STATUS_OK
        case _ => hdbObject.state = HdbObject.STATUS_OK
      }
    })

    // Handle get objects request
    eventBus.registerHandler(HdbManagerVerticle.EVENT_GET_OBJECTS, { m: Message[JsonObject] =>
      val data = new JsonObject

      val pathArray = new JsonArray
      data.putArray("paths", pathArray)
      val paths = m.body.getArray("paths")
      if (paths != null) {
        for (path <- paths) {
          try {
            pathArray.addObject(pathMap(path.toString()).createJsonObject)
          } catch {
            case e: Exception =>
          }
        }
      }

      val deviceArray = new JsonArray
      data.putArray("devices", deviceArray)
      val deviceIds = m.body.getArray("devices")
      if (deviceIds != null) {
        for (deviceId <- deviceIds) {
          try {
            deviceArray.addObject(deviceMap(deviceId.toString()).createJsonObject)
          } catch {
            case e: Exception =>
          }
        }
      }

      m.reply(data)
    })

    // Handle get all objects
    eventBus.registerHandler(HdbManagerVerticle.EVENT_GET_ALL, { m: Message[JsonObject] =>
      val data = new JsonObject
      val parent = pathMap.get("/").get
      def processObjectStructure(hdbObject: HdbObject, data: JsonObject): Unit = {
        data.putString("path", hdbObject.path)
        data.putString("value", hdbObject.value)
        data.putString("state", hdbObject.state)
        if (hdbObject.component != null) data.mergeIn(hdbObject.component)
        val childrenArray = new JsonArray
        for (child <- hdbObject.getChildren) {
          val data = new JsonObject
          processObjectStructure(child, data)
          childrenArray.addObject(data)
        }
        if (childrenArray.size() > 0) {
        	data.putArray("children", childrenArray)
        }
      }
      processObjectStructure(parent, data)
      m.reply(data)
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

    // Handle set object by path request
    eventBus.registerHandler(HdbManagerVerticle.EVENT_SET_OBJECT_BY_PATH, { m: Message[JsonObject] =>
      val path = m.body.getString("path")
      val value = m.body.getString("value")
      if (pathMap.contains(path)) {
        eventBus.send(SicsChannelVerticle.EVENT_SEND + "." + CONST_SICS_CHANNEL_GENERAL, new JsonObject().putString("command", "hset " + path + " " + value))
      }
    })
  }

  /**
   * **************************************************************************
   * Utilities
   * **************************************************************************
   */

  private def parseComponentModel(component: Component, parent: HdbObject): Unit = {
    // Create hdb object
    val path = if (parent.path == "/") "/" + component.getId() else parent.path + "/" + component.getId()
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

  private def fetchHdbObjectValue(hdbObject: HdbObject): Unit = {
    if (hdbObject.component == null) return
    val dataType = hdbObject.component.getString("dataType")
    if (dataType == DataType.NONE_LITERAL.getName()) return
    eventBus.send(SicsChannelVerticle.EVENT_SEND + "." + CONST_SICS_CHANNEL_GENERAL, new JsonObject().putString("command", "hget " + hdbObject.path), { m: Message[JsonObject] =>
      val data = m.body.getObject("data")
      if (dataType == DataType.INT_LITERAL.getName()) { hdbObject.value = data.getNumber(data.getFieldNames.head).toString() }
      else if (dataType == DataType.FLOAT_LITERAL.getName()) { hdbObject.value = data.getNumber(data.getFieldNames.head).toString() }
      else if (dataType == DataType.TEXT_LITERAL.getName()) { hdbObject.value = data.getString(data.getFieldNames.head).toString() }
    })
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