package com.kodilla.sudoku.game;

import com.kodilla.sudoku.structure.SudokuValue;

public class ParsedCommand {

    private final UserCommand command;
    private final int row;
    private final int col;
    private final SudokuValue value;

    public ParsedCommand(UserCommand command) {
        this.command = command;
        this.row = -1;
        this.col = -1;
        this.value = SudokuValue.EMPTY;
    }

    public ParsedCommand(UserCommand command, int row, int col, SudokuValue value) {
        this.command = command;
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public UserCommand getCommand() {
        return command;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public SudokuValue getValue() {
        return value;
    }
}
