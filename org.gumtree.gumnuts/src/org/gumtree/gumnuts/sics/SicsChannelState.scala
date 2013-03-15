package org.gumtree.gumnuts.sics

object SicsChannelState extends Enumeration {
  
  val DISCONNECTED = Value("disconnect")
  val CONNECTING = Value("connecting")
  val AUTHENICATING = Value("authenicating")
  val INITIALISING = Value("initialising")
  val CONNECTED = Value("connected")

}