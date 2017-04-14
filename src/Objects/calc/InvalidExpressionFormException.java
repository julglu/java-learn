package Objects.calc;

/*
 * Created by Юлия on 14.04.2017.
 */
public class InvalidExpressionFormException extends Exception {

    public InvalidExpressionFormException(String message) {
        super(message);
    }

    public InvalidExpressionFormException(String message, Throwable cause) {
        super(message, cause);
    }
}
