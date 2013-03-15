package org.gumtree.gumnuts

trait VerticleConstants {

  // JMX
  def ACTION_GET_JVM_STATUS = "gumtree.jvm.getStatus"

  // SICS
  def ACTION_CHANNEL_CONNECT = "gumtree.sics.channel.connect"
  def ACTION_CHANNEL_DISCONNECT = "gumtree.sics.channel.disconnect"
  def ACTION_CHANNEL_SEND = "gumtree.sics.channel.send"
    
  def EVENT_CHANNEL_SEND = "gumtree.sics.channel.reply"  
  def EVENT_CHANNEL_STATUS = "gumtree.sics.channel.status"
  
  def CONFIG_CHANNEL_NAME = "name"
  def CONFIG_CHANNEL_HOST = "host"
  def CONFIG_CHANNEL_PORT = "port"
  def CONFIG_CHANNEL_LOGIN = "login"
  def CONFIG_CHANNEL_PASSWORD = "password"

  def CHANNEL_GENERAL = "general"
  def CHANNEL_STATUS = "status"

}