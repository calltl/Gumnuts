package org.gumtree.gumnuts.scripting

import org.gumtree.gumnuts.test.ScalaVerticleTest
import org.junit.Test
import org.junit.runner.RunWith
import org.vertx.java.test.TestVerticle
import org.vertx.java.test.junit.VertxJUnit4ClassRunner
import org.vertx.java.core.eventbus.EventBus
import org.vertx.java.core.json.JsonObject
import org.vertx.java.core.eventbus.Message

@RunWith(classOf[VertxJUnit4ClassRunner])
@TestVerticle(main = "org.gumtree.gumnuts.scripting.ScriptingManagerVerticle")
class ScriptingManagerVerticleTest extends ScalaVerticleTest {

  @Test
  def testRunScript() = {
    var workerId: Int = -1
    eventBus.send(ScriptingManagerVerticle.EVENT_RUN_SCRIPT, new JsonObject().putString("script",
"""
x = 1
x = x + 1
print("x: " + str(x))

print("sleeping...")
from time import sleep
sleep(2)
print("awaked")
"""), { m: Message[JsonObject] => workerId = m.body.getInteger("id")})

	// TODO: implement timeout
    while (workerId == -1) {
      Thread.sleep(100)
    }
    
    var completed = false
    vertx.setPeriodic(100, { id: java.lang.Long =>
      eventBus.send(ScriptingManagerVerticle.EVENT_IS_EXECUTOR_EXECUTING, new JsonObject().putNumber("id", workerId), { m: Message[JsonObject] =>
        if (!m.body.getBoolean("isExecuting")) {
          vertx.cancelTimer(id)
          completed = true
        }
      })
    })
    while (!completed) {
      Thread.sleep(100)
    }
  }
}