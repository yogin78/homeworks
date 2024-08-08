package com.kodilla.exceptions.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionHandlingTest {

    @Test
    void testHandleExceptionWithValidInput() {
        // Given
        ExceptionHandling exceptionHandling = new ExceptionHandling();

        // When
        String result = exceptionHandling.handleException(1.5, 2.0);

        // Then
        assertEquals("Done!", result);
    }

    @Test
    void testHandleExceptionWithInvalidXValue() {
        // Given
        ExceptionHandling exceptionHandling = new ExceptionHandling();

        // When
        String result = exceptionHandling.handleException(2.0, 2.0);

        // Then
        assertTrue(result.startsWith("Exception caught"));
    }

    @Test
    void testHandleExceptionWithInvalidYValue() {
        // Given
        ExceptionHandling exceptionHandling = new ExceptionHandling();

        // When
        String result = exceptionHandling.handleException(1.5, 1.5);

        // Then
        assertTrue(result.startsWith("Exception caught"));
    }

    @Test
    void testHandleExceptionWithInvalidXAndYValues() {
        // Given
        ExceptionHandling exceptionHandling = new ExceptionHandling();

        // When
        String result = exceptionHandling.handleException(2.0, 1.5);

        // Then
        assertTrue(result.startsWith("Exception caught"));
    }
}
