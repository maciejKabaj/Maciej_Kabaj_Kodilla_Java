package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryDrivingTask() {
        //Given
        Task drivingTask = TaskFactory.createTask("DRIVING");
        //When
        boolean taskBefore = drivingTask.isTaskExecuted();
        drivingTask.executeTask();
        boolean taskAfter = drivingTask.isTaskExecuted();
        //Then
        assertEquals("Drive a car", drivingTask.getTaskName());
        assertFalse(taskBefore);
        assertTrue(taskAfter);
    }

    @Test
    void testFactoryPaintingTask() {
        //Given
        Task paintingTask = TaskFactory.createTask("PAINTING");
        //When
        boolean taskBefore = paintingTask.isTaskExecuted();
        paintingTask.executeTask();
        boolean taskAfter = paintingTask.isTaskExecuted();
        //Then
        assertEquals("Spray paint", paintingTask.getTaskName());
        assertFalse(taskBefore);
        assertTrue(taskAfter);
    }

    @Test
    void testFactoryShoppingTask() {
        //Given
        Task shoppingTask = TaskFactory.createTask("SHOPPING");
        //When
        boolean taskBefore = shoppingTask.isTaskExecuted();
        shoppingTask.executeTask();
        boolean taskAfter = shoppingTask.isTaskExecuted();
        //Then
        assertEquals("Go to a store", shoppingTask.getTaskName());
        assertFalse(taskBefore);
        assertTrue(taskAfter);
    }
}
