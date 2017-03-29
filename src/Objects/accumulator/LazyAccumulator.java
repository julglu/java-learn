package Objects.accumulator;

import Objects.interfaces.List;
import Objects.interfaces.Stack;
import java.util.Iterator;

/*
 * Created by Юлия on 28.03.2017.
 */
public class LazyAccumulator {

    private List l;
    private Stack s;
    private String className;

    public LazyAccumulator(List l) {
        this.l = l;
        className = "List";
    }

    public LazyAccumulator(Stack s) {
        this.s = s;
        className = "Stack";
    }

    public void add(int a, Operation oper) {
        if (className.equals("List")) {
            l.add(new IntermedOperation(a, oper));
        } else {
            s.push(new IntermedOperation(a, oper));
        }
    }

    public int calculate() {
        int rez = 0;
        if (className.equals("List")) {
            Iterator iter = l.iterator();
            int index = 0;
            while (iter.hasNext()) {
                IntermedOperation io = (IntermedOperation) l.remove(index);
                rez = io.op.apply(rez, io.val);
            }
        } else {
            while (true) {
                IntermedOperation io = (IntermedOperation) s.poll();
                if (io == null)
                    break;
                rez = io.op.apply(rez, io.val);
            }
        }
        return rez;
    }

    static class IntermedOperation {
        int val;
        Operation op;

        IntermedOperation(int val, Operation op) {
            this.val = val;
            this.op = op;
        }
    }
}
