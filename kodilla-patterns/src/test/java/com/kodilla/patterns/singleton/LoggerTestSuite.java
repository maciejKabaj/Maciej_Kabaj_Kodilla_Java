package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    static void setUpLog() {
        logger = Logger.getInstance();
        logger.log("Starting logger");
    }

    @Test
    void testGetLastLog() {
        //Given
        //When
        //Then
        assertEquals("Starting logger", logger.getLastLog());
    }
}
