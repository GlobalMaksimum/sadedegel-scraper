package com.sadedegel

import java.nio.file.{Files, Paths}

import com.sadedegel.ScraperUtils._
import org.scalatest.funsuite.AnyFunSuite

class ScraperUtilsTest extends AnyFunSuite {

  test("List should have at least 1 element") {
    val cs = new CumhuriyetScraper
    assert(cs.getAuthorUrls.size > 1)
  }

  test("cleanContent function should not contain \\n characters and \\[email protected\\] text ") {

    val input = "2017 yılında ülkemizin enflasyon rejiminde bozulma emareleri gördük.\n Kur\n birkaç yıl üst üste ve " +
      "çift haneli değer kaybedince yükselen \n ithalat fiyatları bizi vurdu. [email protected]"

    assert(!cleanContent(input).contains("\\n") && !cleanContent(input).contains("\\[email"))
  }

  test("createArticleFileNameFromUrl function should return full path of file") {
    val absolultePath = createArticleFileNameFromUrl("https://www.milliyet.com" +
      ".tr/yazarlar/cagdas-ertuna/erisilebilir-sanat-icin-step-istanbul-6269844", "test")
    assert(absolultePath == "test/erisilebilir-sanat-icin-step-istanbul-6269844.txt")
  }

  test("writeToFile function should persist given article url to a txt file") {
    val articleUrl = "https://www.milliyet.com.tr/yazarlar/cagdas-ertuna/erisilebilir-sanat-icin-step-istanbul-6269844"
    val outputDir = "test-results"
    writeToFile(articleUrl, List(".article__content", ".article__detail"), outputDir)
    val fileName = s"${createArticleFileNameFromUrl(articleUrl, outputDir + "-" + getCurrentDate)}"
    assert(Files.readString(Paths.get(fileName)).size > 0)
  }
}
