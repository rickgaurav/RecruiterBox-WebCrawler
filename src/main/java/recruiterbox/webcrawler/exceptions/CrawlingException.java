package recruiterbox.webcrawler.exceptions;

/**
 * @author gaurav.kumar 
 * A class that represent an exception, which will be
 * thrown when a link is not valid.
 */
public class CrawlingException extends Exception
{
  public CrawlingException()
  {

  }

  public CrawlingException(String message)
  {
    super(message);
  }

  public CrawlingException(Throwable cause)
  {
    super(cause);
  }

  public CrawlingException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
