package org.gumtree.gumnuts.sics

import org.gumtree.gumnuts.test.ScalaVerticleTest
import org.junit.runner.RunWith
import org.vertx.java.test.junit.VertxJUnit4ClassRunner
import org.vertx.java.test.TestVerticle
import org.junit.Test
import org.vertx.java.core.json.JsonObject
import org.vertx.java.test.utils.CountDownLatchHandler
import org.vertx.java.core.eventbus.Message
import java.util.concurrent.TimeUnit


@RunWith(classOf[VertxJUnit4ClassRunner])
@TestVerticle(main="org.gumtree.gumnuts.sics.SicsChannelVerticle", jsonConfig="""
{
  "name": "test",
  "host": "localhost",
  "port": 60002,
  "login": "spy",
  "password": "007"
}
""")
class SicsChannelVerticleTest extends ScalaVerticleTest {

  @Test
  def testChannel() = {
//    var isConnected = false
//    vertx.setPeriodic(100, { id: java.lang.Long =>
//      val handler = new CountDownLatchHandler[Message[JsonObject]](1)
//      eventBus.send(EVENT_JVM_GET_STATUS, new JsonObject, handler)
//      val message = handler.poll(1000, TimeUnit.SECONDS)
//      if (message.body.getString("status") == SicsChannelStatus.CONNECTED.toString()) {
//        vertx.cancelTimer(id)
//      }
//    })
  }
  
}