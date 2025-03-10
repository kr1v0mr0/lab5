package lab5.Commands;

import lab5.tools.Consolka;
import lab5.tools.ExecutionResponse;

public class ExecuteScript extends Command {
    private final Consolka consolka;

    public ExecuteScript(Consolka consolka) {
        super("execute_script <file_name>", "исполнить скрипт из указанного файла");
        this.consolka = consolka;
    }
    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (arguments[1].isEmpty()) {
            consolka.println("Неправильное количество аргументов!");
            consolka.println("Использование: '" + getName() + "'");
            return new ExecutionResponse(false, " ");
        }

        consolka.println("Выполнение скрипта '" + arguments[1] + "'...");
        return new ExecutionResponse(true, " ");
    }
}