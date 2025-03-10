package lab5.Commands;

import lab5.managers.CollectionManager;
import lab5.tools.Consolka;
import lab5.tools.ExecutionResponse;

import java.util.Set;

public class Clear extends Command{
    private final Consolka consolka;
    private final CollectionManager collectionManager;

    public Clear(Consolka consolka, CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.consolka = consolka;
        this.collectionManager = collectionManager;
    }
    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (!arguments[1].isEmpty()) {
            consolka.println("Неправильное количество аргументов!");
            consolka.println("Использование: '" + getName() + "'");
            return new ExecutionResponse(false, " ");
        }
        Set<Integer> keys = collectionManager.getCollection().keySet();
        //var isFirst = true;
        for(var e: keys){
            collectionManager.remove(e);
        }
        collectionManager.update();
        consolka.println("Коллекция очищена!");
        return new ExecutionResponse(false, " ");
    }
}
