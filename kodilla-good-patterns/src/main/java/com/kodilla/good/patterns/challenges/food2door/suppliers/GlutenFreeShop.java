package com.kodilla.good.patterns.challenges.food2door.suppliers;

public class GlutenFreeShop implements FoodSupplier {

    @Override
    public boolean process(String productName, int quantity) {
        if (!productName.contains("gluten") && quantity > 0) return printSuccess(productName, quantity);
        else return printNoOrder(productName, quantity);
    }

    public boolean printSuccess(String productName, int quantity) {
        System.out.println("Gluten Free Shop: order received! " + quantity + " of " + productName + " will be delivered! Gluten free guaranteed!");
        return true;
    }

    public boolean printNoOrder(String productName, int quantity) {
        System.out.println("Gluten Free Shop: no order received!");
        return false;
    }
}
