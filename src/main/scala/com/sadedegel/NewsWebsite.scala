package com.sadedegel

trait NewsWebsite {

  def domain: String

  def startScraping() = {
    val authors = getAuthorUrls
    getArticlesOfAuthors(authors, domain)
  }

  def getAuthorUrls: List[String]

  def getArticlesOfAuthors(authorUrls: List[String], domain: String): Unit

  def writeArticlesToFile(articleUrl: String): Unit
}
