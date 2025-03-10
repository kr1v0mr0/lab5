package lab5.Commands;

import lab5.data.MusicGenre;
import lab5.managers.CollectionManager;
import lab5.tools.Consolka;
import lab5.tools.ExecutionResponse;

public class CountLessThanGenre extends Command{
    private final CollectionManager collectionManager;
    private final Consolka consolka;
    public CountLessThanGenre(Consolka consolka, CollectionManager collectionManager) {
        super("count_less_than_genre", "вывести количество элементов, значение поля genre которых меньше заданного");
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
        var level = MusicGenre.valueOf(arguments[0]).Level();
        int p=0;
        for (var e: collectionManager.getCollection().values()){
            if(e.getnumberOfParticipants()==null){return new ExecutionResponse( false, "всё пошло не по плану"); }
            if(e.getnumberOfParticipants()<level){
                p=p+1;
            }
        }
        consolka.println(p);
        return new ExecutionResponse(true,"всё получилось");

    }

}
