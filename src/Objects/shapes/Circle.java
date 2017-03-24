package Objects.shapes;

/*
 * Created by Юлия on 22.03.2017.
 */
public class Circle extends Shape {
    private int r;

    public Circle(int rad) {
        r = rad;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * Math.pow(r, 2);
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * r;
    }
}
