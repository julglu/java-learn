package Objects.accumulator;

/*
 * Created by Юлия on 24.03.2017.
 */
public class Pow extends Operation {
    @Override
    public int apply(int a1, int a2) {
        int rez = a1;
        for (int i = 1; i < a2; i++) {
            rez *= a1;
        }
        return rez;
    }

    @Override
    public double apply(double a1, double a2) {
        double rez = a1;
        for (int i = 1; i < a2; i++) {
            rez *= a1;
        }
        return rez;
    }

    @Override
    public long apply(long a1, long a2) {
        long rez = a1;
        for (int i = 1; i < a2; i++) {
            rez *= a1;
        }
        return rez;
    }
}
