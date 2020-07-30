package com.sadedegel

import com.sadedegel.ScraperUtils.getArticles

class MilliyetScraper extends NewsWebsite {
  val domain = "https://www.milliyet.com.tr"

  override def getAuthorUrls: List[String] = {
    List("https://www.milliyet.com.tr/yazarlar/mete-belovacikli/",
      "https://www.milliyet.com.tr/yazarlar/abbas-guclu/",
      "https://www.milliyet.com.tr/yazarlar/hakki-ocal/",
      "https://www.milliyet.com.tr/yazarlar/didem-ozel-tumer/",
      "https://www.milliyet.com.tr/yazarlar/verda-ozer/",
      "https://www.milliyet.com.tr/yazarlar/asu-maro/",
      "https://www.milliyet.com.tr/yazarlar/belma-akcura/",
      "https://www.milliyet.com.tr/cadde/berna-lacin/",
      "https://www.milliyet.com.tr/yazarlar/bilal-mese/",
      "https://www.milliyet.com.tr/cadde/cuneyt-sadic/",
      "https://www.milliyet.com.tr/yazarlar/dilara-kocak/",
      "https://www.milliyet.com.tr/yazarlar/filiz-aygunduz/",
      "https://www.milliyet.com.tr/yazarlar/menderes-ozel/",
      "https://www.milliyet.com.tr/yazarlar/samed-karagoz/",
      "https://www.milliyet.com.tr/yazarlar/sezin-sivri/")
  }

  override def getArticlesOfAuthors(authorUrls: List[String], domain: String): Unit = {
    getArticles(authorUrls, domain, ".box-preview", writeArticlesToFile, "?page=", "")
  }

  override def writeArticlesToFile(articleUrl: String): Unit = {
    ScraperUtils.writeToFile(articleUrl, List(".article__content", ".article__detail"),
      "milliyet")
  }
}
