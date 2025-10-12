package com.kodilla.patterns2.decorator.pizza;

public class BlackOlivesDecorator extends AbstractPizzaOrderDecorator {

    protected BlackOlivesDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + black olives";
    }
}
