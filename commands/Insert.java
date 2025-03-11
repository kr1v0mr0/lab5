package lab5.Commands;

import lab5.data.MusicBand;
import lab5.managers.CollectionManager;
import lab5.tools.Consolka;
import lab5.tools.ExecutionResponse;
import lab5.managers.*;


/**
 * Команда 'insert'. добавляет новый элемент с заданным ключом
 */
public class Insert extends Command {
    private final CollectionManager collectionManager;
    private final Consolka consolka;
    public Insert(Consolka consolka, CollectionManager collectionManager) {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.consolka = consolka;
        this.collectionManager = collectionManager;
    }

    @Override
    public ExecutionResponse apply(String[] arguments){
        if (arguments.length>2 || arguments[1].isEmpty()) return new ExecutionResponse(false, "неверные аргументы");
        consolka.println("* Создание новой музыкальной группы:");
        try {
            MusicBand d = Ask.askMusicBand(consolka, collectionManager.getFreeId());
            if (d!= null && d.validate()) {
                if (collectionManager.add(d)) return new ExecutionResponse(true, "Музыкальная группа добавлена");
                return new ExecutionResponse(false, "Такая группа уже есть");}
            else{
                return new ExecutionResponse(false, "Поля объекта не валидны");}
        }
        catch(Ask.AskBreak e) {
            return new ExecutionResponse(false, "ошибка ввода");
        }
    }
}
