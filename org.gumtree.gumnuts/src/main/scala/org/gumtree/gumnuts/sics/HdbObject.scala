package org.gumtree.gumnuts.sics

import ch.psi.sics.hipadaba.Component
import scala.collection.immutable.TreeMap
import org.vertx.java.core.json.JsonObject

class HdbObject(val path: String, val parent: HdbObject, val component: JsonObject = null) {

  var children = TreeMap[String, HdbObject]()
  var currentValue: String = null
  
  def addChild(child: HdbObject) = {
    children += (child.path -> child)
  }
  
  def value = currentValue
  def value_= (newValue: String) = currentValue = newValue
 
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
    return json
  }

}