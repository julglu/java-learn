package Objects.exceptions;

/**
 * Created by Юлия on 12.04.2017.
 */
public class modifyingWhileIterationException extends RuntimeException {
    public modifyingWhileIterationException() {
        super();
    }

    public modifyingWhileIterationException(String message) {
        super(message);
    }

    public modifyingWhileIterationException(String message, Throwable cause) {
        super(message, cause);
    }

}