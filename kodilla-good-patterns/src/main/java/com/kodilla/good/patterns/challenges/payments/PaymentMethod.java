package com.kodilla.good.patterns.challenges.payments;

public interface PaymentMethod {
    boolean processPayment();
    PaymentType getPaymentMethod();
}
