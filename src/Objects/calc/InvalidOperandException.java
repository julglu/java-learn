package Objects.calc;

/*
 * Created by Юлия on 14.04.2017.
 */
public class InvalidOperandException extends Exception {

    public InvalidOperandException(String message){
        super(message);
    }

    public InvalidOperandException(String message, Throwable cause){
        super(message, cause);
    }
}
