package Objects.accumulator;

/*
 * Created by Юлия on 26.03.2017.
 */
public class SquareRoot implements Operation{

    @Override
    public int apply(int a1, int a2) {
        if(a1>=0)
            return (int)Math.pow(a1,1.0/a2);
        else return 0;
    }

    @Override
    public double apply(double a1, double a2) {
        if(a1>=0)
            return Math.pow(a1,1.0/a2);
        else return 0;
    }

    @Override
    public long apply(long a1, long a2) {
        if(a1>=0)
            return (long)Math.pow(a1,1.0/a2);
        else return 0;
    }
}
