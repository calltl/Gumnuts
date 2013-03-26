package org.gumtree.gumnuts.dae

import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.json.JsonObject
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.net.NetClient
import org.vertx.java.core.net.NetSocket
import org.vertx.java.core.http.HttpClient
import org.vertx.java.core.http.HttpClientResponse
import org.vertx.java.core.Handler
import scala.collection.JavaConversions._
import org.apache.commons.httpclient.methods.GetMethod
import org.apache.commons.httpclient.HttpStatus
import org.vertx.java.core.buffer.Buffer

object DaeManagerVerticle {

  val EVENT_GET_IMAGE = "gumtree.dae.getImage"

}

class DaeManagerVerticle extends ScalaVerticle {

  private lazy val host: String = getConfig.getString(CONFIG_DAE_HOST)
  private lazy val port: Int = getConfig.getInteger(CONFIG_DAE_PORT)
  private lazy val login: String = getConfig.getString(CONFIG_DAE_LOGIN)
  private lazy val password: String = getConfig.getString(CONFIG_DAE_PASSWORD)

  private var client: HttpClient = _
  private var socket: NetSocket = _

  def start() = {
    val connector = new HttpConnector
    connector.parameters.put(HttpConnector.KEY_LOGIN, login)
    connector.parameters.put(HttpConnector.KEY_PASSWORD, password)

    eventBus.registerHandler(DaeManagerVerticle.EVENT_GET_IMAGE, { m: Message[Buffer] =>
      val getMethod = new GetMethod("http://" + host + ":" + port + "/admin/openimageinformat.egi?" + m.body.toString())
      getMethod.setDoAuthentication(true)

      // TODO: should do this blocking operation in a worker thread
      val statusCode = connector.client.executeMethod(getMethod)
      if (statusCode != HttpStatus.SC_OK) {
        logger.error("Method GET failed: " + getMethod.getStatusLine);
        getMethod.releaseConnection;
      }
      m.reply(new Buffer(getMethod.getResponseBody()))
    })
  }

}