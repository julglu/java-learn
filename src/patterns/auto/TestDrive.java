package patterns.auto;

/**
 * Created by Юлия on 19.04.2017.
 */
public class TestDrive {
    public static void main(String[] args) {
        Car car=Factory.getFactory("ru").createCar();
        System.out.println(car.drive(100000));
    }
}
