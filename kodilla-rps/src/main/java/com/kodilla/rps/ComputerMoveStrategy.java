package com.kodilla.rps;

public interface ComputerMoveStrategy {
    MoveType generateMove(MoveType playerMove);
}
