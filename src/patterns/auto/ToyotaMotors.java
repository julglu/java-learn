package patterns.auto;

/**
 * Created by Юлия on 19.04.2017.
 */
public class ToyotaMotors extends Factory {
    private static ToyotaMotors toyotaFactory;

    private ToyotaMotors() {
    }

    @Override
    Car createCar() {
        return new Toyota();
    }

    //@Override
    static Factory setFactory() {
        if (toyotaFactory == null)
            return new ToyotaMotors();
        else
            return toyotaFactory;
    }
}
