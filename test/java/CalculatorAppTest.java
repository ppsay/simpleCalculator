import org.junit.Test;
import service.CommandService;
import service.model.CommandBuilder;
import service.model.SimpleCommand;
import service.model.SimpleCommandBuilder;
import static org.junit.Assert.assertEquals;

public class CalculatorAppTest {

    @Test
    public void checkArabianCommand() {
        String commandStr = "1 + 2";
        int result = 3;
        CommandBuilder commandBuilder = new SimpleCommandBuilder();
        SimpleCommand command = commandBuilder.commandBuild(commandStr);
        CommandService commandService = new CommandService(command);
        commandService.doOperation();
        assertEquals(result, command.getResult());
    }

    @Test
    public void checkRomanCommand() throws Exception {
        String commandStr = "VI / III";
        int result = 2;
        CommandBuilder commandBuilder = new SimpleCommandBuilder();
        SimpleCommand command = commandBuilder.commandBuild(commandStr);
        CommandService commandService = new CommandService(command);
        commandService.doOperation();
        assertEquals(result, command.getResult());
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkInvalidCommand() {
        String commandStr = "VI / 1";
        CommandBuilder commandBuilder = new SimpleCommandBuilder();
        commandBuilder.commandBuild(commandStr);
    }
}
