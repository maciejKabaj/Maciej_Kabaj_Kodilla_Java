package com.kodilla.sudoku.game;

import com.kodilla.sudoku.solver.SudokuSolver;
import com.kodilla.sudoku.structure.SudokuBoard;

import java.util.Scanner;

public class SudokuGame {

    private final SudokuBoard board;
    private final InputParser parser;
    private final Scanner scanner;
    private final SudokuPrinter printer;

    public SudokuGame() {
        this.board = new SudokuBoard();
        this.scanner = new Scanner(System.in);
        this.parser = new InputParser();
        this.printer = new SudokuPrinter();
    }

    public void playGame() {
        printer.printWelcomeMessage();
        printer.printBoard(board);

        boolean running = true;
        while (running) {
            printer.printPrompt();
            String command = scanner.nextLine();

            ParsedCommand parsedCommand;
            try {
                parsedCommand = parser.assessInput(command);
            } catch (IllegalArgumentException e) {
                printer.printInvalidInput(command);
                continue;
            }

            int row = parsedCommand.getRow();
            int col = parsedCommand.getCol();

            switch (parsedCommand.getCommand()) {
                case ADD:
                    board.getCell(row, col).setValue(parsedCommand.getValue());
                    break;
                case CLEAR:
                    board.getCell(row, col).clearValue();
                    break;
                case SOLVE:
                    SudokuBoard solved = SudokuSolver.getInstance().solve(board);
                    if (solved != null) {
                        printer.printSolvedBoard(solved);
                    } else {
                        printer.printUnsolvableMessage();
                    }
                    resetBoard();
                    printer.printResetMessage();
                    break;
                case RESET:
                    resetBoard();
                    printer.printResetMessage();
                    break;
                case CLOSE:
                    printer.printExitMessage();
                    running = false;
                    break;
            }

            if (running) {
                printer.printBoard(board);
            }
        }
    }

    public void resetBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board.getCell(row, col).clearValue();
            }
        }
    }
}
