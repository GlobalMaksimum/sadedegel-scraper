package com.sadedegel

import com.sadedegel.ScraperUtils.getArticles

class HurriyetScraper extends NewsWebsite {
  val domain = "https://www.hurriyet.com.tr"

  val authorsUrl = "https://www.hurriyet.com.tr/yazarlar/tum-yazarlar/#hurriyetcomtr"

  override def getAuthorUrls(): List[String] = {
    List("https://www.hurriyet.com.tr/yazarlar/ilber-ortayli/",
      "https://www.hurriyet.com.tr/yazarlar/dogan-hizlan/",
      "https://www.hurriyet.com.tr/yazarlar/sina-afra/",
      "https://www.hurriyet.com.tr/yazarlar/onur-basturk/",
      "https://www.hurriyet.com.tr/yazarlar/kanat-atkaya/",
      "https://www.hurriyet.com.tr/yazarlar/ayse-arman/",
      "https://www.hurriyet.com.tr/yazarlar/ahmet-karabiyik",
      "https://www.hurriyet.com.tr/yazarlar/dr-basak-demiriz/",
      "https://www.hurriyet.com.tr/yazarlar/gila-benmayor/",
      "https://www.hurriyet.com.tr/yazarlar/gulse-birsel/",
      "https://www.hurriyet.com.tr/yazarlar/hakan-unsal/",
      "https://www.hurriyet.com.tr/yazarlar/ipek-ozbey/",
      "https://www.hurriyet.com.tr/yazarlar/mehmet-arslan/",
      "https://www.hurriyet.com.tr/yazarlar/mehmet-y-yilmaz/",
      "https://www.hurriyet.com.tr/yazarlar/melis-alphan/",
      "https://www.hurriyet.com.tr/yazarlar/murat-yetkin/",
      "https://www.hurriyet.com.tr/yazarlar/nedim-gursel/",
      "https://www.hurriyet.com.tr/yazarlar/nilgun-tekfidan-gumus/",
      "https://www.hurriyet.com.tr/yazarlar/nuran-cakmakci/",
      "https://www.hurriyet.com.tr/yazarlar/saffet-emre-tonguc/",
      "https://www.hurriyet.com.tr/yazarlar/sedat-ergin/",
      "https://www.hurriyet.com.tr/yazarlar/sefer-levent/",
      "https://www.hurriyet.com.tr/yazarlar/selcuk-sirin/",
      "https://www.hurriyet.com.tr/yazarlar/ugur-cebeci/",
      "https://www.hurriyet.com.tr/yazarlar/ugur-gurses/",
      "https://www.hurriyet.com.tr/yazarlar/yalcin-bayer/",
      "https://www.hurriyet.com.tr/yazarlar/zeynel-balci/",
      "https://www.hurriyet.com.tr/yazarlar/aysegul-domanic-yelce/",
      "https://www.hurriyet.com.tr/yazarlar/elif-congur/",
      "https://www.hurriyet.com.tr/yazarlar/emre-kizilkaya/",
      "https://www.hurriyet.com.tr/yazarlar/mesude-ersan/",
      "https://www.hurriyet.com.tr/yazarlar/sahver-kaya/",
      "https://www.hurriyet.com.tr/yazarlar/unal-cevikoz/",
    )
  }

  override def getArticlesOfAuthors(authorUrls: List[String], domain: String): Unit = {
    getArticles(authorUrls, domain, ".highlighted-box.mb20", writeArticlesToFile, "?p=", "")
  }

  override def writeArticlesToFile(articleUrl: String): Unit = {
    ScraperUtils.writeToFile(articleUrl, List(".article-content.news-text", ".rhd-all-article-detail"),
      "hurriyet")
  }

}
