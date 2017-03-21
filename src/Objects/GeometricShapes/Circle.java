package Objects.GeometricShapes;

/*
 * Created by Юлия on 21.03.2017.
 */
public class Circle {
    private PointXY center;
    private PointXY point;

    public Circle(PointXY point1, PointXY point2) {
        point = point2;
        center = point1;
    }

    private double radius() {
        return Math.sqrt(Math.pow(center.x - point.x, 2) + Math.pow(center.y - point.y, 2));
    }

    public double circumference() {
        double r = radius();
        return 2 * Math.PI * r;
    }

    public double square() {
        double r = radius();
        return Math.PI * Math.pow(r, 2);
    }
}
