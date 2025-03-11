package lab5.Commands;

import lab5.managers.CollectionManager;
import lab5.tools.Consolka;
import lab5.tools.ExecutionResponse;
/**
 * Команда 'count_greater_than_number_of_participants'. выводит количество элементов, значение поля numberOfParticipants которых больше заданного
 */
public class CountGreaterThanNumberOfParticipants extends Command{
    private final CollectionManager collectionManager;
    private final Consolka consolka;
    public CountGreaterThanNumberOfParticipants(Consolka consolka, CollectionManager collectionManager) {
        super("count_greater_than_number_of_participants", "вывести количество элементов, значение поля numberOfParticipants которых больше заданного");
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
        int p=0;
        Integer cnt = -1;
        try { cnt = Integer.parseInt(arguments[1].trim()); } catch (NumberFormatException e) { return new ExecutionResponse(false, "Количество альбомов не распознано"); }
        for (var e: collectionManager.getCollection().values()){
            if(e.getnumberOfParticipants()==null){return new ExecutionResponse( false, "всё пошло не по плану"); }
            if(e.getnumberOfParticipants()>cnt){
                p=p+1;
            }
        }
        consolka.println(p);
        return new ExecutionResponse(true,"всё получилось");
    }

}
