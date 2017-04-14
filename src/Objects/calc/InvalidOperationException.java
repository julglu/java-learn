package Objects.calc;

/*
 * Created by Юлия on 14.04.2017.
 */
public class InvalidOperationException extends Exception {

    public InvalidOperationException(String message) {
        super(message);
    }

    public InvalidOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
