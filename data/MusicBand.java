package lab5.data;
import lab5.tools.*;
import lab5.tools.Validatable;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class MusicBand extends Element implements Validatable {
    private Integer id;//Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name;//Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer numberOfParticipants; //Поле может быть null, Значение поля должно быть больше 0
    private long singlesCount; //Значение поля должно быть больше 0
    private int albumsCount; //Значение поля должно быть больше 0
    private MusicGenre genre; //Поле может быть null
    private Studio studio; //Поле не может быть null

    public MusicBand(int id, String name, Coordinates coordinates, ZonedDateTime creationDate, int numberOfParticipants, long singlesCount, int albumsCount, MusicGenre genre, Studio studio){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.numberOfParticipants = numberOfParticipants;
        this.singlesCount = singlesCount;
        this.albumsCount = albumsCount;
        this.genre = genre;
        this.studio = studio;
    }



    public MusicBand(int id, String name, Coordinates coordinates, int numberOfParticipants,long singlesCount, int albumsCount, MusicGenre genre, Studio studio){
        this(id, name, coordinates,ZonedDateTime.now(), numberOfParticipants, singlesCount, albumsCount, genre, studio);
    }
    @Override
    public String toString() {
        return "MusicBAnd{\"id\": " + id + ", " +
                "\"name\": \"" + name + "\", " +
                "\"creationDate\": \"" + creationDate.format(DateTimeFormatter.ISO_DATE_TIME) + "\", " +
                "\"coordinates\": \"" + coordinates + "\", " +
                "\"numberOfParticipants\": \"" + numberOfParticipants + "\", " +
                "\"singlesCount\": \"" + singlesCount + "\", " +
                "\"albumsCount\": \"" + albumsCount + "\", " +
                "\"genre\": "+ (genre == null ? "null" : "\""+genre+"\"") +
                "\"studio\": \"" + studio + "\"" + "}";
    }

    @Override
    public boolean validate() {
        if (id == null || id <= 0) return false;
        if (name == null || name.isEmpty()) return false;
        if (creationDate == null) return false;
        if (coordinates == null || !coordinates.validate()) return false;
        if (numberOfParticipants<=0) return false;
        if (singlesCount <= 0) return false;
        if (albumsCount <= 0) return false;
        if (studio == null) return false;
        return true;
    }

    @Override
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public java.time.ZonedDateTime getCreationDate() {
        return creationDate;
    }
    public Integer getnumberOfParticipants() {
        return numberOfParticipants;
    }
    public long getSinglesCount() {
        return singlesCount;
    }
    public int getAlbumsCount() {
        return albumsCount;
    }
    public MusicGenre getGenre() {
        return genre;
    }
    public Studio getStudio() {
        return studio;
    }
    public int compareTo(MusicBand element) {
        return (int)(this.singlesCount - element.getSinglesCount());
    }
}

