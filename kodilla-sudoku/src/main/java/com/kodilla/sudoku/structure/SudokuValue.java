package com.kodilla.sudoku.structure;

public enum SudokuValue {
    EMPTY(-1),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9);

    private final int numericValue;

    SudokuValue(int numericValue) {
        this.numericValue = numericValue;
    }

    public int getNumericValue() {
        return numericValue;
    }

    public boolean isEmpty() {
        return this == EMPTY;
    }

    public static SudokuValue fromInt(int number) {
        for (SudokuValue value : SudokuValue.values()) {
            if (value.numericValue == number) {  // simple switch would do but isn't it beautiful?
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid number: " + number);
    }
}
