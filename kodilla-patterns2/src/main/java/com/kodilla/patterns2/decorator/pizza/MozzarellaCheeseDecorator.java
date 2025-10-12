package com.kodilla.patterns2.decorator.pizza;

public class MozzarellaCheeseDecorator extends AbstractPizzaOrderDecorator {

    protected MozzarellaCheeseDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public double getCost() {
        return super.getCost() + 6.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + mozzarella cheese";
    }
}
