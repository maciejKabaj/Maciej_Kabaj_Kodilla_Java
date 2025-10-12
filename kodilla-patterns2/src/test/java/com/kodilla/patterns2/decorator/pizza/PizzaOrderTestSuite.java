package com.kodilla.patterns2.decorator.pizza;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PizzaOrderTestSuite {

    private PizzaOrder pizzaOrder;

    @BeforeEach
    void setUp() {
        pizzaOrder = new BasicPizza();
    }

    @Test
    public void testBasicPizzaOrderGetCost() {
        //When
        double calculatedCost = pizzaOrder.getCost();
        //Then
        assertEquals(5.5, calculatedCost, 0.001);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("Thin crust pizza", description);
    }

    @Test
    public void testTomatoSauceDecorator() {
        //Given
        pizzaOrder = new TomatoSauceDecorator(pizzaOrder);
        //When
        double calculatedCost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals(8.5, calculatedCost, 0.001);
        assertEquals("Thin crust pizza + tomato sauce", description);
    }

    @Test
    public void testPizzaCascadeCreation() {
        //Given
        pizzaOrder = new TomatoSauceDecorator(pizzaOrder);
        pizzaOrder = new MozzarellaCheeseDecorator(pizzaOrder);
        pizzaOrder = new BlackOlivesDecorator(pizzaOrder);
        pizzaOrder = new JalapenoPeppersDecorator(pizzaOrder);
        //When
        double calculatedCost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals(19.5, calculatedCost, 0.001);
        assertEquals("Thin crust pizza + tomato sauce + mozzarella cheese + black olives + jalapeno peppers", description);
    }
}
