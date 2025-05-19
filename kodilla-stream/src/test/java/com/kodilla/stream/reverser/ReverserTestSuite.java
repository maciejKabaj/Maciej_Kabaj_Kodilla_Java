package com.kodilla.stream.reverser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverserTestSuite {

    @Test
    void testReverser() {
        //Given
        String input = "Hello World";
        //When
        String reversed = TextReverser.reverse(input);
        //Then
        Assertions.assertEquals("dlroW olleH", reversed);
    }
}
