package com.sadedegel

import java.nio.file.{Files, Paths}
import java.time.LocalDate
import java.time.format.DateTimeFormatter

import com.typesafe.scalalogging.StrictLogging
import org.jsoup.Jsoup

import scala.jdk.CollectionConverters._

object ScraperUtils extends StrictLogging {

  def getArticles(authorUrls: List[String], domain: String, articlesDivClassName: String, writeArticles:
  (String) => Unit, paginationPrefix: String, paginationSuffix: String) = {
    authorUrls.foreach(au => {
      logger.info(s"Starting scraping for author url: $au")

      var paginationIndex = 1
      while (paginationIndex > 0) {
        val fullUrl = au + paginationPrefix + paginationIndex + paginationSuffix
        logger.info(s"Scraping articles in: $fullUrl")
        val doc = Jsoup.connect(fullUrl).timeout(45000).get()
        val articleDiv = doc.select(articlesDivClassName)
        if (articleDiv != null && articleDiv.first() != null && articleDiv.first().childNodeSize() > 1) {
          val links = articleDiv.select("a[href]").asScala
          links.map(link => link.attr("href")).map(l => writeArticles(domain + l))
          paginationIndex = paginationIndex + 1
        } else {
          paginationIndex = -1
        }
      }
    })
  }

  def writeToFile(articleUrl: String, articleDivClassNames: List[String], outputDir: String): Unit = {
    logger.info(s"Starting scraping for article $articleUrl")
    try {
      val docs = Jsoup.connect(articleUrl).get()
      val matchedDivClassName = articleDivClassNames.filter(cn => docs.select(cn).hasText)(0)
      val el = docs.select(matchedDivClassName)

      if (el.size() > 0) {
        val article = cleanContent(el.get(0).text())
        //Set file name for article
        val outputDirWithDate = s"$outputDir-$getCurrentDate"
        Files.createDirectories(Paths.get(outputDirWithDate))
        val fullFileName = createArticleFileNameFromUrl(articleUrl, outputDirWithDate)
        Files.writeString(Paths.get(fullFileName), article)
      }
    }
    catch {
      case e: Exception => logger.error("An error occurred!")
    }
    finally {
      logger.info(s"Finished scraping for article: $articleUrl successfully")
    }
  }

  def cleanContent(articleText: String): String = {
    articleText.replace("\\n", "").split("\\[email protected\\]")(0)
  }

  def createArticleFileNameFromUrl(articleUrl: String, outputDir: String): String = {
    val split = articleUrl.split("/")
    s"$outputDir/${split(split.size - 1)}.txt"
  }

  def getCurrentDate(): String = {
    val today = LocalDate.now();
    today.format(DateTimeFormatter.ofPattern("dd-MM-yy"));
  }

}
