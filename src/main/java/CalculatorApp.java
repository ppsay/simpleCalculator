import service.CommandService;
import service.model.CommandBuilder;
import service.model.SimpleCommand;
import service.model.SimpleCommandBuilder;

import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Калькулятор запущен!");
        System.out.println("Введите операцию над 2-мя числами:");
        String strCommand = scanner.nextLine();
        try {
            CommandBuilder commandBuilder = new SimpleCommandBuilder();
            SimpleCommand command = commandBuilder.commandBuild(strCommand);
            CommandService commandService = new CommandService(command);
            commandService.doOperation();
            commandService.printResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
