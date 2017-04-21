package patterns.auto;

/**
 * Created by Юлия on 19.04.2017.
 */
public class BavariaMotors extends Factory {
   private static BavariaMotors bavariaFactory;

    private BavariaMotors() {
    }

    static Factory setFactory() {
        if (bavariaFactory == null)
            return new BavariaMotors();
        else
            return bavariaFactory;
    }

    @Override
    Car createCar() {
        return new BMW();
    }
}
