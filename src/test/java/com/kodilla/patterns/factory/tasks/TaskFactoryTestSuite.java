package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskFactoryTest {

    @Test
    void testFactoryShoppingTask() {
        // Given
        TaskFactory taskFactory = new TaskFactory();

        // When
        Task shoppingTask = taskFactory.createTask(TaskFactory.SHOPPING_TASK);

        // Then
        assertNotNull(shoppingTask);
        assertEquals("Grocery Shopping", shoppingTask.getTaskName());
        shoppingTask.executeTask();
        assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    void testFactoryPaintingTask() {
        // Given
        TaskFactory taskFactory = new TaskFactory();

        // When
        Task paintingTask = taskFactory.createTask(TaskFactory.PAINTING_TASK);

        // Then
        assertNotNull(paintingTask);
        assertEquals("House Painting", paintingTask.getTaskName());
        paintingTask.executeTask();
        assertTrue(paintingTask.isTaskExecuted());
    }

    @Test
    void testFactoryDrivingTask() {
        // Given
        TaskFactory taskFactory = new TaskFactory();

        // When
        Task drivingTask = taskFactory.createTask(TaskFactory.DRIVING_TASK);

        // Then
        assertNotNull(drivingTask);
        assertEquals("Vacation Trip", drivingTask.getTaskName());
        drivingTask.executeTask();
        assertTrue(drivingTask.isTaskExecuted());
    }

    @Test
    void testFactoryUnknownTask() {
        // Given
        TaskFactory taskFactory = new TaskFactory();

        // When
        Task unknownTask = taskFactory.createTask("UNKNOWN_TASK");

        // Then
        assertNull(unknownTask);
    }
}
