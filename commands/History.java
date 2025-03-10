package lab5.Commands;

import lab5.managers.CommandManager;
import lab5.tools.Consolka;
import lab5.tools.ExecutionResponse;


public class History extends Command {
    private final Consolka consolka;
    private final CommandManager commandManager;

    public History(Consolka consolka, CommandManager commandManager) {
        super("history", "Вывыодит историю команд");
        this.consolka = consolka;
        this.commandManager = commandManager;
    }
    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (!arguments[1].isEmpty()) {
            consolka.println("Неправильное количество аргументов!");
            consolka.println("Использование: '" + getName() + "'");
            return new ExecutionResponse(false, " ");
        }

        commandManager.getCommandHistory().forEach(command -> {
            consolka.println(" " + command);
        });
        return new ExecutionResponse(true, " ");
    }
}