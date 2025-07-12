package com.kodilla.good.patterns.challenges.food2door.suppliers;

public class ExtraFoodShop implements FoodSupplier {

    @Override
    public boolean process(String productName, int quantity) {
        if (quantity > 0) return printSuccess(productName, quantity);
        else return printNoOrder(productName, quantity);
    }

    public boolean printSuccess(String productName, int quantity) {
        System.out.println("Extra Food Shop: order received! " + quantity + " of " + productName + " will be delivered extra fresh!");
        return true;
    }

    public boolean printNoOrder(String productName, int quantity) {
        System.out.println("Extra Food Shop: no order received!");
        return false;
    }
}
