package com.sadedegel

import com.sadedegel.ScraperUtils.getArticles

class YetkinReportsScraper extends NewsWebsite {
  val domain = ""

  override def getAuthorUrls: List[String] = {
    List("https://yetkinreport.com/blog/")
  }

  override def getArticlesOfAuthors(authorUrls: List[String], domain: String): Unit = {
    getArticles(authorUrls, domain, ".newsmag-title>h3", writeArticlesToFile, "page/", "/")
  }

  override def writeArticlesToFile(articleUrl: String): Unit = {
    ScraperUtils.writeToFile(articleUrl, List(".entry-content"),
      "yetkin-report")
  }
}
