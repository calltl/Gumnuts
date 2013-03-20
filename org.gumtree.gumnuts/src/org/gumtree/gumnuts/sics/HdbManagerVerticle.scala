package org.gumtree.gumnuts.sics

import java.io.ByteArrayInputStream
import java.io.InputStream
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.sdo.SDOFactory
import org.eclipse.emf.ecore.sdo.util.SDOUtil
import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.Handler
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.json.JsonObject
import ch.psi.sics.hipadaba.DocumentRoot
import ch.psi.sics.hipadaba.SICS
import ch.psi.sics.hipadaba.impl.HipadabaPackageImpl
import scala.collection.JavaConversions._
import ch.psi.sics.hipadaba.Component

class HdbManagerVerticle extends ScalaVerticle {

  var model: SICS = _
  var hdbMap: Map[String, HdbObject] = _

  def start() = {
    eventBus.registerHandler(EVENT_SICS_CHANNEL_STATUS + "." + CONST_SICS_CHANNEL_GENERAL, connectionHandler)
  }

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

  val loadModelHandler = new Handler[Message[JsonObject]] {
    def handle(message: Message[JsonObject]) = {
      val text = message.body.getString("data")
      model = loadSICSModel(new ByteArrayInputStream(text.getBytes()))
      hdbMap = parseSICSModel(model)
      logger.info("Hipadaba model loaded")
    }
  }

  private def parseSICSModel(model: SICS): Map[String, HdbObject] = {
    var hdbMap = Map[String, HdbObject]()
    val basePath = ""
    for (component: Component <- model.getComponent()) {
      hdbMap = hdbMap ++ parseComponentModel(component, basePath)
    }
    return hdbMap
  }
  
  private def parseComponentModel(component: Component, basePath: String): Map[String, HdbObject] = {
    val path = basePath + "/" + component.getId()
    var hdbMap = Map(path -> new HdbObject(path, component))
    for (child: Component <- component.getComponent()) {
      hdbMap = hdbMap ++ parseComponentModel(child, path)
    }
    return hdbMap
  } 
  
  private def loadSICSModel(inputStream: InputStream): SICS = {
    val resourceSet = SDOUtil.createResourceSet()
    resourceSet.getPackageRegistry().put(HipadabaPackageImpl.eNS_URI, HipadabaPackageImpl.eINSTANCE)
    val resource = resourceSet.createResource(URI.createURI("all.hipadaba"))
    resource.load(inputStream, null);
    val content = resource.getContents().get(0);
    var sicsModel: SICS = null;
    if (content.isInstanceOf[DocumentRoot]) {
      val documentRoot = content.asInstanceOf[DocumentRoot];
      sicsModel = documentRoot.getSICS();
    } else if (content.isInstanceOf[SICS]) {
      // It case of no OSGi execution, content can be SICSImpl, not
      // DocumentRoot.....very funny.
      sicsModel = content.asInstanceOf[SICS];
    }
    val dataGraph = SDOFactory.eINSTANCE.createEDataGraph();
    dataGraph.setERootObject(sicsModel.asInstanceOf[EObject]);
    val root = dataGraph.getERootObject();
    return root.asInstanceOf[SICS];
  }

}