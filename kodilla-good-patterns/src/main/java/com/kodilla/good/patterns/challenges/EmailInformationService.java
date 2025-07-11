package com.kodilla.good.patterns.challenges;

public class EmailInformationService implements InformationService {
    @Override
    public void inform(CustomerData customerData) {
        System.out.println(customerData.getFirstName() + " " + customerData.getLastName() + ", an email with confirmation was sent to your address.");
    }
}
