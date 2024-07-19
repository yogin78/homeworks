package com.kodilla.testing.shape;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ShapeCollector Test Suite")
public class ShapeCollectorTestSuite {

    @Nested
    @DisplayName("Tests for adding figures")
    class AddFigureTests {
        @Test
        @DisplayName("Adding a figure to the collector")
        public void testAddFigure() {
            // Given
            ShapeCollector collector = new ShapeCollector();
            Shape circle = new Circle(5);

            // When
            collector.addFigure(circle);

            // Then
            assertEquals(1, collector.getShapes().size());
            assertEquals(circle, collector.getFigure(0));
        }
    }

    @Nested
    @DisplayName("Tests for removing figures")
    class RemoveFigureTests {
        @Test
        @DisplayName("Removing a figure from the collector")
        public void testRemoveFigure() {
            // Given
            ShapeCollector collector = new ShapeCollector();
            Shape circle = new Circle(5);
            collector.addFigure(circle);

            // When
            boolean result = collector.removeFigure(circle);

            // Then
            assertTrue(result);
            assertEquals(0, collector.getShapes().size());
        }

        @Test
        @DisplayName("Removing a figure not in the collector")
        public void testRemoveFigureNotInCollector() {
            // Given
            ShapeCollector collector = new ShapeCollector();
            Shape circle = new Circle(5);
            Shape square = new Square(4);
            collector.addFigure(circle);

            // When
            boolean result = collector.removeFigure(square);

            // Then
            assertFalse(result);
            assertEquals(1, collector.getShapes().size());
        }
    }

    @Nested
    @DisplayName("Tests for getting figures")
    class GetFigureTests {
        @Test
        @DisplayName("Getting a figure at a valid index")
        public void testGetFigureValidIndex() {
            // Given
            ShapeCollector collector = new ShapeCollector();
            Shape circle = new Circle(5);
            collector.addFigure(circle);

            // When
            Shape result = collector.getFigure(0);

            // Then
            assertEquals(circle, result);
        }

        @Test
        @DisplayName("Getting a figure at an invalid index")
        public void testGetFigureInvalidIndex() {
            // Given
            ShapeCollector collector = new ShapeCollector();

            // When
            Shape result = collector.getFigure(0);

            // Then
            assertNull(result);
        }
    }

    @Nested
    @DisplayName("Tests for showing figures")
    class ShowFiguresTests {
        @Test
        @DisplayName("Showing all figures as a single string")
        public void testShowFigures() {
            // Given
            ShapeCollector collector = new ShapeCollector();
            Shape circle = new Circle(5);
            Shape square = new Square(4);
            Shape triangle = new Triangle(3, 6);
            collector.addFigure(circle);
            collector.addFigure(square);
            collector.addFigure(triangle);

            // When
            String result = collector.showFigures();

            // Then
            assertEquals("Circle Square Triangle ", result);
        }
    }
}
