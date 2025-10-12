package com.kodilla.patterns2.decorator.pizza;

public class BasicPizza implements PizzaOrder {

    @Override
    public double getCost() {
        return 5.5;
    }

    @Override
    public String getDescription() {
        return "Thin crust pizza";
    }
}
