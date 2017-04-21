package patterns.auto;

/**
 * Created by Юлия on 19.04.2017.
 */
public abstract class Factory {

    private static Factory factory;
    abstract Car createCar();


    static Factory getFactory(String region) {
        if (region.equals("de")) {
            return BavariaMotors.setFactory();

        } else if (region.equals("jp")) {
            return ToyotaMotors.setFactory();

        } else if (region.equals("ru")) {
            return Vaz.setFactory();

        } else throw new RuntimeException("Invalid region");
    }
}
