package org.gumtree.gumnuts.rest

import org.gumtree.gumnuts.ScalaVerticle
import org.gumtree.gumnuts.services.JvmStatusVerticle
import org.gumtree.gumnuts.sics.HdbManagerVerticle
import org.vertx.java.core.Handler
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.http.HttpServerRequest
import org.vertx.java.core.http.RouteMatcher
import org.vertx.java.core.json.JsonObject
import scala.collection.JavaConversions._
import org.vertx.java.core.json.JsonArray
import org.gumtree.gumnuts.sics.SicsManagerVerticle
import org.gumtree.gumnuts.dae.DaeManagerVerticle
import org.vertx.java.core.buffer.Buffer
import org.gumtree.gumnuts.ws.AnstoWebServerVerticle

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
        send(req, m.body.getObject("data").toString, getCallback(req))
      })
    })
    // Handle SICS status
    routeMatcher.get("/sics/rest/status", { req: HttpServerRequest =>
      eventBus.send(SicsManagerVerticle.EVENT_GET_STATUS, EMPTY_OBJECT, { m: Message[JsonObject] =>
        send(req, new JsonObject().putString("status", m.body.getString("status")).toString, getCallback(req))
      })
    })
    // Handle multiple hdb request
    routeMatcher.get("/sics/rest/hdbs", { req: HttpServerRequest =>
      // Process queries
      val data = new JsonObject
      if (req.query == null) {
    	  eventBus.send(HdbManagerVerticle.EVENT_GET_ALL, data, { m: Message[JsonObject] =>
          	send(req, new JsonObject().putObject("hdbs", m.body).toString, getCallback(req))
        })
      } else {
        req.query.split("&").foreach(query => {
          val tokens = query.split("=")
          tokens(0) match {
            case "paths" => data.putArray("paths", new JsonArray(tokens(1).split(",").toList))
            case "devices" => data.putArray("devices", new JsonArray(tokens(1).split(",").toList))
            case _ =>
          }
        })
        eventBus.send(HdbManagerVerticle.EVENT_GET_OBJECTS, data, { m: Message[JsonObject] =>
          send(req, new JsonObject().putObject("hdbs", m.body).toString, getCallback(req))
        })
      }
    })
    // Handle single hdb reuest
    routeMatcher.getWithRegEx("/sics/rest/hdb/.*", { req: HttpServerRequest =>
      val path = req.path.substring("/sics/rest/hdb".length())
      eventBus.send(HdbManagerVerticle.EVENT_GET_OBJECT_BY_PATH, new JsonObject().putString("path", path), { m: Message[JsonObject] =>
        val hdb = m.body.getObject("hdb")
        // Append parent path URL
        val baseUrl = "http://" + req.headers().get("Host") + "/sics/rest/hdb"
        hdb.putString("parentPathUrl", baseUrl + hdb.getString("parentPath"))
        // Append children path URL
        val childrenPathUrl = new JsonArray
        hdb.putArray("childrenPathUrl", childrenPathUrl)
        hdb.getArray("childrenPath").foreach(path => childrenPathUrl.add(baseUrl + path))
        send(req, hdb.toString, getCallback(req))
      })
    })
    // Handle hdb set value
    routeMatcher.putWithRegEx("/sics/rest/hdb/.*", { req: HttpServerRequest =>
      val path = req.path.substring("/sics/rest/hdb".length())
      var value: String = null
      req.query.split("&").foreach(query => {
        val tokens = query.split("=")
        tokens(0) match {
          case "value" => value = tokens(1)
          case _ =>
        }
      })
      if (value != null) {
        eventBus.send(HdbManagerVerticle.EVENT_SET_OBJECT_BY_PATH, new JsonObject().putString("path", path).putString("value", value))
      }
    })
    // Handle dae request
    routeMatcher.get("/dae/rest/image", { req: HttpServerRequest =>
      var query = new Buffer
      if (req.query != null) {
        query.appendString(req.query)
      }
      eventBus.send(DaeManagerVerticle.EVENT_GET_IMAGE, query, { m: Message[Buffer] =>
        req.response.setChunked(true).write(m.body).end
      })
    })
    // Handle ws request
    routeMatcher.get("/ws/rest/reactor", { req: HttpServerRequest =>
      eventBus.send(AnstoWebServerVerticle.EVENT_GET_REACTOR_POWER, EMPTY_OBJECT, { m: Message[JsonObject] =>
        send(req, m.body.toString, getCallback(req))
      })
    })
    // Start server
    vertx.createHttpServer.requestHandler(routeMatcher).listen(port)
  }

  private def send(req: HttpServerRequest, data: String, callback: String = null) = {
    if (callback != null) req.response.setChunked(true).write(callback + "(" + data + ")").end
    else req.response.setChunked(true).write(data).end
  }

  private def getCallback(req: HttpServerRequest): String = {
    if (req.query == null) return null
    req.query.split("&").foreach(query => {
      val tokens = query.split("=")
      tokens(0) match {
        case "callback" => return tokens(1)
        case _ =>
      }
    })
    return null
  }

}