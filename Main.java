package lab5;

import lab5.Commands.*;
import lab5.data.Coordinates;
import lab5.data.MusicBand;
import lab5.managers.CollectionManager;
import lab5.managers.CommandManager;
import lab5.managers.DumpManager;
import lab5.tools.Consolka;
import lab5.tools.Runner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var consolka = new Consolka();
        String envVar = System.getenv("PATH_TO_JSON");
        if (envVar != null && !envVar.isEmpty()) {
            Path path = Paths.get(envVar);

            try {
                if (Files.notExists(path)) {
                    Files.createFile(path);
                    System.out.println("Файл успешно создан: " + path.toAbsolutePath());
                } else {
                    System.out.println("Файл уже существует: " + path.toAbsolutePath());
                }
            } catch (IOException e) {
                System.out.println("Ошибка при создании файла: " + e.getMessage());
            }
        } else {
            System.out.println("Переменная окружения PATH_TO_JSON не установлена");
            if (args.length == 0) {
                consolka.println(
                        "Введите имя загружаемого файла как аргумент командной строки");
                System.exit(1);
            }}

            var dumpManager = new DumpManager(envVar, consolka);
            var collectionManager = new CollectionManager(dumpManager);
            if (!collectionManager.init()) {
                System.exit(1);
            }

            var commandManager = new CommandManager() {{
                register("help", new Help(this));
                register("history", new History(consolka, this));
                register("info", new Info(consolka, collectionManager));
                register("show", new Show(consolka, collectionManager));
                register("clear", new Clear(consolka, collectionManager));
                register("save", new Save(consolka, collectionManager));
                register("execute_script", new ExecuteScript(consolka));
                register("exit", new Exit(consolka));
                register("print_unique_studio", new PrintUniqueStudio(consolka, collectionManager));
                register("insert", new Insert(consolka, collectionManager));
                register("update", new Update(consolka, collectionManager));
                register("remove_key", new RemoveKey(consolka, collectionManager));
                register("replace_if_greater", new ReplaceIfGreater(consolka, collectionManager));
                register("remove_lower_key", new RemoveLowerKey(consolka, collectionManager));
                register("count_less_than_genre", new CountLessThanGenre(consolka, collectionManager));
                register("count_greater_than_number_of_participants", new CountGreaterThanNumberOfParticipants(consolka, collectionManager));
            }};
            new Runner(consolka, commandManager).interactiveMode();

    }
}

