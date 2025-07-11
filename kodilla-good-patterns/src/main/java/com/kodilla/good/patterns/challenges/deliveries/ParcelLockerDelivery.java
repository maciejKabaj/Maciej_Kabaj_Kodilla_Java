package com.kodilla.good.patterns.challenges.deliveries;

public class ParcelLockerDelivery implements DeliveryMethod {
    @Override
    public boolean deliverProduct() {
        return true;
    }

    @Override
    public DeliveryType getDeliveryType() {
        return DeliveryType.PARCEL_LOCKER;
    }
}
