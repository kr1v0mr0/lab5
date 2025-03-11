package lab5.Commands;

import lab5.managers.CollectionManager;
import lab5.tools.Consolka;
import lab5.tools.ExecutionResponse;
/**
 * Команда 'replace_if_greater'. заменяет значение по ключу, если новое значение больше старого
 */
public class ReplaceIfGreater extends Command {
    private final CollectionManager collectionManager;
    private final Consolka consolka;
    public ReplaceIfGreater(Consolka consolka, CollectionManager collectionManager) {
        super("replace_if_greater", "заменить значение по количеству альбомов, если новое значение больше старого");
        this.consolka = consolka;
        this.collectionManager = collectionManager;
    }
    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (!arguments[1].isEmpty()) {
            consolka.println("Неправильное количество аргументов!");
            consolka.println("Использование: '" + getName() + "'");
            return new ExecutionResponse(false, " всё пошло не по плану ");
        }
        Integer cnt = -1;
        try { cnt = Integer.parseInt(arguments[1].trim()); } catch (NumberFormatException e) { return new ExecutionResponse(false, "Количество альбомов не распознано"); }
        for (var e: collectionManager.getCollection().values()){
            if(e.getAlbumsCount()>cnt){
                var ans = collectionManager.update(e);
                if(ans==false){ return new ExecutionResponse( false, "всё пошло не по плану"); }
                return new ExecutionResponse(true, "успешно удален");
            }
        }
        return null;
    }
}
