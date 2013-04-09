package org.gumtree.gumnuts.scripting

import org.gumtree.gumnuts.ScalaVerticle
import org.python.util.jython
import javax.script.ScriptEngineManager
import org.vertx.java.core.json.JsonObject
import java.lang.Long

class JythonExecutorVerticle extends ScalaVerticle {

  def start() = {
    vertx.setTimer(100, { id: Long =>
      val manager = new ScriptEngineManager
      logger.info("Execution has been started")
      manager.getEngineByName("jython").eval(getConfig.getString("script"))
      logger.info("Execution has been completed")
      eventBus.send(ScriptingManagerVerticle.EVENT_TERMINATE_EXECUTOR, new JsonObject().putNumber("id", getConfig.getInteger("id")))
    })
  }

}