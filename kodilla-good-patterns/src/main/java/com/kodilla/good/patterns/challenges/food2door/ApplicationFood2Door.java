package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.suppliers.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.food2door.suppliers.FoodSupplier;
import com.kodilla.good.patterns.challenges.food2door.suppliers.GlutenFreeShop;
import com.kodilla.good.patterns.challenges.food2door.suppliers.HealthyShop;

public class ApplicationFood2Door {

    public static void main(String[] args) {
        FoodSupplier extraFoodShop = new ExtraFoodShop();
        FoodSupplier healthyShop = new HealthyShop();
        FoodSupplier glutenFreeShop = new GlutenFreeShop();
        OrderService orderService = new OrderService();

        boolean result = orderService.processOrder(extraFoodShop, "Lemons", 5);
        orderService.printOrderResult(result);

        result = orderService.processOrder(healthyShop, "Walnuts", 0);
        orderService.printOrderResult(result);

        result = orderService.processOrder(glutenFreeShop, "Rice", 5);
        orderService.printOrderResult(result);
    }
}
