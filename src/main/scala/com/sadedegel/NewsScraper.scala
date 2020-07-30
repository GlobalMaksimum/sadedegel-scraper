package com.sadedegel

object NewsScraper {

  def main(args: Array[String]): Unit = {
    val newsWebsite = args(0)

    newsWebsite match {
      case "hurriyet" => {
        val hurriyetScraper = new HurriyetScraper
        hurriyetScraper.startScraping
      }
      case "milliyet" => {
        val milliyetScraper = new MilliyetScraper
        milliyetScraper.startScraping()
      }
      case "yetkin" => {
        val yetkinScraper = new YetkinReportsScraper
        yetkinScraper.startScraping()
      }
      case "cumhuriyet" => {
        val cumhuriyetScraper = new CumhuriyetScraper
        cumhuriyetScraper.startScraping()
      }
      case "haberturk" => {
        val haberturkScraper = new HaberturkScraper
        haberturkScraper.startScraping()
      }
      case _ =>
    }
  }
}