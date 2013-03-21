package org.gumtree.gumnuts.rest

import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.Handler
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.http.HttpServerRequest
import org.vertx.java.core.http.RouteMatcher
import org.vertx.java.core.json.JsonObject

/**
 * RestServerVerticle provides ReSTful web services across HTTP connection 
 *
 */
class RestServerVerticle extends ScalaVerticle {

  // Configurations
  private lazy val port: Int = getConfig.getInteger(CONFIG_REST_PORT)

  def start() = {
    val routeMatcher = new RouteMatcher
    // Handle JMX request
    routeMatcher.get("/jmx", { req: HttpServerRequest =>
      eventBus.send(EVENT_JVM_GET_STATUS, new JsonObject, { m: Message[JsonObject] =>
        req.response.setChunked(true).write(m.body.getObject("data").toString).end
      })
    })
    // Start server
    vertx.createHttpServer.requestHandler(routeMatcher).listen(port)
  }

}