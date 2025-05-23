package com.kodilla.rps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CheatingComputerMoveStrategy implements ComputerMoveStrategy {

    @Override
    public MoveType generateMove(MoveType playerMove) {
        Random rand = new Random();
        List<MoveType> movesToDraw = new ArrayList<>(Arrays.asList(MoveType.values()));
        movesToDraw.add(MoveLogic.getCounterMove(playerMove));
        return movesToDraw.get(rand.nextInt(movesToDraw.size()));
    }
}
