package com.kodilla.sudoku.structure;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {

    private List<SudokuRow> rows;

    public SudokuBoard() {
        populateBoard();
    }

    private void populateBoard() {
        rows = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            rows.add(new SudokuRow());
        }
    }

    public SudokuCell getCell(int row, int col) {
        return rows.get(row).getCell(col);
    }

    public SudokuBoard deepCopy() {
        SudokuBoard newBoard = new SudokuBoard();
        for (int i = 0; i < 9; i++) {
            newBoard.rows.set(i, this.rows.get(i).deepCopy());
        }
        return newBoard;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 9; row++) {
            if (row == 3 || row == 6) {
                sb.append("------+-------+------\n");
            }
            for (int col = 0; col < 9; col++) {
                if (col == 3 || col == 6) {
                    sb.append("| ");
                }
                SudokuCell cell = rows.get(row).getCell(col);
                SudokuValue value = cell.getValue();
                sb.append(value.isEmpty() ? ". " : value.getNumericValue() + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
