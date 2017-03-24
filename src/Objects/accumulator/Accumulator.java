package Objects.accumulator;

/*
 * Created by Юлия on 22.03.2017.
 */
public class Accumulator {
    private double value;
    Operation operation;

    public Accumulator(Operation o) {
        operation = o;
    }

    public Accumulator(int v, Operation o) {
        value = v;
        operation = o;
    }

    public Accumulator(double v, Operation o) {
        value = v;
        operation = o;
    }

    public Accumulator(long v, Operation o) {
        value = v;
        operation = o;
    }

    public int calculate(int a) {
        return operation.apply((int) value, a);
    }

    public double calculate(double a) {
        return operation.apply(value, a);
    }

    public long calculate(long a) {
        return operation.apply((long) value, a);
    }

    public double getValue() {
        return value;
    }

}
