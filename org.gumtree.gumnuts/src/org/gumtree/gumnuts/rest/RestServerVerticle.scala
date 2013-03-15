package org.gumtree.gumnuts.rest

import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.Handler
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.http.HttpServerRequest
import org.vertx.java.core.http.RouteMatcher
import org.vertx.java.core.json.JsonObject

class RestServerVerticle extends ScalaVerticle {

  def start() = {
    val routeMatcher = new RouteMatcher()
    routeMatcher.get("/jmx", new Handler[HttpServerRequest] {
      def handle(request: HttpServerRequest) = {
        eventBus.send(ACTION_GET_JVM_STATUS, new JsonObject, new Handler[Message[JsonObject]] {
          def handle(message: Message[JsonObject]) = {
            request.response.setChunked(true)
            request.response.write(message.body.toString())
            request.response.end()
          }
        })
      }
    })
    vertx.createHttpServer().requestHandler(routeMatcher).listen(8080)
  }

}