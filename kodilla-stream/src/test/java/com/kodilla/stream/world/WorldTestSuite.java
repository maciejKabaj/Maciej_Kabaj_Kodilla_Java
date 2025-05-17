package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        World world = new World();
        Continent continent1 = new Continent();
        Continent continent2 = new Continent();
        Continent continent3 = new Continent();
        int countryNumberPerContinent = 3;
        for (int i = 1; i <= countryNumberPerContinent; i++) {
            continent1.addCountry(new Country(new BigDecimal("1234567890")));
            continent2.addCountry(new Country(new BigDecimal("1234567890")));
            continent3.addCountry(new Country(new BigDecimal("1234567890")));
        }
        world.add(continent1);
        world.add(continent2);
        world.add(continent3);
        //When
        BigDecimal peopleQuantity = world.getPeopleQuantity();
        //Then
        Assertions.assertEquals(new BigDecimal("11111111010"), peopleQuantity);
    }
}
