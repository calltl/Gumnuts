package org.gumtree.gumnuts.ws

import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.json.JsonObject
import au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.WebServiceAppServiceSoapHttpStub
import au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorPowerElement
import java.net.URL

object AnstoWebServerVerticle {

  val EVENT_GET_REACTOR_POWER = "gumtree.ws.getReactorPower"

}

class AnstoWebServerVerticle extends ScalaVerticle {

  lazy val url = new URL(getConfig.getString(CONFIG_WS_URL))

  def start() = {
    eventBus.registerHandler(AnstoWebServerVerticle.EVENT_GET_REACTOR_POWER, { m: Message[JsonObject] =>
      // TODO: this is a blocking operation ... should be done in the worker thread instead
      m.reply(new JsonObject().putString("power", geReactorPower))
    })
  }

  private def geReactorPower(): String = {
    val stub = new WebServiceAppServiceSoapHttpStub(url, null);
    val in = new GetReactorPowerElement
    val out = stub.getReactorPower(in)
    return out.getResult.getValue
  }

}