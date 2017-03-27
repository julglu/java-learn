package Objects.accumulator;

/*
 * Created by Юлия on 22.03.2017.
 */
public interface Operation {

    int apply(int a1, int a2);
    double apply(double a1, double a2);
    long apply(long a1, long a2);

}
