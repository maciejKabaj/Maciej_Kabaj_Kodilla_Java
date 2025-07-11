package com.kodilla.good.patterns.challenges;

public class CashPayment implements PaymentMethod {
    @Override
    public boolean processPayment() {
        return true;
    }

    @Override
    public PaymentType getPaymentMethod() {
        return PaymentType.CASH;
    }
}
