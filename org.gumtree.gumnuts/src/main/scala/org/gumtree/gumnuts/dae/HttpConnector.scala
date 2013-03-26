package org.gumtree.gumnuts.dae

import org.apache.commons.httpclient.HttpClient
import org.apache.commons.httpclient.Credentials
import org.apache.commons.httpclient.UsernamePasswordCredentials
import org.apache.commons.httpclient.auth.AuthScope
import scala.collection.mutable.Map

object HttpConnector {

  val KEY_LOGIN = "login"
  val KEY_PASSWORD = "password"
  val KEY_PROXY_HOST = "proxyHost"
  val KEY_PROXY_PORT = "proxyPort"

}
class HttpConnector {

  lazy val client: HttpClient = getClient
  val parameters: Map[String, String] = Map()

  private def getClient(): HttpClient = {
    val client = new HttpClient

    // Set proxy if available
    try {
      val proxyHost = parameters(HttpConnector.KEY_PROXY_HOST)
      val proxyPort = parameters(HttpConnector.KEY_PROXY_PORT)
      client.getHostConfiguration().setProxy(proxyHost, Integer.parseInt(proxyPort))
    } catch {
      case e: Exception =>
    }

    // Set credentials if login information supplied
    client.getParams().setAuthenticationPreemptive(true)
    val user = parameters(HttpConnector.KEY_LOGIN)
    val password = parameters(HttpConnector.KEY_PASSWORD)
    if (user != null && password != null) {
      val defaultcreds = new UsernamePasswordCredentials(user, password)
      client.getState().setCredentials(AuthScope.ANY, defaultcreds);
    }
    return client
  }

}