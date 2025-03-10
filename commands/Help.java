package lab5.Commands;
import lab5.managers.CommandManager;
import lab5.tools.ExecutionResponse;

import java.util.stream.Collectors;

public class Help extends Command {
    private CommandManager commandManager;
    public Help(CommandManager commandManager){
        super("help","вывести справку по доступным командам");
        this.commandManager = commandManager;
    }
    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");

        return new ExecutionResponse(true, commandManager.getCommands().values().stream().map(command -> String.format(" %-35s%-1s%n", command.getName(), command.getDescription())).collect(Collectors.joining("\n")));
    }
}
