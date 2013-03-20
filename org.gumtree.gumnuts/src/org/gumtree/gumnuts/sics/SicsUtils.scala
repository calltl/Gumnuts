package org.gumtree.gumnuts.sics

import java.io.InputStream
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.sdo.SDOFactory
import org.eclipse.emf.ecore.sdo.util.SDOUtil
import ch.psi.sics.hipadaba.DocumentRoot
import ch.psi.sics.hipadaba.SICS
import ch.psi.sics.hipadaba.impl.HipadabaPackageImpl
import ch.psi.sics.hipadaba.Component
import ch.psi.sics.hipadaba.Property

import scala.collection.JavaConversions._

object SicsUtils {
  
   def loadSICSModel(inputStream: InputStream): SICS = {
    val resourceSet = SDOUtil.createResourceSet()
    resourceSet.getPackageRegistry().put(HipadabaPackageImpl.eNS_URI, HipadabaPackageImpl.eINSTANCE)
    val resource = resourceSet.createResource(URI.createURI("all.hipadaba"))
    resource.load(inputStream, null)
    val content = resource.getContents().get(0)
    var sicsModel: SICS = null
    if (content.isInstanceOf[DocumentRoot]) {
      sicsModel = content.asInstanceOf[DocumentRoot].getSICS()
    } else if (content.isInstanceOf[SICS]) {
      // It case of no OSGi execution, content can be SICSImpl, not
      // DocumentRoot.....very funny.
      sicsModel = content.asInstanceOf[SICS]
    }
    val dataGraph = SDOFactory.eINSTANCE.createEDataGraph()
    dataGraph.setERootObject(sicsModel.asInstanceOf[EObject])
    val root = dataGraph.getERootObject()
    return root.asInstanceOf[SICS]
  }
   
  def getProperty(component: Component, key: String): List[Property] = {
    component.getProperty().filter(_.getId().equals(key)).toList
  }
  
  def getDeviceId(component: Component): String = {
    try {
      return getProperty(component, "sicsdev")(0).getValue()(0)
    } catch {
      case e: Exception =>
    }
    return null
  }
   
  

}