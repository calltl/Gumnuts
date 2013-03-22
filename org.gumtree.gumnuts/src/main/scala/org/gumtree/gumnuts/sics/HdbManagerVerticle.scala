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

/**
 * Supported events:
 *
 * 
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
  }

  /**
   * **************************************************************************
   * Event handlers
   * **************************************************************************
   */
  
  val getComponentHandler = new Handler[Message[JsonObject]] {
    def handle(message: Message[JsonObject]) = {
      message.body.getArray("deviceId")
    }
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
    val hdbObject = new HdbObject(path, parent)
    if (parent != null) parent.addChild(hdbObject)
    // Cache to path map
    pathMap += (path -> hdbObject)
    // Cache to device map
    val deviceId = SicsUtils.getDeviceId(component)
    if (deviceId != null) deviceMap += (deviceId -> hdbObject)
    // Recursion
    component.getComponent().foreach(parseComponentModel(_, parent))
  }
  
}