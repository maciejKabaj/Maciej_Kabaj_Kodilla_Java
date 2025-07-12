package com.kodilla.good.patterns.challenges.food2door.suppliers;

public class HealthyShop implements FoodSupplier {

    @Override
    public boolean process(String productName, int quantity) {
        if (quantity > 0 && quantity <= 20) return printSuccess(productName, quantity);
        else if (quantity <= 0) return printNoOrder(productName, quantity);
        else return printOrderTooBig(productName, quantity);
    }

    public boolean printSuccess(String productName, int quantity) {
        System.out.println("Healthy Shop: order received! " + quantity + " of " + productName + " will be delivered! We care for your health!");
        return true;
    }

    public boolean printNoOrder(String productName, int quantity) {
        System.out.println("Healthy Shop: no order received!");
        return false;
    }

    public boolean printOrderTooBig(String productName, int quantity) {
        System.out.println("Healthy Shop: order received is too big for us to manage! please order no more than 20!");
        return false;
    }
}
