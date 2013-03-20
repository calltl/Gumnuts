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

class HdbManagerVerticle extends ScalaVerticle {

  var model: SICS = _
  var pathMap: Map[String, HdbObject] = _ 
  var deviceMap: Map[String, HdbObject] = _

  def start() = {
    eventBus.registerHandler(EVENT_SICS_CHANNEL_STATUS + "." + CONST_SICS_CHANNEL_GENERAL, connectionHandler)
//    eventBus.registerHandler(ACTION_SICS_HDB_GET_COMPONENT, arg1)
  }

  /**
   * **************************************************************************
   * Event handlers
   * **************************************************************************
   */
  
  /**
   * Handler for general channel connection 
   */
  val connectionHandler = new Handler[Message[JsonObject]] {
    def handle(message: Message[JsonObject]) = {
      val status = SicsChannelStatus.withName(message.body.getString("status"))
      status match {
        case SicsChannelStatus.CONNECTED => {
          eventBus.send(ACTION_SICS_CHANNEL_SEND + "." + CONST_SICS_CHANNEL_GENERAL,
              new JsonObject().putString("command", "getgumtreexml /"), loadModelHandler)
        }
        case _ =>
      }
    }
  }
  
  val getComponentHandler = new Handler[Message[JsonObject]] {
    def handle(message: Message[JsonObject]) = {
      message.body.getArray("deviceId")
    }
  }
  

  val loadModelHandler = new Handler[Message[JsonObject]] {
    def handle(message: Message[JsonObject]) = {
      val text = message.body.getString("data")
      // Convert XML into model
      model = SicsUtils.loadSICSModel(new ByteArrayInputStream(text.getBytes()))
      // Convert model into hdb object and cache into maps
      pathMap = TreeMap[String, HdbObject]()
      deviceMap = TreeMap[String, HdbObject]()
      model.getComponent().foreach(parseComponentModel(_))
      logger.info("Hipadaba model loaded")
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