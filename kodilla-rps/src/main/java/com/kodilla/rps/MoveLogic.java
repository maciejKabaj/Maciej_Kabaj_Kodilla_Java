package com.kodilla.rps;

public class MoveLogic {

    public static int whoWins(MoveType movePlayer, MoveType moveComputer) {
        if(movePlayer == moveComputer) {
            return 0;
        } else if (movePlayer == MoveType.ROCK && moveComputer == MoveType.SCISSORS ||
                   movePlayer == MoveType.SCISSORS && moveComputer == MoveType.PAPER ||
                   movePlayer == MoveType.PAPER && moveComputer == MoveType.ROCK) {
            return 1;
        }
        else {
            return -1;
        }
    }

    public static MoveType getCounterMove(MoveType move) {
        return switch (move) {
            case MoveType.ROCK -> MoveType.PAPER;
            case MoveType.PAPER -> MoveType.SCISSORS;
            case MoveType.SCISSORS -> MoveType.ROCK;
        };
    }
}
