package recruiterbox.webcrawler.exceptions;

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
