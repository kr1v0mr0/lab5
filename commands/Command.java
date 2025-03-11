package lab5.Commands;

import java.util.Objects;

/**
 * Абстрактная команда с именем и описанием
 */
public abstract class Command implements Executable {
    private final String name;
    private final String description;

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }
    /**
     * @return Название и использование команды.
     */
    public String getName() {
        return this.name;
    }
    /**
     * @return Описание команды.
     */
    public String getDescription() {
        return this.description;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            Command command = (Command)obj;
            return this.name.equals(command.name) && this.description.equals(command.description);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name, this.description});
    }

    public String toString() {
        return "Command{name='" + this.name + "', description='" + this.description + "'}";
    }
}
