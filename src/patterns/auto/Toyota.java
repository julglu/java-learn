package patterns.auto;

/**
 * Created by Юлия on 19.04.2017.
 */
public class Toyota implements Car {
    @Override
    public boolean drive(int distance) {
        if(distance<100000)
            return true;
        return false;
    }
}
