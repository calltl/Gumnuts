package org.gumtree.gumnuts

trait VerticleConstants {

  // JVM
  def ACTION_JVM_GET_STATUS = "gumtree.jvm.getStatus"

  // SICS
  def ACTION_SICS_CHANNEL_SEND = "gumtree.sics.channel.send"
  def ACTION_SICS_CHANNEL_GET_STATUS = "gumtree.sics.channel.getStatus"

  def EVENT_SICS_CHANNEL_STATUS = "gumtree.sics.channel.status"
  
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

  // Web
  def CONFIG_WEB_HEADER = "web"

}