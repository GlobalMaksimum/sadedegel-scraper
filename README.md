<a href="http://sadedegel.ai"><img src="https://sadedegel.ai/dist/img/logo-2.png?s=280&v=4" width="125" height="125" align="right" /></a>

# SadedeGel Scraper  
This web scraper is developed to meet the data requirements of [SadedeGel](https://github.com/GlobalMaksimum/sadedegel) library. It scrapes data from news websites and stores them as .txt files. Developed as a part of [Açık Kaynak Hackathon Programı 2020](https://www.acikhack.com/).


[![License](https://img.shields.io/pypi/l/sadedegel)](https://github.com/GlobalMaksimum/sadedegel-scraper/blob/master/LICENSE)
![Last Commit](https://img.shields.io/github/last-commit/globalmaksimum/sadedegel-scraper?style=plastic&logo=GitHub)

## 💬 Where to ask questions

The SadedeGel project is maintained by [@globalmaksmum](https://github.com/GlobalMaksimum) AI team members
[@dafajon](https://github.com/dafajon),
[@askarbozcan](https://github.com/askarbozcan),
[@mccakir](https://github.com/mccakir) and 
[@husnusensoy](https://github.com/husnusensoy). 

| Type                     | Platforms                                              |
| ------------------------ | ------------------------------------------------------ |
| 🚨 **Bug Reports**       | [GitHub Issue Tracker]                                 |
| 🎁 **Feature Requests**  | [GitHub Issue Tracker]                                 |

[github issue tracker]: https://github.com/GlobalMaksimum/sadedegel-scraper/issues
  
## How it works  
* Gets author urls of given news website  
* Gets article urls of each author  
* Scrapes data from the article and write to a .txt file  
  
## Install  
    git clone https://github.com/GlobalMaksimum/sadedegel-scraper.git 
    cd sadedegel-chrome-extension 
    sbt assembly  
You will get the jar under ./target/scala-<version>/
  
## Example Run  
    nohup java -jar sadedegel-scraper-assembly-0.3.jar "hurriyet" > hurriyet.out &
Check for hurriyet-<dd-MM-yyyy> directory for .txt files.  
      
## For Developers  
You can add support for additional news sources by extending <b>NewsWebsite</b> Trait.

Example:
```
import com.sadedegel.ScraperUtils.getArticles

class HurriyetScraper extends NewsWebsite {
  val domain = "https://www.hurriyet.com.tr"
  val authorsUrl = "https://www.hurriyet.com.tr/yazarlar/tum-yazarlar/#hurriyetcomtr"
  override def getAuthorUrls(): List[String] = {
    List("https://www.hurriyet.com.tr/yazarlar/ilber-ortayli/",
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
```
