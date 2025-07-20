package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardTestSuite {

    @Autowired
    Board board;

    @Test
    void testTaskAdd() {
        //Given
        board.getToDoList().getTasks().add("Task X");
        board.getInProgressList().getTasks().add("Task Y");
        board.getDoneList().getTasks().add("Task Z");
        //Then
        assertTrue(board.getToDoList().getTasks().contains("Task X"));
        assertTrue(board.getInProgressList().getTasks().contains("Task Y"));
        assertTrue(board.getDoneList().getTasks().contains("Task Z"));
    }
}
