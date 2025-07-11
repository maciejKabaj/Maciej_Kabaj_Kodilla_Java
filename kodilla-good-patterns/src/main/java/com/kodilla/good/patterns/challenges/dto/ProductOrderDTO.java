package com.kodilla.good.patterns.challenges.dto;

public class ProductOrderDTO {
    boolean isOrdered;

    public ProductOrderDTO(boolean isOrdered) {
        this.isOrdered = isOrdered;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
