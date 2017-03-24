package Objects.accumulator;

/*
 * Created by Юлия on 24.03.2017.
 */
public class Multiply extends Operation {
    @Override
    public int apply(int a1, int a2) {
        return a1 * a2;
    }

    @Override
    public double apply(double a1, double a2) {
        return a1 * a2;
    }

    @Override
    public long apply(long a1, long a2) {
        return a1 * a2;
    }
}
