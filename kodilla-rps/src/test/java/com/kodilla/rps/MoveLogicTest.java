package com.kodilla.rps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoveLogicTest {

    @Test
    void whoWinsWhenTieTest() {
        //Given
        MoveType movePLayer = MoveType.ROCK;
        MoveType moveComputer = MoveType.ROCK;
        int expected = 0;
        //When
        int result = MoveLogic.whoWins(movePLayer, moveComputer);
        //Then
        Assertions.assertEquals(expected, result);
    }

    @Test
    void whoWinsWhenPlayerShouldWinTest() {
        //Given
        MoveType movePLayer = MoveType.ROCK;
        MoveType moveComputer = MoveType.SCISSORS;
        int expected = 1;
        //When
        int result = MoveLogic.whoWins(movePLayer, moveComputer);
        //Then
        Assertions.assertEquals(expected, result);
    }

    @Test
    void whoWinsWhenComputerShouldWinTest() {
        //Given
        MoveType movePLayer = MoveType.ROCK;
        MoveType moveComputer = MoveType.PAPER;
        int expected = -1;
        //When
        int result = MoveLogic.whoWins(movePLayer, moveComputer);
        //Then
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getCounterMoveShouldReturnPaperForRockTest() {
        //Given
        MoveType move = MoveType.ROCK;
        MoveType expected = MoveType.PAPER;
        //When
        MoveType result = MoveLogic.getCounterMove(move);
        //Then
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getCounterMoveShouldReturnScissorsForPaperTest() {
        //Given
        MoveType move = MoveType.PAPER;
        MoveType expected = MoveType.SCISSORS;
        //When
        MoveType result = MoveLogic.getCounterMove(move);
        //Then
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getCounterMoveShouldReturnRockForScissorsTest() {
        //Given
        MoveType move = MoveType.SCISSORS;
        MoveType expected = MoveType.ROCK;
        //When
        MoveType result = MoveLogic.getCounterMove(move);
        //Then
        Assertions.assertEquals(expected, result);
    }
}
