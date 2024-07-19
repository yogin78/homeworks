package com.kodilla.testing.colection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionTestSuite {


    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @Test
    @DisplayName( "test dla pustej listy")
    public void testOddNumbersExtermintor_EmptyList() {

        List<Integer> empty = Collections.emptyList();

        List<Integer> result = OddNumbersExterminator.exterminate(empty);

        assertEquals(Collections.emptyList(), result, "Wynikowa lista powinna być pusta dla pustej listy wejściowej");
    }

    @Test
    @DisplayName("test dla losowej listy liczb")
    public void testFOddNumbersExterminator_WithNumbers() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> result=OddNumbersExterminator.exterminate(list);

        List<Integer> expectedResult = Arrays.asList(2, 4, 6);

        assertEquals(expectedResult, result, "Wynikowa lista powinna zawierać tylko liczby parzyste z listy wejściowej");
    }
}

