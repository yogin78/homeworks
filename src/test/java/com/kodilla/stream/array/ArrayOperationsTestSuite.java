package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        // Given
        int[] numbers = {1, 2, 3, 4, 5};

        // When
        double average = ArrayOperations.getAverage(numbers);

        // Then
        assertEquals(3.0, average);
    }
}
