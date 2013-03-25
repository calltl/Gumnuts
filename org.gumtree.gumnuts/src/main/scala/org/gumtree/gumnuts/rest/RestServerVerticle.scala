package org.gumtree.gumnuts.rest

import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.Handler
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.http.HttpServerRequest
import org.vertx.java.core.http.RouteMatcher
import org.vertx.java.core.json.JsonObject
import org.gumtree.gumnuts.services.JvmStatusVerticle
import org.gumtree.gumnuts.sics.HdbManagerVerticle

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
    routeMatcher.get("/jmx/rest", { req: HttpServerRequest =>
      eventBus.send(JvmStatusVerticle.EVENT_GET_STATUS, EMPTY_OBJECT, { m: Message[JsonObject] =>
        req.response.setChunked(true).write(m.body.getObject("data").toString).end
      })
    })
    // Handle multiple hdb reuest
    routeMatcher.get("/sics/rest/hdbs", { req: HttpServerRequest =>
//      eventBus.send(HdbManagerVerticle.EVENT_GET_OBJECTS, new JsonObject(), { m: Message[JsonObject] =>
//      })
    })
    // Handle single hdb reuest
    routeMatcher.get("/sics/rest/hdb/.+", { req: HttpServerRequest =>
      val path = req.path.substring("/sics/hdb".length()) 
      eventBus.send(HdbManagerVerticle.EVENT_GET_OBJECT_BY_PATH, new JsonObject().putString("path", path), { m: Message[JsonObject] =>
        val hdb = m.body.getObject("hdb")
        val baseUrl = "http://" + req.headers().get("Host") + "/sics/hdb"
        hdb.putString("parentPathUrl", baseUrl + hdb.getString("parentPath"))
        req.response.setChunked(true).write(hdb.toString).end
      })
    })
    // Start server
    vertx.createHttpServer.requestHandler(routeMatcher).listen(port)
  }

}