package Objects.accumulator;

import Objects.LinkedList.LinkedList;
import Objects.arrayList.ArrayList;
import Objects.interfaces.List;
import Objects.interfaces.Stack;

/*
 * Created by Юлия on 26.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        /*double[] val={0,16};
        Operation[] operations={new Plus(),new SquareRoot()};
        ArrayAccumulator acc=new ArrayAccumulator(val,operations);
        acc.calculate(2);

        for (double d:val){
            System.out.println(d);
        }*/

        LazyAccumulator lazyAcc=new LazyAccumulator(new ArrayList());
        lazyAcc.add(1,new Plus());
        lazyAcc.add(3,new Minus());
        System.out.println(lazyAcc.calculate());

        lazyAcc.add(5, new Operation() {
            @Override
            public int apply(int a1, int a2) {
                return (a1+2)*a2;
            }

            @Override
            public double apply(double a1, double a2) {
                return (a1+2)*a2;
            }

            @Override
            public long apply(long a1, long a2) {
                return (a1+2)*a2;
            }
        });
        System.out.println(lazyAcc.calculate());
        System.out.println();
        Stack s=new LinkedList();
        LazyAccumulator lazyAccStack=new LazyAccumulator(s);
        lazyAccStack.add(1,new Plus());
        lazyAccStack.add(3,new Minus());
        System.out.println(lazyAccStack.calculate());

        lazyAccStack.add(5, new Operation() {
            @Override
            public int apply(int a1, int a2) {
                return (a1+2)*a2;
            }

            @Override
            public double apply(double a1, double a2) {
                return a1*a2;
            }

            @Override
            public long apply(long a1, long a2) {
                return a1*a2;
            }
        });
        System.out.println(lazyAccStack.calculate());
    }
}
