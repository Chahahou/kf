package kfparser

import java.net.HttpURLConnection
import java.net.URL
import sun.net.www.http.HttpClient
import java.io.InputStream
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.core.MediaType
import jdk.nashorn.internal.ir.ObjectNode

object KFApp {

  private val APIRootURL = "http://www.keyforgegame.com/api"

  def main(args: Array[String]) {
    printDeck("f7332c24-9722-435b-b5b2-e3ee1b4422a9")
  }

  private def printDeck(deckID: String): Unit = {
    val client = ClientBuilder.newClient
    val webTarget = client.target(APIRootURL)
      .path("decks")
      .path(deckID)
    val response = webTarget.request(MediaType.APPLICATION_JSON).get
    val jsonStr = response.readEntity(classOf[String])
    println(jsonStr)
  }
}
