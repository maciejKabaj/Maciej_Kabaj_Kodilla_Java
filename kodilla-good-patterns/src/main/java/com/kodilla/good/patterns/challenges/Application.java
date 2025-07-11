package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.deliveries.DeliveryMethod;
import com.kodilla.good.patterns.challenges.deliveries.ParcelLockerDelivery;
import com.kodilla.good.patterns.challenges.dto.ProductOrderDTO;
import com.kodilla.good.patterns.challenges.information.EmailInformationService;
import com.kodilla.good.patterns.challenges.information.InformationService;
import com.kodilla.good.patterns.challenges.model.Address;
import com.kodilla.good.patterns.challenges.model.CustomerData;
import com.kodilla.good.patterns.challenges.model.Product;
import com.kodilla.good.patterns.challenges.model.ProductOrderRequest;
import com.kodilla.good.patterns.challenges.payments.CardPayment;
import com.kodilla.good.patterns.challenges.payments.PaymentMethod;

public class Application {
    public static void main(String[] args) {
        //Task 12.1
        /*
        MovieStore movieStore = new MovieStore();
        System.out.println(movieStore.getMoviesSeparatedByExclamationMark());
        System.out.println(movieStore.countFactorial(4));
        */

        //Task 12.2
        Address customerAddress = new Address("123 Sesame Street", "New York", "10123");
        CustomerData customerData = new CustomerData(
                "John",
                "Smith",
                "j.smith@jsmithdomain.com",
                customerAddress,
                "123456789");
        ProductOrderDTO result = getProductOrderDTO(customerData);
        System.out.println("Order placed: " + result.isOrdered());

    }

    private static ProductOrderDTO getProductOrderDTO(CustomerData customerData) {
        Product product = new Product(5, "Mug", 10.5);
        PaymentMethod customerCardPayment = new CardPayment();
        DeliveryMethod customerParcelLockerDelivery = new ParcelLockerDelivery();
        ProductOrderRequest productOrderRequest = new ProductOrderRequest(customerData, product, customerParcelLockerDelivery, customerCardPayment);
        InformationService customerInfo = new EmailInformationService();
        ProductOrderService orderProcess = new ProductOrderService(customerInfo);
        return orderProcess.process(productOrderRequest);
    }

}
