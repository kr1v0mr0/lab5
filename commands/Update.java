package lab5.Commands;

import lab5.managers.Ask;
import lab5.managers.CollectionManager;
import lab5.tools.Consolka;
import lab5.tools.ExecutionResponse;

/**
 * Команда 'update'. обновляет значение элемента коллекции, id которого равен заданному
 */
public class Update extends Command {

    private final Consolka consolka;
    private final CollectionManager collectionManager;

    public Update(Consolka consolka, CollectionManager collectionManager) {
        super("update <ID> {element}", "обновить значение элемента коллекции по ID");
        this.consolka = consolka;
        this.collectionManager = collectionManager;
    }

    @Override
    public ExecutionResponse apply(String[] arguments) {
        try {
            if (arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
            Integer id = -1;
            try { id = Integer.parseInt(arguments[1].trim()); } catch (NumberFormatException e) { return new ExecutionResponse(false, "ID не распознан"); }

            var old = collectionManager.byId(id);
            if (old == null || !collectionManager.getCollection().containsKey(old)) {
                return new ExecutionResponse(false, "Не существующий ID");
            }

            consolka.println("Создание новой группы:");
            var d = Ask.askMusicBand(consolka, old.getId());
            if (d != null && d.validate()) {
                collectionManager.remove(old.getId());
                collectionManager.add(d);
                collectionManager.update();
                return new ExecutionResponse(true,"Обновлено!");
            } else {
                return new ExecutionResponse(false, "Поля неверны");
            }
        } catch (Ask.AskBreak e) {
            return new ExecutionResponse(false, "Поля неверны");
        }
    }
}