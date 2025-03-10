package lab5.Commands;
import lab5.tools.Consolka;
import lab5.managers.CollectionManager;
import lab5.tools.ExecutionResponse;

public class Save extends Command {
    private final Consolka consolka;
    private final CollectionManager collectionManager;

    public Save(Consolka consolka, CollectionManager collectionManager) {
        super("save", "сохранить коллекцию в файл");
        this.consolka = consolka;
        this.collectionManager = collectionManager;
    }

    public ExecutionResponse apply(String[] arguments) {
        if (!arguments[1].isEmpty()) {
            consolka.println("Неправильное количество аргументов!");
            consolka.println("Использование: '" + getName() + "'");
            return new ExecutionResponse(false, "Не удалось сохранить коллекцию");
        }

        collectionManager.saveCollection();
        return new ExecutionResponse(true, "Коллекция сохранена");
    }
}