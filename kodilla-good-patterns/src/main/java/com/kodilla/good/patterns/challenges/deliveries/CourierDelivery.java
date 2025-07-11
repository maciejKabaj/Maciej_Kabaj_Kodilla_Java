package com.kodilla.good.patterns.challenges.deliveries;

public class CourierDelivery implements DeliveryMethod {
    @Override
    public boolean deliverProduct() {
        return true;
    }

    @Override
    public DeliveryType getDeliveryType() {
        return DeliveryType.COURIER;
    }
}
