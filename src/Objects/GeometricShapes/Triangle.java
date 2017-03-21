package Objects.GeometricShapes;

/*
 * Created by Юлия on 21.03.2017.
 */
public class Triangle {
    private PointXY apex1;
    private PointXY apex2;
    private PointXY apex3;

    public Triangle(PointXY a, PointXY b, PointXY c) {
        apex1 = a;
        apex2 = b;
        apex3 = c;
    }

    private double edgeLength(PointXY a, PointXY b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public double perimeter() {
        double a, b, c;
        a = edgeLength(apex1, apex2);
        b = edgeLength(apex2, apex3);
        c = edgeLength(apex3, apex1);
        return a + b + c;
    }

    public double square() {
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - edgeLength(apex1, apex2)) * (p - edgeLength(apex2, apex3)) * (p - edgeLength(apex3, apex1)));
    }
}
