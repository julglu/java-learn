package Objects.exceptions;

/**
 * Created by Юлия on 12.04.2017.
 */
public class getAbsentElementException extends RuntimeException {
    public getAbsentElementException() {
        super();
    }

    public getAbsentElementException(String message) {
        super(message);
    }

    public getAbsentElementException(String message, Throwable cause) {
        super(message, cause);
    }

}
