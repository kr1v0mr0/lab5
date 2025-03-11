package lab5.managers;

import lab5.Commands.Command;


import java.util.*;

public class CommandManager {
    private final Map<String, Command> commands = new LinkedHashMap();
    private final List<String> commandHistory = new ArrayList<>();


    public CommandManager() {
    }

    public void register(String commandName, Command command) {
        this.commands.put(commandName, command);
    }

    public Map<String, Command> getCommands() {
        return this.commands;
    }
    public List<String> getCommandHistory() {
        if(commandHistory.size()<8) { return commandHistory;}
        return commandHistory.subList(commandHistory.size()-8,commandHistory.size());
    }
    public void addToHistory(String command) {
        commandHistory.add(command);
    }
}