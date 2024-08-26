package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

    @Test
    void testLogAndGetLastLog() {
        // Given
        Logger logger =Logger.INSTANCE;

        // When
        logger.log("First log entry");

        // Then
        assertEquals("First log entry", logger.getLastLog(), "The last log should be 'First log entry'");

        // When
        logger.log("Second log entry");

        // Then
        assertEquals("Second log entry", logger.getLastLog(), "The last log should be 'Second log entry'");
    }
}
