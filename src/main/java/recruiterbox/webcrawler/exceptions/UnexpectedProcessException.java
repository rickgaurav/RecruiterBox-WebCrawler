package recruiterbox.webcrawler.exceptions;

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
