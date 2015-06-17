package recruiterbox.webcrawler;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import recruiterbox.webcrawler.crawlerPrototype.Crawler;
import recruiterbox.webcrawler.exceptions.CrawlingException;
import recruiterbox.webcrawler.exceptions.LinkConnectionException;
import recruiterbox.webcrawler.exceptions.UnexpectedProcessException;
import recruiterbox.webcrawler.process.SpiderLeg;

/**
 * @author gaurav.kumar
 * <p>
 *    This class acts as the crawler. The class contains the functionality
 *    to keep track of the urls that have already been visited, urls that
 *    are next to be visited, finding out the url that will be visited next
 *    etc.
 * </p>
 */
public class Spider implements Crawler
{
  /**
   *  Constant to specify the maximum number of urls that can be visited.
   */
  private static final Integer MAX_NUMBER_OF_URLS = 100;
  
  /**
   * Constant to represent 0th index of list.
   */
  private final int FIRST_ELEMENT_INDEX = 0;
  
  /**
   * The list that contain the list of Urls that are yet to be visited. 
   */
  private List<String> urlsToVisit = new LinkedList<String>();
 
  /**
   *  The list that contain the list of Urls that have already been visited.
   */
  private Set<String> urlVisited = new HashSet<String>();
  /**
   * An instance of SpiderLeg class.
   */
  private SpiderLeg spiderLeg;
  
  private final Logger LOGGER = Logger.getLogger(Spider.class);


  /* 
   * @see recruiterbox.webcrawler.crawlerPrototype.Crawler#startCrawling(java.lang.String)
   */
  public void startCrawling(String url)
  {
    String currentUrl;
    while (urlVisited.size() < MAX_NUMBER_OF_URLS)              // Until number of urls visited are less than max number of urls that can be visited.
    {
      if (urlsToVisit.isEmpty())                                // It means no url has been visited yet. 
      {
        currentUrl = url;
        this.urlVisited.add(currentUrl);
      }
      else                                                     // Urls have been visited. We need to fetch the next url to be visited from the repository of links that were found on different visited links.
      {
        currentUrl = this.getNextUrlToVisit();
      }
      try
      {
        spiderLeg.crawl(currentUrl);
      }
      catch (CrawlingException ce)                             // If a url could not be visited, do not count it as visited.
      { 
        urlVisited.remove(currentUrl);
      }
      catch (LinkConnectionException lce)
      {
        urlVisited.remove(currentUrl);
      }
      catch (UnexpectedProcessException upe)
      {
        urlVisited.remove(currentUrl);
      }

      this.urlsToVisit.addAll(spiderLeg.getLinks());
    }
    LOGGER.info(MAX_NUMBER_OF_URLS + " LInks visited Successfully");
  }

  /* 
   * @see recruiterbox.webcrawler.crawlerPrototype.Crawler#getNextUrlToVisit()
   */
  public String getNextUrlToVisit()
  {
    String nextUrl;
    do
    {
      nextUrl = urlsToVisit.remove(FIRST_ELEMENT_INDEX);
    }
    while (urlVisited.contains(nextUrl));
    urlVisited.add(nextUrl);
    return nextUrl;
  }

  /**
   * Getter method for SpiderLeg instance
   * @return spiderLeg - An instance of <a>SpiderLeg</a> class.
   */
  public SpiderLeg getSpiderLeg()
  {
    return spiderLeg;
  }

  /**
   * Setter method for SpiderLeg instance
   * @param spiderLeg - SpiderLeg instance to be set
   */
  public void setSpiderLeg(SpiderLeg spiderLeg)
  {
    this.spiderLeg = spiderLeg;
  }
}
