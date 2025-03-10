package lab5.Commands;

import lab5.tools.Consolka;
import lab5.tools.ExecutionResponse;

public class Exit extends Command {
    private final Consolka consolka;

    public Exit(Consolka consolka) {
        super("exit", "завершить программу (без сохранения в файл)");
        this.consolka = consolka;
    }
    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (!arguments[1].isEmpty()) {
            consolka.println("Неправильное количество аргументов!");
            consolka.println("Использование: '" + getName() + "'");
            return new ExecutionResponse(false, " ");
        }

        consolka.println("Завершение выполнения...");
        return new ExecutionResponse(true, " ");
    }
}