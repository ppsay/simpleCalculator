package service.model;

import utils.ArithmeticOperator;

public interface Command {
    ArithmeticOperator getOperator();
    int getFirstOperand();
    int getSecondOperand();
    boolean containsRomeSymb();
}
