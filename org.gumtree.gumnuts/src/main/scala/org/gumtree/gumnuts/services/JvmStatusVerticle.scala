package org.gumtree.gumnuts.services

import java.lang.management.ManagementFactory
import java.util.Calendar

import scala.collection.JavaConversions.asScalaSet
import scala.collection.JavaConversions.collectionAsScalaIterable

import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.Handler
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.json.JsonArray
import org.vertx.java.core.json.JsonObject

import javax.management.ObjectName
import javax.management.openmbean.CompositeData
import javax.management.openmbean.TabularData

object JvmStatusVerticle {
  
  val EVENT_GET_STATUS = "gumtree.jvm.getStatus"

}

/**
 * Supported events:
 *
 * JVM_GET_STATUS
 *   Type:
 *     Inbound
 *   Description:
 *     Get JVM status
 *   Output:
 *     data - JVM status
 *
 */
class JvmStatusVerticle extends ScalaVerticle {

  lazy val server = ManagementFactory.getPlatformMBeanServer()

  def start() = {
    eventBus.registerHandler(JvmStatusVerticle.EVENT_GET_STATUS, { m: Message[JsonObject] =>
      logger.info("Generating JVM status...")
      m.reply(process)
      logger.info("Replied JVM status...")
    })
  }

  private def process(): JsonObject = {
    val startTime = System.currentTimeMillis
    val mbeans = server.queryNames(null, null)
    val output = new JsonObject
    mbeans.foreach(mbean => processMBean(mbean, output))
    val result = new JsonObject
    result.putObject("JMX", output)
    result.putString("processTime", System.currentTimeMillis - startTime + "ms")
    result.putString("time", Calendar.getInstance.getTime.toString)
    return new JsonObject().putObject("data", result)
  }

  private def processMBean(mbean: ObjectName, output: JsonObject) = {
    val attributes = server.getMBeanInfo(mbean).getAttributes
    val mbeanData = new JsonObject
    for (attribute <- attributes) {
      try {
        val data = server.getAttribute(mbean, attribute.getName)
        val key = attribute.getName
        data match {
          case data: CompositeData => mbeanData.putObject(key, processCompositeData(data))
          case data: TabularData => mbeanData.putArray(key, processTabularData(data))
          case data: Number => mbeanData.putNumber(key, data)
          case data if data.getClass().isArray() => mbeanData.putArray(key, processArrayData(data))
          case _ => mbeanData.putString(key, data.toString)
        }
      } catch {
        case e: Exception =>
      }
    }
    output.putObject(mbean.toString, mbeanData)
  }

  private def processCompositeData(data: CompositeData): JsonObject = {
    val result = new JsonObject()
    for (key <- data.getCompositeType.keySet) {
      val value = data.get(key)
      value match {
        case value: CompositeData => result.putObject(key, processCompositeData(value))
        case value: TabularData => result.putArray(key, processTabularData(value))
        case value: Number => result.putNumber(key, value)
        case value if value.getClass.isArray => result.putArray(key, processArrayData(value))
        case _ => result.putString(key, value.toString)
      }
    }
    return result;
  }

  private def processTabularData(data: TabularData): JsonArray = {
    val array = new JsonArray
    for (value <- data.values if value.isInstanceOf[CompositeData]) {
      array.addObject(processCompositeData(value.asInstanceOf[CompositeData]))
    }
    return array
  }

  private def processArrayData(data: Object): JsonArray = {
    val array = new JsonArray
    data match {
      case data: Array[CompositeData] => data.foreach(x => array.addObject(processCompositeData(x)))
      case data: Array[String] => data.foreach(x => array.addString(x))
      case data: Array[Number] => data.foreach(x => array.addNumber(x))
      case data: Array[Object] => data.foreach(x => array.addString(x.toString))
    }
    return array
  }

}