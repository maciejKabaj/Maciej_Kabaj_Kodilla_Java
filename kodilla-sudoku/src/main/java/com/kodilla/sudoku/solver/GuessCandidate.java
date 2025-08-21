package com.kodilla.sudoku.solver;

import com.kodilla.sudoku.structure.SudokuValue;

import java.util.ArrayList;
import java.util.List;

public class GuessCandidate {

    private final int row;
    private final int col;
    private final List<SudokuValue> values;

    public GuessCandidate(int row, int col, List<SudokuValue> values) {
        this.row = row;
        this.col = col;
        this.values = new ArrayList<>(values);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public List<SudokuValue> getValues() {
        return new ArrayList<>(values);
    }
}
