package lab5.managers;
import lab5.data.Coordinates;
import lab5.data.MusicBand;
import lab5.data.MusicGenre;
import lab5.data.Studio;
import lab5.tools.Console;
import java.util.NoSuchElementException;

public class Ask {
    public static class AskBreak extends Exception {}

    public static MusicBand askMusicBand(Console consolka, int id) throws AskBreak {
        try {
            String name;
            while (true) {
                consolka.print("name: ");
                name = consolka.readln().trim();
                if (name.equals("exit")) throw new AskBreak();
                if (!name.isEmpty()) break;
            }
            var coordinates = askCoordinates(consolka);
            Integer numberOfParticipants;
            while (true) {
                consolka.print("numberOfParticipants: ");
                var p = consolka.readln().trim();
                if (p.equals("exit")) throw new AskBreak();
                if (!p.isEmpty()){
                    numberOfParticipants = Integer.parseInt(p);
                    break;
                };
            }
            long singlesCount;
            while (true) {
                consolka.print("singlesCount: ");
                var p = consolka.readln().trim();
                if (p.equals("exit")) throw new AskBreak();
                if (!p.isEmpty()){
                    singlesCount = Long.parseLong(p);
                    break;
                };
            }
            int albumsCount;
            while (true) {
                consolka.print("albumsCount: ");
                var p = consolka.readln().trim();
                if (p.equals("exit")) throw new AskBreak();
                if (!p.isEmpty()){
                    albumsCount = Integer.parseInt(p);
                    break;
                };
            }
            MusicGenre.names();
            MusicGenre genre;
            consolka.println(MusicGenre.names());
            while (true) {
                consolka.print("genre: ");
                var p = consolka.readln().trim();
                if (p.equals("exit")) throw new AskBreak();
                try {
                    genre = MusicGenre.valueOf(p);
                    break;
                }
                catch (IllegalArgumentException e){  }
            }
            Studio studio;
            try{
                studio = askStudio(consolka);}
            catch(AskBreak e){
                studio =null;
            }
            return new MusicBand(id, name, coordinates, numberOfParticipants, singlesCount, albumsCount, genre, studio);

        } catch (NoSuchElementException | IllegalStateException e) {
            consolka.printError("Ошибка чтения");
            return null;
        }
    }

    public static Coordinates askCoordinates(Console consolka) throws AskBreak {
        try {
            double x;
            while (true) {
                consolka.print("coordinates.x: ");
                var line = consolka.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try { x = Double.parseDouble(line); break; }catch(NumberFormatException e) { }
                }
            }
            long y;
            while (true) {
                consolka.print("coordinates.y: ");
                var line = consolka.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try { y = Long.parseLong(line); break; }catch(NumberFormatException e) { }
                }
            }
            return new Coordinates(x, y);
        } catch (NoSuchElementException | IllegalStateException e) {
            consolka.printError("Ошибка чтения");
            return null;
        }
    }

    public static Studio askStudio(Console consolka) throws AskBreak {
        String name;
        consolka.print("studio name: ");
        name = consolka.readln().trim();
        if (name.equals("exit")) throw new AskBreak();
        return new Studio(name);
    }

}

