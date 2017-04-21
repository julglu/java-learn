package patterns.auto;

/**
 * Created by Юлия on 19.04.2017.
 */
public class BMW implements Car {
    @Override
    public boolean drive(int distance) {
        if(distance<1000000)
            return true;
        return false;
    }
}
