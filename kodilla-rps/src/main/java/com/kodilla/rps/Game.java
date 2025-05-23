package com.kodilla.rps;

public class Game {
    private final String username;
    private int playerScore;
    private int computerScore;
    private final int gamesToWin;
    private final ComputerMoveStrategy computerMoveStrategy;

    public Game(String username, int gamesToWin, ComputerMoveStrategy computerMoveStrategy) {
        this.username = username;
        this.gamesToWin = gamesToWin;
        this.computerMoveStrategy = computerMoveStrategy;
    }

    public String getUsername() {
        return username;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getGamesToWin() {
        return gamesToWin;
    }

    public ComputerMoveStrategy getComputerMoveStrategy() {
        return computerMoveStrategy;
    }

    public void playRound(MoveType playerMove) {
        MoveType computerMove = computerMoveStrategy.generateMove(playerMove);
        int result = MoveLogic.whoWins(playerMove, computerMove);

        System.out.println(username + " played: " + playerMove);
        System.out.println("Computer played: " + computerMove);

        if (result == 1) {
            playerScore++;
            System.out.println(username + " wins this round!");
        }
        else if (result == -1) {
            computerScore++;
            System.out.println("Computer wins this round!");
        }
        else {
            System.out.println("It's a tie!");
        }
        printScore();
    }

    public boolean isGameOver() {
        return playerScore >= gamesToWin || computerScore >= gamesToWin;
    }

    public void printScore() {
        System.out.println(username + ": " + playerScore + " | Computer: " + computerScore);
    }

    public void printGameResult() {
        if (playerScore == gamesToWin) {
            System.out.println("You win this game " + username + "!");
        }
        else if (computerScore == gamesToWin) {
            System.out.println("Computer wins this game! Better luck next time " + username + "!");
        }
    }
}
