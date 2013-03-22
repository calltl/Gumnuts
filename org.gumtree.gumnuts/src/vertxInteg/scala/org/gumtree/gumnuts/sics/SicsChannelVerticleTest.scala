package org.gumtree.gumnuts.sics

import org.gumtree.gumnuts.test.ScalaVerticleTest
import org.junit.runner.RunWith
import org.vertx.java.test.junit.VertxJUnit4ClassRunner
import org.vertx.java.test.TestVerticle
import org.junit.Test
import org.junit.Assert._
import org.vertx.java.core.json.JsonObject
import org.vertx.java.test.utils.CountDownLatchHandler
import org.vertx.java.core.eventbus.Message
import java.util.concurrent.TimeUnit

@RunWith(classOf[VertxJUnit4ClassRunner])
@TestVerticle(main = "org.gumtree.gumnuts.sics.SicsChannelVerticle", jsonConfig = """
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
    // Waiting for the test channel to be ready
    var channelReady = false
    vertx.setPeriodic(100, { id: java.lang.Long =>
      eventBus.send(SicsChannelVerticle.EVENT_GET_STATUS + ".test", EMPTY_OBJECT, { m: Message[JsonObject] =>
        if (m.body.getString("status") == SicsChannelVerticle.STATUS_CONNECTED) {
          vertx.cancelTimer(id)
          channelReady = true
        }
      })
    })
    while (!channelReady) {
      Thread.sleep(100)
    }

    val handler = new CountDownLatchHandler[Message[JsonObject]](1)
    eventBus.send(SicsChannelVerticle.EVENT_SEND + ".test", new JsonObject().putString("command", "status"), handler)
    val reply = handler.poll(10, TimeUnit.SECONDS).body
    assertEquals("status = Eager to execute commands", reply.getString("data"))
  }

}