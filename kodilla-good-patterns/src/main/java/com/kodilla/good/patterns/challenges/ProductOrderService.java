package com.kodilla.good.patterns.challenges;

public class ProductOrderService {
    private final InformationService informationService;

    public ProductOrderService(InformationService informationService) {
        this.informationService = informationService;
    }

    public ProductOrderDTO process(final ProductOrderRequest productRequest) {
        boolean payment = productRequest.getPaymentMethod().processPayment();
        boolean delivery = payment && productRequest.getDeliveryMethod().deliverProduct();
        if (payment && delivery) {
            informationService.inform(productRequest.getCustomerData());
        }
        return new ProductOrderDTO(payment && delivery);
    }
}
