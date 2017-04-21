package patterns.auto;

/**
 * Created by Юлия on 19.04.2017.
 */
public class Vaz extends Factory {
    private static Vaz vazFactory;

    private Vaz() {}

    static Factory setFactory() {
        if (vazFactory == null)
            return new Vaz();
        else
            return vazFactory;
    }

    @Override
    Car createCar() {
        return new Lada();
    }


}
