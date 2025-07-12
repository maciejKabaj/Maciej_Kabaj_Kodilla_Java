package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.suppliers.FoodSupplier;

public class OrderService {

    public boolean processOrder(FoodSupplier supplier, String productName, int quantity) {
        return supplier.process(productName, quantity);
    }

    public void printOrderResult(boolean isSuccess) {
        if (isSuccess) System.out.println("Order placed successfully!");
        else System.out.println("Order failed!");
    }
}