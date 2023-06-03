package service.model;

import utils.ArithmeticOperator;
import utils.RomeNumberUtils;

public class SimpleCommandBuilder implements CommandBuilder{
    private static final String ARAB_SYMB_REG = "\\d";
    private static final String ROME_SYMB_REG = "[A-Za-z]";

    private String cleanCommandString;
    private ArithmeticOperator operator;
    private int firstOperand;
    private int secondOperand;
    private boolean romeSymb = false;

    public SimpleCommand commandBuild(String command) {
        this.cleanCommandString = command.replaceAll("\\s", "").toUpperCase();
        detectOperator();
        validationCommand();
        detectOperands();
        checkAllowedOperands();

        return new SimpleCommand(command, operator, firstOperand, secondOperand, romeSymb);
    }

    private void validationCommand() throws IllegalArgumentException {
        if(containsRomeSymb() && containsArabSymb()) {
            throw new IllegalArgumentException("Операция может содержать одновременно только" +
                    " арабские или только римские цифры");
        }

        if(!isValidOperator()) {
            throw new IllegalArgumentException("Операция не содержит ни одного из операторов "
                    + ArithmeticOperator.getOperations().toString() + " или содержит более одного оператора");
        }
    }

    private boolean containsArabSymb() {
        String regex = ".*" + ARAB_SYMB_REG + ".*";
        return cleanCommandString.matches(regex);
    }

    private boolean containsRomeSymb() {
        String regex = ".*" + ROME_SYMB_REG + ".*";
        romeSymb = cleanCommandString.matches(regex);
        return romeSymb;
    }

    private void detectOperator() {
        String operatorStr = cleanCommandString.replaceAll("[" + ARAB_SYMB_REG + ROME_SYMB_REG + "]", "");
        this.operator = ArithmeticOperator.getOperatorBySymb(operatorStr);
    }

    private boolean isValidOperator() {
        return !ArithmeticOperator.INVALID.equals(operator);
    }

    private void detectOperands() {
        String[] operands = cleanCommandString.split("[" + operator.getSymb() + "]");
        if (operands.length != 2) {
            throw new IllegalArgumentException("Вы выражении должно быть 2 операнда");
        }

        if (containsRomeSymb()) {
            firstOperand = RomeNumberUtils.romanToArabic(operands[0]);
            secondOperand = RomeNumberUtils.romanToArabic(operands[1]);
        } else {
            firstOperand = Integer.parseInt(operands[0]);
            secondOperand = Integer.parseInt(operands[1]);
        }
    }

    private void checkAllowedOperands() {
        if (firstOperand < 1 || firstOperand > 10) {
            throw new IllegalArgumentException("Операнд не должен быть не менее 1 и не более 10");
        }

        if (secondOperand < 1 || secondOperand > 10) {
            throw new IllegalArgumentException("Операнд не должен быть не менее 1 и не более 10");
        }
    }
}
