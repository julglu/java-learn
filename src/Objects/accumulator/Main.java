package Objects.accumulator;

/**
 * Created by Юлия on 26.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        double[] val={0,16};
        Operation[] operations={new Plus(),new SquareRoot()};
        ArrayAccumulator acc=new ArrayAccumulator(val,operations);
        acc.calculate(2);

        for (double d:val){
            System.out.println(d);
        }
    }
}
