package org.gumtree.gumnuts.sics

import ch.psi.sics.hipadaba.Component
import scala.collection.immutable.TreeMap
import org.vertx.java.core.json.JsonObject
import org.vertx.java.core.json.JsonArray

object HdbObject {

  val STATUS_OK = "ok"
  val STATUS_RUNNING = "running"

}

class HdbObject(val path: String, val parent: HdbObject = null, val component: JsonObject = null) {

  var children = TreeMap[String, HdbObject]()
  var currentValue: String = null
  var currentState: String = HdbObject.STATUS_OK
  
  def addChild(child: HdbObject) = {
    children += (child.path -> child)
  }
  
  def value = currentValue
  def value_= (newValue: String) = currentValue = newValue
 
  def state = currentState
  def state_= (newState: String) = currentState = newState
  
  def createJsonObject(): JsonObject = {
    val json = new JsonObject
    json.putString("path", path)
    json.putString("value", value)
    if (component != null) json.mergeIn(component)
    
    if (parent != null) {
      json.putString("parentPath", parent.path)
    } else {
      json.putString("parentPath", "/")
    }
    
    val childrenPath = new JsonArray
    json.putArray("childrenPath", childrenPath)
    children.values.foreach(hdbOjbect => childrenPath.add(hdbOjbect.path))
    return json
  }

}