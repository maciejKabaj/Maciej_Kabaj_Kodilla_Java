package com.kodilla.sudoku.game;

public enum UserCommand {
    ADD("ADD"),
    CLEAR("CLEAR"),
    SOLVE("SUDOKU"),
    RESET("RESET"),
    CLOSE("CLOSE");

    private final String commandText;

    UserCommand(String commandText) {
        this.commandText = commandText;
    }

    public String getCommandText() {
        return commandText;
    }

    public static UserCommand fromString(String commandText) {
        for (UserCommand command : UserCommand.values()) {
            if (command.getCommandText().equalsIgnoreCase(commandText)) {
                return command;
            }
        }
        throw new IllegalArgumentException("Invalid command: " + commandText);
    }
}
