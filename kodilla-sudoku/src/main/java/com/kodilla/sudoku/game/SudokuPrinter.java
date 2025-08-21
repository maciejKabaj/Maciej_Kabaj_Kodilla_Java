package com.kodilla.sudoku.game;

import com.kodilla.sudoku.structure.SudokuBoard;

public class SudokuPrinter {

    public void printWelcomeMessage() {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║         Welcome to Sudoku Solver!        ║");
        System.out.println("╚══════════════════════════════════════════╝\n");
        System.out.println("Commands:");
        System.out.println("  - Enter a value: row,col,value (e.g., 2,3,9)");
        System.out.println("  - Remove a value: row,col,CLEAR");
        System.out.println("  - Solve the board: SUDOKU");
        System.out.println("  - Reset board: RESET");
        System.out.println("  - Exit game: CLOSE");
        System.out.println("------------------------------------------\n");
    }

    public void printBoard(SudokuBoard board) {
        System.out.println(board);
    }

    public void printPrompt() {
        System.out.print("Enter command: \n");
    }

    public void printInvalidInput(String input) {
        System.out.println("Invalid command: '" + input + "'. Please try again.");
    }

    public void printSolvedBoard(SudokuBoard board) {
        System.out.println("\nSolved Sudoku board:");
        System.out.println(board);
    }

    public void printResetMessage() {
        System.out.println("Board has been reset.\n");
    }

    public void printExitMessage() {
        System.out.println("\nThanks for playing. Goodbye!");
    }

    public void printUnsolvableMessage() {
        System.out.println("Could not solve this board. Please check your inputs.");
    }
}
