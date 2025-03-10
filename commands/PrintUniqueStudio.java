package lab5.Commands;
import lab5.data.MusicBand;
import lab5.data.Studio;
import lab5.managers.CollectionManager;
import lab5.tools.Consolka;
import lab5.tools.ExecutionResponse;

import java.util.TreeSet;

public class PrintUniqueStudio extends Command {
    private final Consolka consolka;
    private final CollectionManager collectionManager;

    public PrintUniqueStudio(Consolka consolka, CollectionManager collectionManager) {
        super("print_unique_Studio", "вывести уникальные значения поля age всех элементов в коллекции");
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
        var beNull = false;
        var ts = new TreeSet<Studio>();
        for (MusicBand e : collectionManager.getCollection().values()) {
            if (e.getStudio() == null)
                beNull = true;
            else
                ts.add(e.getStudio());
        }
        if (beNull)
            consolka.println(" null");
        for (var e : ts)
            consolka.println(" " + e);
        return new ExecutionResponse(true, " ");
    }
}