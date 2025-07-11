package com.kodilla.good.patterns.challenges.information;

import com.kodilla.good.patterns.challenges.model.CustomerData;

public class EmailInformationService implements InformationService {
    @Override
    public void inform(CustomerData customerData) {
        System.out.println(customerData.getFirstName() + " " + customerData.getLastName() + ", an email with confirmation was sent to your address.");
    }
}
