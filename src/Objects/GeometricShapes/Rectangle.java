package Objects.GeometricShapes;

/*
 * Created by Юлия on 21.03.2017.
 */
public class Rectangle {
    private PointXY apex1;
    private PointXY apex2;

    public Rectangle(PointXY a, PointXY b) {
        apex1 = a;
        apex2 = b;
    }

    public int perimeter() {
        return 2 * (Math.abs(apex2.x - apex1.x) + Math.abs(apex2.y - apex1.y));
    }

    public int square() {
        return Math.abs(apex2.x - apex1.x) * Math.abs(apex2.y - apex1.y);
    }
}
