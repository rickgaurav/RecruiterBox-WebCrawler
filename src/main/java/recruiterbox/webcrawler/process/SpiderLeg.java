package recruiterbox.webcrawler.process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import recruiterbox.webcrawler.exceptions.CrawlingException;
import recruiterbox.webcrawler.exceptions.LinkConnectionException;
import recruiterbox.webcrawler.exceptions.UnexpectedProcessException;
import recruiterbox.webcrawler.processPrototype.CrawlingProcess;

/**
 * @author gaurav.kumar 
 * 
 * This class acts as a processor for Crawling. All
 * processing related to crawling is done in this class.
 */
public class SpiderLeg implements CrawlingProcess
{
  private final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
  private final String SELECT_ELEMENT = "a[href]";
  private List<String> links = new ArrayList<>();
  private Document htmlDocument;
  private final Logger LOGGER = Logger.getLogger(SpiderLeg.class);

  /*
   * 
   * @see
   * recruiterbox.webcrawler.processPrototype.CrawlingProcess#crawl(java.lang.String)
   */
  public void crawl(String url)
    throws CrawlingException, LinkConnectionException, UnexpectedProcessException
  {
    try
    {
      Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);            
      Document htmlDocument = connection.get();
      this.htmlDocument = htmlDocument;
      if (connection.response().statusCode() == 200)
      {
        LOGGER.debug("Connection made to Link");
        System.out.println("\n Visiting Received web page at " + url);
      }
      if (!connection.response().contentType().contains("text/html"))
      {
        LOGGER.error("Link did not return HTML");
        System.out.println("Failed: Retrieved something other than HTML");
        throw new CrawlingException("The link does not return a HTML response");

      }
      Elements linksOnPage = htmlDocument.select(SELECT_ELEMENT);
      System.out.println("Found (" + linksOnPage.size() + ") links");
      for (Element link : linksOnPage)
      {
        this.links.add(link.absUrl("href"));
      }
    }
    catch (IllegalArgumentException e)
    {
      LOGGER.error("Link not valid" + url);
      throw new CrawlingException("The Link is not a valid one");
    }
    catch (IOException ioe)
    {
      LOGGER.error("Connection could not be made to Link" + url);
      throw new LinkConnectionException();
    }
    catch (Exception e)
    {
      LOGGER.error("Unexpected error occured with url "+ url);
      throw new UnexpectedProcessException("Unexpected error occured");
    }

  }

  /*
   * (non-Javadoc)
   * @see recruiterbox.webcrawler.processPrototype.CrawlingProcess#getLinks()
   */
  public List<String> getLinks()
  {
    return this.links;
  }

  /**
   * Getter method for htmlDocument.
   * 
   * @return- an instance of document.
   */
  public Document getHtmlDocument()
  {
    return htmlDocument;
  }

  /**
   * Setter method for htmlDocument.
   * 
   * @param htmlDocument - An instance of htmlDocument to be set.
   */
  public void setHtmlDocument(Document htmlDocument)
  {
    this.htmlDocument = htmlDocument;
  }

}
