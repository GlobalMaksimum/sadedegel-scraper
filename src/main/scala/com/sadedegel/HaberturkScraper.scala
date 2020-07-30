package com.sadedegel

import com.sadedegel.ScraperUtils._

class HaberturkScraper extends NewsWebsite {
  val domain = "https://www.haberturk.com"

  override def getAuthorUrls: List[String] = {
    List("https://www.haberturk.com/htyazar/gokhan-sen",
      "https://www.haberturk.com/htyazar/oray-egin",
      "https://www.haberturk.com/htyazar/fatih-altayli-1001",
      "https://www.haberturk.com/htyazar/muharrem-sarikaya",
      "https://www.haberturk.com/htyazar/serdar-ali-celikler-1034",
      "https://www.haberturk.com/htyazar/abdurrahman-yildirim-1018",
      "https://www.haberturk.com/htyazar/murat-bardakci",
      "https://www.haberturk.com/htyazar/cuneyt-basaran",
      "https://www.haberturk.com/htyazar/prof-dr-temel-yilmaz",
      "https://www.haberturk.com/htyazar/serpil-yilmaz-2155"
    )
  }

  override def getArticlesOfAuthors(authorUrls: List[String], domain: String): Unit = {
    getArticles(authorUrls, domain, ".author-other-articles", writeArticlesToFile, "/", "")
  }

  override def writeArticlesToFile(articleUrl: String): Unit = {
    ScraperUtils.writeToFile(articleUrl, List(".content.type1.newsArticle"),
      "haberturk")
  }
}
