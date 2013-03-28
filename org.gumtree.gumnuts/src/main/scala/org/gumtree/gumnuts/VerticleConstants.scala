package org.gumtree.gumnuts

import org.vertx.java.core.json.JsonObject

/**
 * Application constants
 */
trait VerticleConstants {

  val EMPTY_OBJECT = new JsonObject

  // SICS
  def CONFIG_SICS_HEADER = "sics"
  def CONFIG_SICS_HOST = "host"
  def CONFIG_SICS_PORT = "port"
  def CONFIG_SICS_LOGIN = "login"
  def CONFIG_SICS_PASSWORD = "password"
  def CONFIG_SICS_CHANNEL_NAME = "name"

  def CONST_SICS_CHANNEL_GENERAL = "general"
  def CONST_SICS_CHANNEL_STATUS = "status"

  // DAE
  def CONFIG_DAE_HEADER = "dae"
  def CONFIG_DAE_HOST = "host"
  def CONFIG_DAE_PORT = "port"
  def CONFIG_DAE_LOGIN = "login"
  def CONFIG_DAE_PASSWORD = "password"

  // REST
  def CONFIG_REST_HEADER = "rest"
  def CONFIG_REST_PORT = "port"

  // WS
  def CONFIG_WS_HEADER = "ws"
  def CONFIG_WS_URL = "url"

  // Web
  def CONFIG_WEB_HEADER = "web"

  // CRaSH
  def CONFIG_CRASH_HEADER = "crash"

}