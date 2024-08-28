package com.kodilla.patterns.factory.tasks;


public class TaskFactory {

    public static final String SHOPPING_TASK = "SHOPPING";
    public static final String PAINTING_TASK = "PAINTING";
    public static final String DRIVING_TASK = "DRIVING";

    public Task createTask(final String taskType) {
        switch (taskType) {
            case SHOPPING_TASK:
                return new ShoppingTask("Grocery Shopping", "Apples", 10);
            case PAINTING_TASK:
                return new PaintingTask("House Painting", "Blue", "Living Room");
            case DRIVING_TASK:
                return new DrivingTask("Vacation Trip", "Beach", "Car");
            default:
                return null; // Unknown task type
        }
    }
}
