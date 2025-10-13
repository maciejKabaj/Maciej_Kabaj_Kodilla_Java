package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTasksTestSuite {

    private StudentTaskQueue johnDoeQueue;
    private StudentTaskQueue janeSmithQueue;
    private Mentor mentorTom;
    private Mentor mentorBill;
    private Mentor mentorSarah;

    @BeforeEach
    void setUp() {
        johnDoeQueue = new JohnDoeTaskQueue();
        janeSmithQueue = new JaneSmithTaskQueue();
        mentorTom = new Mentor("Tom");
        mentorBill = new Mentor("Bill");
        mentorSarah = new Mentor("Sarah");
        johnDoeQueue.registerObserver(mentorTom);
        johnDoeQueue.registerObserver(mentorBill);
        janeSmithQueue.registerObserver(mentorSarah);
        janeSmithQueue.registerObserver(mentorTom);
    }

    @Test
    void shouldNotifyMentorWhenTaskAdded() {
        //When
        johnDoeQueue.addTask("Task 1");
        johnDoeQueue.addTask("Task 2");
        janeSmithQueue.addTask("Task 3");
        //Then
        assertEquals(3, mentorTom.getUpdateCount());
        assertEquals(2, mentorBill.getUpdateCount());
        assertEquals(1, mentorSarah.getUpdateCount());
    }

    @Test
    void shouldIncreaseUpdateCountWithEachAddedTask() {
        //When&Then
        assertEquals(0, mentorSarah.getUpdateCount());
        janeSmithQueue.addTask("Task 3");
        assertEquals(1, mentorSarah.getUpdateCount());
    }

    @Test
    void shouldNotNotifyRemovedMentor() {
        //When
        johnDoeQueue.removeObserver(mentorTom);
        johnDoeQueue.addTask("Task 1");
        johnDoeQueue.addTask("Task 2");
        janeSmithQueue.addTask("Task 3");
        //Then
        assertEquals(1, mentorTom.getUpdateCount());
        assertEquals(2, mentorBill.getUpdateCount());
        assertEquals(1, mentorSarah.getUpdateCount());
    }
}
