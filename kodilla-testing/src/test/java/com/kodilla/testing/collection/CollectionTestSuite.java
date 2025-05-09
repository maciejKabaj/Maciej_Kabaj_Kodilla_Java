package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Collection Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Collection Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Collection Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Collection Suite: end");
    }

    @DisplayName("When we check if the provided List<Integer> numbers is empty, " +
            "then survivedNumbers should return empty as well."
    )

    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        List<Integer> myList = new ArrayList<>();
        OddNumbersExterminator o = new OddNumbersExterminator();
        //When
        List<Integer> result = o.exterminate(myList);
        //Then
        Assertions.assertTrue(result.isEmpty());
    }

    @DisplayName("When we check if the provided List<Integer> numbers has both " +
            "even and odd numbers, then survivedNumbers should return even numbers."
    )

    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        List<Integer> myList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        OddNumbersExterminator o = new OddNumbersExterminator();
        //When
        List<Integer> expected = Arrays.asList(0, 2, 4, 6, 8, 10);
        List<Integer> result = o.exterminate(myList);
        //Then
        Assertions.assertEquals(expected, result);
    }
}
