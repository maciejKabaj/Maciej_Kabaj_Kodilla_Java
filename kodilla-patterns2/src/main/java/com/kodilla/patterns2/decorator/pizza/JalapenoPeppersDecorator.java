package com.kodilla.patterns2.decorator.pizza;

public class JalapenoPeppersDecorator extends AbstractPizzaOrderDecorator {

    protected JalapenoPeppersDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + jalapeno peppers";
    }
}
