package com.kodilla.good.patterns.challenges;

public interface PaymentMethod {
    boolean processPayment();
    PaymentType getPaymentMethod();
}
