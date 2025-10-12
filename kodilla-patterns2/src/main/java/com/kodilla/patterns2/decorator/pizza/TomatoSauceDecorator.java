package com.kodilla.patterns2.decorator.pizza;

public class TomatoSauceDecorator extends AbstractPizzaOrderDecorator {

    protected TomatoSauceDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public double getCost() {
        return super.getCost() + 3.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + tomato sauce";
    }
}
