package service.model;

import utils.ArithmeticOperator;

public class SimpleCommand implements Command {

    private String commandString;
    private ArithmeticOperator operator;
    private int firstOperand;
    private int secondOperand;
    private boolean romeSymb;
    private int result;

    public SimpleCommand(String commandString, ArithmeticOperator operator, int firstOperand, int secondOperand, boolean romeSymb) {
        this.commandString = commandString;
        this.operator = operator;
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.romeSymb = romeSymb;
    }

    public ArithmeticOperator getOperator() {
        return operator;
    }

    public int getFirstOperand() {
        return firstOperand;
    }

    public int getSecondOperand() {
        return secondOperand;
    }

    @Override
    public boolean containsRomeSymb() {
        return romeSymb;
    }

    public void setCommandString(String commandString) {
        this.commandString = commandString;
    }

    public void setOperator(ArithmeticOperator operator) {
        this.operator = operator;
    }

    public void setFirstOperand(int firstOperand) {
        this.firstOperand = firstOperand;
    }

    public void setSecondOperand(int secondOperand) {
        this.secondOperand = secondOperand;
    }

    public void setRomeSymb(boolean romeSymb) {
        this.romeSymb = romeSymb;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    @Override
    public String toString() {
        return commandString;
    }
}
