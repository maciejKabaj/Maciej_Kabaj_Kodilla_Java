package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public static Task createTask(final String taskClass) {
        return switch (taskClass) {
            case DRIVING -> new DrivingTask("Drive a car", "Church", "Bus");
            case PAINTING -> new PaintingTask("Spray paint", "Red", "Neighbour's wall");
            case SHOPPING -> new ShoppingTask("Go to a store", "Buy candles", 5);
            default -> null;
        };
    }
}
