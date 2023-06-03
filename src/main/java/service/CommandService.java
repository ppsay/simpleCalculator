package service;

import service.model.SimpleCommand;
import utils.ArithmeticOperator;
import utils.RomeNumberUtils;

public class CommandService {

    private final SimpleCommand command;

    public CommandService(SimpleCommand command) {
        this.command = command;
    }

    public void doOperation() {
        int o1 = command.getFirstOperand();
        int o2 = command.getSecondOperand();
        ArithmeticOperator operator = command.getOperator();
        int result = 0;
        switch(operator) {
            case SUM:
                result = o1 + o2;
                break;
            case MINUS:
                result = o1 - o2;
                if(command.containsRomeSymb() && result < 0){
                    throw new IllegalArgumentException("Результат вычисления римских чисел не может быть < 0");
                }
                break;
            case DIV:
                result = o1 / o2;
                break;
            case MULT:
                result = o1 * o2;
                break;
            default:
                break;
        }
        command.setResult(result);
    }

    public void printResult() {
        System.out.println(String.format("%s = %s", command, formattingResult()));
    }

    private String formattingResult() {
        int result = command.getResult();
        return command.containsRomeSymb() ? RomeNumberUtils.arabicToRoman(result) : String.valueOf(result);
    }
}
