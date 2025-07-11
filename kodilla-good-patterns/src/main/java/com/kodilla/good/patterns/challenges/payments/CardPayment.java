package com.kodilla.good.patterns.challenges.payments;

public class CardPayment implements PaymentMethod {
    @Override
    public boolean processPayment() {
        return true;
    }

    @Override
    public PaymentType getPaymentMethod() {
        return PaymentType.CARD;
    }
}
