package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    Calculator calculator;

    @Test
    void testAddition() {
        //Given
        //When
        double result = calculator.add(2, 2);
        //Then
        assertEquals(4.0, result, 0.001);
    }

    @Test
    void testSubtraction() {
        //Given
        //When
        double result = calculator.sub(2, 2);
        //Then
        assertEquals(0.0, result, 0.001);
    }

    @Test
    void testMultiplication() {
        //Given
        //When
        double result = calculator.mul(2, 2);
        //Then
        assertEquals(4.0, result, 0.001);
    }

    @Test
    void testDivision() {
        //Given
        //When
        double result = calculator.div(2, 2);
        //Then
        assertEquals(1.0, result, 0.001);
    }

    @Test
    void testCalculations() {
        assertEquals(4.0, calculator.add(2, 2), 0.001);
        assertEquals(0.0, calculator.sub(2, 2), 0.001);
        assertEquals(4.0, calculator.mul(2, 2), 0.001);
        assertEquals(1.0, calculator.div(2, 2), 0.001);
        System.out.println("Calculations are correct!");
    }
}
