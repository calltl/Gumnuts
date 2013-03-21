package org.gumtree.gumnuts

/**
 * Application constants
 */
trait VerticleConstants {

  // JVM
  def EVENT_JVM_GET_STATUS = "gumtree.jvm.getStatus"

  // SICS
  def EVENT_SICS_CHANNEL_SEND = "gumtree.sics.channel.send"
  def EVENT_SICS_CHANNEL_GET_STATUS = "gumtree.sics.channel.getStatus"
  def EVENT_SICS_CHANNEL_STATUS = "gumtree.sics.channel.status"
  def EVENT_SICS_MANAGER_CONNECT_CHANNEL = "gumtree.sics.manager.connectChannel"
  def EVENT_SICS_MANAGER_DISCONNECT_CHANNEL = "gumtree.sics.manager.disconnectChannel"
  def EVENT_SICS_MANAGER_GET_CHANNELS = "gumtree.sics.manager.getChannels"
    
  def EVENT_SICS_HDB_GET_COMPONENT = "gumtree.sics.hdb.getComponent"

  def CONFIG_SICS_HEADER = "sics"
  def CONFIG_SICS_HOST = "host"
  def CONFIG_SICS_PORT = "port"
  def CONFIG_SICS_LOGIN = "login"
  def CONFIG_SICS_PASSWORD = "password"
  def CONFIG_SICS_CHANNEL_NAME = "name"

  def CONST_SICS_CHANNEL_GENERAL = "general"
  def CONST_SICS_CHANNEL_STATUS = "status"

  // REST
  def CONFIG_REST_HEADER = "rest"
  def CONFIG_REST_PORT = "port"

  // Web
  def CONFIG_WEB_HEADER = "web"

}