package com.kodilla.sudoku.game;

import com.kodilla.sudoku.structure.SudokuValue;

public class InputParser {

    public ParsedCommand assessInput(String input) {
        if (input.matches("^[0-8],[0-8],[1-9]$")) {
            return parseAddCommand(input);
        } else if (input.matches("^[0-8],[0-8],CLEAR$")) {
            return parseClearCommand(input);
        } else if ("SUDOKU".equals(input)) {
            return new ParsedCommand(UserCommand.SOLVE);
        } else if ("RESET".equals(input)) {
            return new ParsedCommand(UserCommand.RESET);
        } else if ("CLOSE".equals(input)) {
            return new ParsedCommand(UserCommand.CLOSE);
        } else {
            throw new IllegalArgumentException("Unrecognized input '" + input + "'");
        }
    }

    private ParsedCommand parseAddCommand(String input) {
            String[] parts = input.split(",");
            return new ParsedCommand(UserCommand.ADD,
                    Integer.parseInt(parts[0]),
                    Integer.parseInt(parts[1]),
                    SudokuValue.fromInt(Integer.parseInt(parts[2])));
    }

    private ParsedCommand parseClearCommand(String input) {
        String[] parts = input.split(",");
        return new ParsedCommand(UserCommand.CLEAR,
                Integer.parseInt(parts[0]),
                Integer.parseInt(parts[1]),
                SudokuValue.EMPTY);
    }
}
