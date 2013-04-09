package org.gumtree.gumnuts.scripting

import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.json.JsonObject
import scala.collection.mutable.Map
import org.vertx.java.core.Handler

object ScriptingManagerVerticle {

  val EVENT_RUN_SCRIPT = "gumtree.scripting.runScript"
  val EVENT_IS_EXECUTOR_EXECUTING = "gumtree.scripting.isExecutorExecuting"
  val EVENT_TERMINATE_EXECUTOR = "gumtree.scripting.terminateExecutor"
}

class ScriptingManagerVerticle extends ScalaVerticle {

  var id = 0
  var deploymentMap: Map[Int, String] = Map()
  
  def start() = {
    // Handle run script
    eventBus.registerHandler(ScriptingManagerVerticle.EVENT_RUN_SCRIPT, { m: Message[JsonObject] =>
      val workerId = id
      val config = new JsonObject().putNumber("id", workerId).putString("script", m.body.getString("script"))
      container.deployWorkerVerticle(classOf[JythonExecutorVerticle].getName, config, 1, new Handler[String] {
        def handle(deploymentId: String): Unit = {
          logger.info("Started script executor id: " + workerId)
          deploymentMap += (workerId -> deploymentId)
          m.reply(new JsonObject().putNumber("id", workerId))
        }
      })
      id = id + 1
    })
    // Handle is executor running
    eventBus.registerHandler(ScriptingManagerVerticle.EVENT_IS_EXECUTOR_EXECUTING, { m: Message[JsonObject] =>
      val workerId = m.body.getInteger("id")
      m.reply(new JsonObject().putBoolean("isExecuting", deploymentMap.contains(workerId)))
    })
    // Handle terminate executor
    eventBus.registerHandler(ScriptingManagerVerticle.EVENT_TERMINATE_EXECUTOR, { m: Message[JsonObject] =>
      val workerId = m.body.getInteger("id")
      logger.info("Killing script executor id: " + workerId)
      val deploymentId = deploymentMap.get(workerId).get
      deploymentMap.remove(workerId)
      container.undeployModule(deploymentId)
    })
  }

}