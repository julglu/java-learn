package Objects.accumulator;

/**
 * Created by Юлия on 26.03.2017.
 */
public class Mod implements Operation {

    @Override
    public int apply(int a1, int a2) {
        if (a2 != 0)
            return a1 % a2;
        else return 0;
    }

    @Override
    public double apply(double a1, double a2) {
        if (a2 != 0)
            return a1 % a2;
        else return 0;
    }

    @Override
    public long apply(long a1, long a2) {
        if (a2 != 0)
            return a1 % a2;
        else return 0;
    }
}
