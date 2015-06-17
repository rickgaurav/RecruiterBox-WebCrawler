package recruiterbox.webcrawler.crawlerPrototype;

/**
 * @author gaurav.kumar 
 * 
 * A prototype for the crawler. Any crawler implementation
 * must implement this interface.
 */
public interface Crawler
{
  
  /**
   * The method finds the next url to be visited and call the API that grabs all
   * the links on a visited link.
   * 
   * @param url - The starting url.
   */
  public void startCrawling(String url);

  /**
   * The method fetches the next url that will be visited next. It makes sure
   * that the url that have already been visited are not visited again.
   * 
   * @return - The next url to be visited to grab links.
   */
  public String getNextUrlToVisit();
}
