package Objects.accumulator;

/*
 * Created by Юлия on 26.03.2017.
 */
public class ArrayAccumulator {
    private double[] values;
    private Operation[] operations;

    public ArrayAccumulator(double[] vals, Operation[] ops ){
        values=vals;
        operations=ops;
    }

    public void calculate(int x){
        for (int i = 0; i <values.length ; i++) {
            values[i]=operations[i].apply((int)values[i],x);
        }
    }
    public void calculate(double x){
        for (int i = 0; i <values.length ; i++) {
            values[i]=operations[i].apply((double)values[i],x);
        }
    }
    public void calculate(long x){
        for (int i = 0; i <values.length ; i++) {
            values[i]=operations[i].apply((long)values[i],x);
        }
    }
}
