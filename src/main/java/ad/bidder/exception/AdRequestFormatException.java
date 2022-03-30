package ad.bidder.exception;

/**
 * @author natalija
 */
public class AdRequestFormatException extends Exception {
    public AdRequestFormatException() {
    }

    public AdRequestFormatException(String message) {
        super(message);
    }

    public AdRequestFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
