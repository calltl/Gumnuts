package org.gumtree.gumnuts.sics

import ch.psi.sics.hipadaba.Component
import scala.collection.immutable.TreeMap

class HdbObject(val path: String, val parent: HdbObject, val component: Component = null) {

  var children = TreeMap[String, HdbObject]()
  
  def addChild(child: HdbObject) = {
    children += (child.path -> child)
  }
  
}