package recruiterbox.webcrawler.processPrototype;

import java.util.List;

import recruiterbox.webcrawler.exceptions.CrawlingException;
import recruiterbox.webcrawler.exceptions.LinkConnectionException;
import recruiterbox.webcrawler.exceptions.UnexpectedProcessException;

/**
 * @author gaurav.kumar 
 *         The actual process of processing the html document
 *         received by hitting a url is exhibited by an implementation of this
 *         interface
 */
public interface CrawlingProcess
{
  /**
   * The method makes a connection to the passed url, receives the response and
   * then process it to grab the links available on it.
   * 
   * @param url - The url to which connection is made and links from the HTML
   *          received in response are grabbed added to list of 'to be visited'
   *          links.
   * @throws CrawlingException - When link is found invalid.
   * @throws LinkConnectionException - When connection could not be made to the
   *           link.
   * @throws UnexpectedProcessException - Some unexpected process occurred due
   *           to which the link could not be visited.
   */
  public void crawl(String url)
    throws CrawlingException, LinkConnectionException, UnexpectedProcessException;

  /**
   * The method simply returns a list of all the links that are found in the
   * HTML response of a visited link.
   * 
   * @return - list of links found in response.
   */
  public List<String> getLinks();
}
