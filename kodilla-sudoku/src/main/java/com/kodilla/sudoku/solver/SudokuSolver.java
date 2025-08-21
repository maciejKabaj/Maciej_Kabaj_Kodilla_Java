package com.kodilla.sudoku.solver;

import com.kodilla.sudoku.structure.SudokuBoard;
import com.kodilla.sudoku.structure.SudokuCell;
import com.kodilla.sudoku.structure.SudokuValue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class SudokuSolver {


    private static SudokuSolver instance;
    private final Deque<BacktrackState> backtrackStates = new ArrayDeque<>();

    private SudokuSolver() {
    }

    public static SudokuSolver getInstance() {
        if (instance == null) {
            return instance = new SudokuSolver();
        }
        return instance;
    }

    public SudokuBoard solve(SudokuBoard board) {
        backtrackStates.clear();
        SudokuBoard copy = board.deepCopy();
        return solveRecursive(copy);
    }

    private SudokuBoard solveRecursive(SudokuBoard board) {
        int[] coords = findEmptyCell(board);
        if (coords == null) {
            return board;
        }
        int row = coords[0];
        int col = coords[1];

        SudokuBoard result = tryValidPlacements(board, row, col);
        if (result != null) {
            return result;
        }
        result = attemptGuess(board);
        if (result != null) return result;

        return restorePreviousGuess();
    }

    public GuessCandidate findBestGuessCandidate(SudokuBoard board) {
        int bestRow = -1;
        int bestCol = -1;
        List<SudokuValue> bestValues = null;
        int minSize = Integer.MAX_VALUE;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                SudokuCell cell = board.getCell(row, col);
                if (cell.isEmpty()) {
                    List<SudokuValue> available = cell.getAvailableValues();
                    if (available.size() > 1 && isBetterCandidate(available, minSize)) {
                        bestRow = row;
                        bestCol = col;
                        bestValues = available;
                        minSize = available.size();
                    }
                }
            }
        }
        if (bestValues != null) {
            return createCandidate(bestRow, bestCol, bestValues);
        }
        return null;
    }

    private SudokuBoard tryValidPlacements(SudokuBoard board, int row, int col) {
        SudokuCell cell = board.getCell(row, col);
        for (SudokuValue value : cell.getAvailableValues()) {
            if (isValidPlacement(board, row, col, value)) {
                cell.setValue(value);
                SudokuBoard result = solveRecursive(board);
                if (result != null) {
                    return result;
                }
                cell.clearValue();
            }
        }
        return null;
    }

    private SudokuBoard attemptGuess(SudokuBoard board) {
        GuessCandidate candidate = findBestGuessCandidate(board);
        if (candidate == null) {
            return null;
        }
        SudokuValue guess = selectNextGuess(candidate.getValues());
        BacktrackState state = createBacktrackState(board, candidate, guess);
        this.backtrackStates.addLast(state);
        SudokuBoard guessedBoard = tryGuess(board, candidate, guess);
        return solveRecursive(guessedBoard);
    }

    private SudokuBoard restorePreviousGuess() {
        if (!backtrackStates.isEmpty()) {
            BacktrackState lastState = backtrackStates.removeLast();
            SudokuBoard restoredBoard = restoreFromBacktrack(lastState);
            return solveRecursive(restoredBoard);
        }
        return null;
    }


private boolean isBetterCandidate(List<SudokuValue> available, int minSize) {
        return available.size() < minSize;
    }

    private GuessCandidate createCandidate(int row, int col, List<SudokuValue> values) {
        return new GuessCandidate(row, col, values);
    }

    private BacktrackState createBacktrackState(SudokuBoard board, GuessCandidate candidate, SudokuValue value) {
        return new BacktrackState(board, candidate.getRow(), candidate.getCol(), value);
    }

    private SudokuBoard tryGuess(SudokuBoard board, GuessCandidate candidate, SudokuValue value) {
        SudokuBoard guessedBoard = board.deepCopy();
        int row = candidate.getRow();
        int col = candidate.getCol();
        SudokuCell cell = guessedBoard.getCell(row, col);
        cell.setValue(value);
        return guessedBoard;
    }

    private SudokuValue selectNextGuess(List<SudokuValue> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }
        return values.get(0);
    }


    private SudokuBoard restoreFromBacktrack(BacktrackState state) {
        SudokuBoard restoredBoard = state.getBoard();
        SudokuCell cell = restoredBoard.getCell(state.getRow(), state.getCol());
        cell.removeValue(state.getGuessedValue());
        return restoredBoard;
    }

    private int[] findEmptyCell(SudokuBoard board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board.getCell(row,col).isEmpty()) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    private boolean isValidPlacement(SudokuBoard board, int row, int col, SudokuValue value) {
        return !isInRow(board, row, value)
                && !isInColumn(board, col, value)
                && !isInBox(board, row, col, value);
    }

    private boolean isInRow(SudokuBoard board, int row, SudokuValue value) {
        for (int col = 0; col < 9; col++) {
            if (board.getCell(row, col).getValue() == value) {
                return true;
            }
        }
        return false;
    }

    private boolean isInColumn(SudokuBoard board, int col, SudokuValue value) {
        for (int row = 0; row < 9; row++) {
            if (board.getCell(row, col).getValue() == value) {
                return true;
            }
        }
        return false;
    }

    private boolean isInBox(SudokuBoard board, int row, int col, SudokuValue value) {
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if (board.getCell(r, c).getValue() == value) {
                    return true;
                }
            }
        }
        return false;
    }
}
