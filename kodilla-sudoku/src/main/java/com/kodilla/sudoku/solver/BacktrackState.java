package com.kodilla.sudoku.solver;

import com.kodilla.sudoku.structure.SudokuBoard;
import com.kodilla.sudoku.structure.SudokuValue;

public class BacktrackState {

    private final SudokuBoard board;
    private final int row;
    private final int col;
    SudokuValue guessedValue;

    public BacktrackState(SudokuBoard board, int row, int col, SudokuValue guessedValue) {
        this.board = board.deepCopy();
        this.row = row;
        this.col = col;
        this.guessedValue = guessedValue;
    }

    public SudokuBoard getBoard() {
        return board;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public SudokuValue getGuessedValue() {
        return guessedValue;
    }
}
