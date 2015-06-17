package recruiterbox.webcrawler.exceptions;


/**
 * @author gaurav.kumar 
 * A class representing an exception that will be thrown
 * when connection could not be made a link.
 */
public class LinkConnectionException extends Exception
{
  public LinkConnectionException() {

  }

  public LinkConnectionException(String message) {
      super (message);
  }

  public LinkConnectionException(Throwable cause) {
      super (cause);
  }

  public LinkConnectionException(String message, Throwable cause) {
      super (message, cause);
  }
}
