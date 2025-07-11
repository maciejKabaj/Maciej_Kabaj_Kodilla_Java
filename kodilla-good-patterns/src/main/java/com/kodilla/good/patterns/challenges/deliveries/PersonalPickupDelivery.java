package com.kodilla.good.patterns.challenges.deliveries;

public class PersonalPickupDelivery implements DeliveryMethod {
    @Override
    public boolean deliverProduct() {
        return true;
    }

    @Override
    public DeliveryType getDeliveryType() {
        return DeliveryType.PERSONAL_PICKUP;
    }
}
