package lab5.Commands;

import lab5.managers.CollectionManager;
import lab5.tools.Consolka;
import lab5.tools.ExecutionResponse;
public class Show extends Command {
    private final Consolka consolka;
    private final CollectionManager collectionManager;

    public Show(Consolka consolka, CollectionManager collectionManager) {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.consolka = consolka;
        this.collectionManager = collectionManager;
    }
    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");

        return new ExecutionResponse(true,collectionManager.toString());
    }
}
