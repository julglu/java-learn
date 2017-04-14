package Objects.calc;

/**
 * Created by Юлия on 13.04.2017.
 */
public enum Operation {
    PLUS, MINUS, MULTIPLY, DIVIDE;

    public static int apply(Operation o, int x,  int y){
        int rez=0;
        switch(o){
            case PLUS:
                return x+y;
            case MINUS:
                return x-y;
            case MULTIPLY:
                return x*y;
            case DIVIDE:
                return x/y;
        }
        return rez;
    }
}
