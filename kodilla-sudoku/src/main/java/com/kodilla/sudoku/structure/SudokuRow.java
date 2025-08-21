package com.kodilla.sudoku.structure;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {

    private List<SudokuCell> cells;

    public SudokuRow() {
        populateRow();
    }

    private void populateRow() {
        cells = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            cells.add(new SudokuCell());
        }
    }

    public boolean containsValue(SudokuValue value) {
        for (SudokuCell cell : cells) {
            if (value.equals(cell.getValue())) {
                return true;
            }
        }
        return false;
    }

    public SudokuCell getCell(int index) {
        return cells.get(index);
    }

    public SudokuRow deepCopy() {
        SudokuRow newRow = new SudokuRow();
        for (int row = 0; row < 9; row++) {
            newRow.cells.set(row, this.cells.get(row).deepCopy());
        }
        return newRow;
    }
}
