package com.sadedegel

import com.sadedegel.ScraperUtils._
import com.typesafe.scalalogging.StrictLogging

class CumhuriyetScraper extends NewsWebsite with StrictLogging {
  val domain = "https://www.cumhuriyet.com.tr"

  override def getAuthorUrls: List[String] = {

    List("https://cumhuriyet.com.tr/koseyazari/379",
      "https://cumhuriyet.com.tr/koseyazari/22",
      "https://cumhuriyet.com.tr/koseyazari/61",
      "https://cumhuriyet.com.tr/koseyazari/70",
      "https://cumhuriyet.com.tr/koseyazari/387",
      "https://cumhuriyet.com.tr/koseyazari/386",
      "https://cumhuriyet.com.tr/koseyazari/380",
      "https://cumhuriyet.com.tr/koseyazari/414",
      "https://cumhuriyet.com.tr/koseyazari/9",
      "https://cumhuriyet.com.tr/koseyazari/96",
      "https://cumhuriyet.com.tr/koseyazari/58",
      "https://cumhuriyet.com.tr/koseyazari/52",
      "https://cumhuriyet.com.tr/koseyazari/30",
      "https://cumhuriyet.com.tr/koseyazari/12",
      "https://cumhuriyet.com.tr/koseyazari/188",
      "https://cumhuriyet.com.tr/koseyazari/11"
    )
  }

  override def getArticlesOfAuthors(authorUrls: List[String], domain: String): Unit = {
    getArticles(authorUrls, domain, ".yazilar", writeArticlesToFile, "/", "/")
  }

  override def writeArticlesToFile(articleUrl: String): Unit = {
    writeToFile(articleUrl, List(".haberMetni"), "cumhuriyet")
  }
}
