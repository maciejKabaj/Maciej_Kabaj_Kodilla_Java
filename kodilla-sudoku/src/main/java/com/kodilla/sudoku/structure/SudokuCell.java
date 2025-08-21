package com.kodilla.sudoku.structure;

import java.util.ArrayList;
import java.util.List;

public class SudokuCell {

    private SudokuValue value;
    private List<SudokuValue> availableValues;

    public SudokuCell() {
        value = SudokuValue.EMPTY;
        assignAllAvailableValues();
    }

    private void assignAllAvailableValues() {
        availableValues = new ArrayList<>();
        for (SudokuValue value : SudokuValue.values()) {
            if (!value.isEmpty()) {
                availableValues.add(value);
            }
        }
    }

    public boolean isEmpty() {
        return value.isEmpty();
    }

    public void removeValue(SudokuValue value) {
        availableValues.remove(value);
    }

    public SudokuValue getValue() {
        return value;
    }

    public void setValue(SudokuValue value) {
        if (!this.value.isEmpty()) {
            System.out.println("Value already set!");
        } else {
            this.value = value;
            availableValues.clear();
        }
    }

    public void clearValue() {
        this.value = SudokuValue.EMPTY;
        assignAllAvailableValues();
    }

    public List<SudokuValue> getAvailableValues() {
        return new ArrayList<>(availableValues);
    }

    public void addAvailableValue(SudokuValue value) {
        availableValues.add(value);
    }

    public SudokuCell deepCopy() {
        SudokuCell newCell = new SudokuCell();
        newCell.value = this.value;
        newCell.availableValues = new ArrayList<>(this.availableValues);
        return newCell;
    }
}
