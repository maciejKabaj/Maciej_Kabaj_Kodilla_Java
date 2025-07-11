package com.kodilla.good.patterns.challenges.model;

import com.kodilla.good.patterns.challenges.deliveries.DeliveryMethod;
import com.kodilla.good.patterns.challenges.payments.PaymentMethod;

public class ProductOrderRequest {
    private CustomerData customerData;
    private Product product;
    private DeliveryMethod deliveryMethod;
    private PaymentMethod paymentMethod;

    public ProductOrderRequest(CustomerData customerData, Product product, DeliveryMethod deliveryMethod, PaymentMethod paymentMethod) {
        this.customerData = customerData;
        this.product = product;
        this.deliveryMethod = deliveryMethod;
        this.paymentMethod = paymentMethod;
    }

    public CustomerData getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerData customerData) {
        this.customerData = customerData;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
