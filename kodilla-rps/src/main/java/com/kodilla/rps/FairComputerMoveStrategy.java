package com.kodilla.rps;

import java.util.Random;

public class FairComputerMoveStrategy implements ComputerMoveStrategy {

    @Override
    public MoveType generateMove(MoveType playerMove) {
        Random rand = new Random();
        return MoveType.values()[rand.nextInt(MoveType.values().length)];
    }
}
