package utils;

import java.util.ArrayList;
import java.util.List;

public enum ArithmeticOperator {
    SUM ("+"),
    MINUS ("-"),
    DIV ("/"),
    MULT ("*"),
    INVALID ("INVALID");

    private String symb;
    private static List<String> operators;

    static {
        operators = new ArrayList<>();
        operators.add(SUM.symb);
        operators.add(MINUS.symb);
        operators.add(DIV.symb);
        operators.add(MULT.symb);
    }

    ArithmeticOperator(String symb){
        this.symb = symb;
    }

    public String getSymb(){
        return symb;
    }

    public static ArithmeticOperator getOperatorBySymb(String symb) {
        for (ArithmeticOperator operator : ArithmeticOperator.values()) {
            if(operator.getSymb().equals(symb)) {
                return operator;
            }
        }
        return INVALID;
    }

    public static List<String> getOperations() {
        return operators;
    }
}
