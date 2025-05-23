package com.kodilla.rps;

import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    Game game;

    public void welcomeScreen() {
        String name;
        int gamesToPlay;
        ComputerMoveStrategy strategy = null;
        char choice;

        System.out.println("Welcome to Rock Paper Scissors game!");
        do {
            System.out.println("Please enter your name: ");
            name = sc.nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("Name cannot be empty!");
            }
        }
        while (name.trim().isEmpty());
        do {
            System.out.println("How many games would you like to be won, for the game to end: ");
            try {
                gamesToPlay = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("Thats not a number! Try again!");
                gamesToPlay = 0;
            }
            if (gamesToPlay == 0) {
                System.out.println("You can't set up any games!");
            }
            else if (gamesToPlay < 0) {
                System.out.println("You can't choose a negative number!");
            }
        }
        while (gamesToPlay <= 0);
        System.out.println("Would you like to play against (n)ormal or (h)ard mode? Choose one: ");
        choice = sc.next().charAt(0);
        while (choice != 'n' && choice != 'h') {
            System.out.println("Please choose between 'n' or 'h': ");
            choice = sc.next().charAt(0);
        }
        if (choice == 'n') {
            strategy = new FairComputerMoveStrategy();
        }
        else {
            strategy = new CheatingComputerMoveStrategy();
        }
        game = new Game(name, gamesToPlay, strategy);
    }

    public void mainScreen() {
        char choice;
        boolean end = false;

        System.out.println("Let the fun begin!");
        System.out.println("In order to navigate the game you will have to select from certain choices.");

        while (!end) {
            System.out.println("1 you choose ROCK!");
            System.out.println("2 you choose PAPER!");
            System.out.println("3 you choose SCISSORS!");
            System.out.println("n you choose to start a new game!");
            System.out.println("x you choose to exit the game!");
            System.out.println("Please enter your choice: ");
            choice = sc.next().charAt(0);
            sc.nextLine();

            switch (choice) {
                case '1':
                    game.playRound(MoveType.ROCK);
                    break;
                case '2':
                    game.playRound(MoveType.PAPER);
                    break;
                case '3':
                    game.playRound(MoveType.SCISSORS);
                    break;
                case 'n': {
                    System.out.println("Are you sure you want to disband this game to start a new one? (Y/N)");
                    char confirm = sc.nextLine().toLowerCase().charAt(0);
                    if (confirm == 'y') {
                        welcomeScreen();
                    }
                    break;
                }
                case 'x': {
                    System.out.println("Are you sure you want to exit the game? (Y/N)");
                    char confirm = sc.nextLine().toLowerCase().charAt(0);
                    if (confirm == 'y') {
                        System.out.println("Thank you for playing, " + game.getUsername() + "! See you soon!");
                        sc.close();
                        end = true;
                    }
                    break;
                }
                default:
                    System.out.println("Invalid choice!");
                    break;
            }

            if (game.isGameOver()) {
                game.printGameResult();
                System.out.println("Thank you for playing! See you soon!");
                end = true;
            }
        }
        sc.close();
    }

    public void start() {
        welcomeScreen();
        mainScreen();
    }
}
