package com.kodilla.rps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    static class FixedMoveStrategy implements ComputerMoveStrategy {
        private final MoveType fixedMove;

        public FixedMoveStrategy(MoveType fixedMove) {
            this.fixedMove = fixedMove;
        }

        @Override
        public MoveType generateMove(MoveType playerMove) {
            return fixedMove;
        }
    }

    @Test
    void playRoundWhenItShouldBeATieTest() {
        //Given
        Game testGame = new Game("user", 1, new FixedMoveStrategy(MoveType.ROCK));
        MoveType playerMove = MoveType.ROCK;
        int expectedScore = 0;
        //When
        testGame.playRound(playerMove);
        //Then
        Assertions.assertEquals(expectedScore, testGame.getComputerScore());
        Assertions.assertEquals(expectedScore, testGame.getPlayerScore());
    }

    @Test
    void playRoundWhenPlayerShouldWinTest() {
        //Given
        Game testGame = new Game("user", 1, new FixedMoveStrategy(MoveType.SCISSORS));
        MoveType playerMove = MoveType.ROCK;
        int expectedPlayerScore = 1;
        int expectedComputerScore = 0;
        //When
        testGame.playRound(playerMove);
        //Then
        Assertions.assertEquals(expectedPlayerScore, testGame.getPlayerScore());
        Assertions.assertEquals(expectedComputerScore, testGame.getComputerScore());

    }

    @Test
    void playRoundWhenComputerShouldWinTest() {
        //Given
        Game testGame = new Game("user", 1, new FixedMoveStrategy(MoveType.PAPER));
        MoveType playerMove = MoveType.ROCK;
        int expectedPlayerScore = 0;
        int expectedComputerScore = 1;
        //When
        testGame.playRound(playerMove);
        //Then
        Assertions.assertEquals(expectedPlayerScore, testGame.getPlayerScore());
        Assertions.assertEquals(expectedComputerScore, testGame.getComputerScore());
    }

    @Test
    void isGameOverWhenNobodyWinsTest() {
        //Given
        Game testGame = new Game("user", 1, new FixedMoveStrategy(MoveType.ROCK));
        MoveType playerMove = MoveType.ROCK;
        //When
        testGame.playRound(playerMove);
        //Then
        Assertions.assertFalse(testGame.isGameOver());
    }

    @Test
    void isGameOverWhenPlayerWinsTest() {
        //Given
        Game testGame = new Game("user", 1, new FixedMoveStrategy(MoveType.SCISSORS));
        MoveType playerMove = MoveType.ROCK;
        //When
        testGame.playRound(playerMove);
        //Then
        Assertions.assertTrue(testGame.isGameOver());
    }

    @Test
    void isGameOverWhenComputerWinsTest() {
        //Given
        Game testGame = new Game("user", 1, new FixedMoveStrategy(MoveType.PAPER));
        MoveType playerMove = MoveType.ROCK;
        //When
        testGame.playRound(playerMove);
        //Then
        Assertions.assertTrue(testGame.isGameOver());
    }
}
