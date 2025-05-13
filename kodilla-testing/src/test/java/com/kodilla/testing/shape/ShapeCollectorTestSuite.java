package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

@DisplayName("TDD: Shape Collector Test Suite")

class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for addFigure()")
    class AddFigureTests {
        @Test
        @DisplayName("Should add a shape to the collector")
        void testAddFigure() {
            //Given
            Shape shape = new Circle(5);
            ShapeCollector collector = new ShapeCollector();
            //When
            collector.addFigure(shape);
            //Then
            Assertions.assertSame(shape, collector.getFigure(0));
        }
    }

    @Nested
    @DisplayName("Tests for removeFigure()")
    class RemoveFigureTests {
        @Test
        @DisplayName("Should remove a shape from the collector")
        void testRemoveFigure() {
            //Given
            Shape shape = new Circle(5);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(shape);
            //When
            collector.removeFigure(shape);
            //Then
            Assertions.assertNull(collector.getFigure(0));
        }
    }

    @Nested
    @DisplayName("Tests for getFigure()")
    class GetFigureTests {
        @Test
        @DisplayName("Should get a shape from the collector under provided index")
        void testGetFigure() {
            //Given
            Shape shape = new Circle(5);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(shape);
            //When
            Shape result = collector.getFigure(0);
            //Then
            Assertions.assertSame(shape, result);
        }
    }
}
