package recruiterbox.webcrawler.exceptions;

public class CrawlingException extends Exception
{
  public CrawlingException() {

  }

  public CrawlingException(String message) {
      super (message);
  }

  public CrawlingException(Throwable cause) {
      super (cause);
  }

  public CrawlingException(String message, Throwable cause) {
      super (message, cause);
  }
}
