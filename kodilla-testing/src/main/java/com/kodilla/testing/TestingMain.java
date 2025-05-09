package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {

    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        //test SimpleUser
        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        //test Calculator
        if (Calculator.add(5,7) == 12) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        if (Calculator.subtract(8,7) == 1) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

    }
}