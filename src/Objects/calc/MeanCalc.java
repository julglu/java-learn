package Objects.calc;

import java.util.Scanner;

/*
 * Created by Юлия on 13.04.2017.
 */
public class MeanCalc {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("Please, enter some expression to calculate. Example: 5 + 4\n" +
                        "You may also use variables, but they should be initiated first.\n" +
                        "Example:\n" +
                        "> x = 5\n" +
                        "> y = 7\n" +
                        "> x + y\n" +
                        "Don't forget to separate symbols by spaces.");

                String expr = s.nextLine();
                if (expr.matches("\\d+ . \\d+"))
                    DigitCalculate(expr);
                else if (expr.matches("\\w+ = \\d+"))
                    VariableCalculate(expr);
                else
                    throw new InvalidExpressionFormException("Expression " + expr + " has invalid syntax");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void DigitCalculate(String str) throws Exception {
        int x, y, rez;
        try {
            x = Integer.parseInt(str.substring(0, str.indexOf(' ')));
            y = Integer.parseInt(str.substring(str.lastIndexOf(' ') + 1));
            Operation o = getOperation(str);
            rez = Operation.apply(o, x, y);
            System.out.println(rez);
        } catch (InvalidOperationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new InvalidOperandException("Operands in expression " + str + " should be integer");
        }
    }

    private static void VariableCalculate(String str) {
        int rez = 0;
        Variable x, y;
        try {
            x = getVariable(str);
            str = s.nextLine();
            if (str.matches("\\w+ = \\d+")) {
                y = getVariable(str);
                str = s.nextLine();
                if (!str.matches(x.name + " . " + y.name)) {
                    throw new InvalidExpressionFormException("Expression " + str + " has invalid syntax");
                }
            } else if (str.matches(x.name + " . \\d+")) {
                y = new Variable(Integer.parseInt(str.substring(str.lastIndexOf(' ') + 1)));
            } else
                throw new InvalidExpressionFormException("Expression " + str + " has invalid syntax");
            Operation operation = getOperation(str);
            rez = Operation.apply(operation, x.value, y.value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(rez);
    }

    private static Variable getVariable(String str) throws InvalidOperandException {
        String varName = str.substring(0, str.indexOf('=') - 1);
        int varValue;
        try {
            varValue = Integer.parseInt(str.substring(str.lastIndexOf(' ') + 1));
        } catch (Exception e) {
            throw new InvalidOperandException("Operands in expression " + str + " should be integer");
        }
        return new Variable(varName, varValue);
    }

    private static Operation getOperation(String str) throws InvalidOperationException {
        String operation = str.substring(str.indexOf(' ') + 1, str.lastIndexOf(' '));
        switch (operation) {
            case "+":
                return Operation.PLUS;
            //break;
            case "-":
                return Operation.MINUS;
            //break;
            case "*":
                return Operation.MULTIPLY;
            //break;
            case "/":
                return Operation.DIVIDE;
            // break;
            default:
                throw new InvalidOperationException("Expression " + str + " should contain only +,-,*,/ operations");
        }
    }

    private static class Variable {
        String name;
        int value;

        Variable(String name, int value) {
            this.name = name;
            this.value = value;
        }

        Variable(int value) {
            this.name = "y";
            this.value = value;
        }
    }
}
