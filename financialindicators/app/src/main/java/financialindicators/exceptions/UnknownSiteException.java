package financialindicators.exceptions;

public class UnknownSiteException extends RuntimeException {

    public UnknownSiteException(String message) {
        super(message);
    }

    public UnknownSiteException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
