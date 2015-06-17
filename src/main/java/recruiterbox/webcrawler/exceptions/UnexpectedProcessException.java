package recruiterbox.webcrawler.exceptions;


/**
 * @author gaurav.kumar
 * A class that represent an exception which will be thrown when link could be parsed for some reason. 
 */
public class UnexpectedProcessException extends Exception
{
  public UnexpectedProcessException() {

  }

  public UnexpectedProcessException(String message) {
      super (message);
  }

  public UnexpectedProcessException(Throwable cause) {
      super (cause);
  }

  public UnexpectedProcessException(String message, Throwable cause) {
      super (message, cause);
  }
}
