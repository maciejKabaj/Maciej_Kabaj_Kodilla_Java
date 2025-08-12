package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    private Bigmac.BigmacBuilder builder;

    @BeforeEach
    public void setUp() {
        builder = new Bigmac.BigmacBuilder()
                .bun(Bun.WITH_SESAME)
                .sauce(Sauce.BARBECUE)
                .burgers(1);
    }

    @Test
    void testBigmacNew() {
        //Given
        Bigmac bigmac = builder.ingredients(Ingredients.CHEESE)
                .ingredients(Ingredients.BACON)
                .ingredients(Ingredients.CHILLI_PEPPER)
                .build();
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        assertEquals(Bun.WITH_SESAME, bigmac.getBun());
        assertEquals(Sauce.BARBECUE, bigmac.getSauce());
        assertEquals(1, bigmac.getBurgers());
        assertEquals(3, howManyIngredients);
    }

    @Test
    void testValidateBun() {
        //Given
        //When
        //Then
        assertThrows(IllegalArgumentException.class, () -> builder.bun(null).build());
    }

    @Test
    void testValidateSauce() {
        //Given
        //When
        //Then
        assertThrows(IllegalArgumentException.class, () -> builder.sauce(null).build());
    }

    @Test
    void testValidateBurgers() {
        //Given
        //When
        //Then
        assertThrows(IllegalArgumentException.class, () -> builder.burgers(-1).build());
    }

    @Test
    void testValidateIngredients() {
        //Given
        //When
        //Then
        assertThrows(IllegalArgumentException.class, () -> builder
                .ingredients(Ingredients.CHEESE)
                .ingredients(Ingredients.BACON)
                .ingredients(Ingredients.CHILLI_PEPPER)
                .ingredients(Ingredients.CUCUMBER)
                .ingredients(Ingredients.LETTUCE)
                .build());
    }
}
