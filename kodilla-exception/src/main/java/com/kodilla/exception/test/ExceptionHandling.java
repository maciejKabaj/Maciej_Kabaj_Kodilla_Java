package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        //Should throw an exception
        try {
            System.out.println(secondChallenge.probablyIWillThrowException(1.5, 1.5));
        }
        catch (Exception e) {
            System.out.println("Program has an issue: " + e);
        }
        finally {
            System.out.println("End of program");
        }

        //Should throw an exception
        try {
            System.out.println(secondChallenge.probablyIWillThrowException(2, 2));
        }
        catch (Exception e) {
            System.out.println("Program has an issue: " + e);
        }
        finally {
            System.out.println("End of program");
        }

        //Should throw an exception
        try {
            System.out.println(secondChallenge.probablyIWillThrowException(0.99, 2));
        }
        catch (Exception e) {
            System.out.println("Program has an issue: " + e);
        }
        finally {
            System.out.println("End of program");
        }

        //Should return "Done!"
        try {
            System.out.println(secondChallenge.probablyIWillThrowException(1.5, 2));
        }
        catch (Exception e) {
            System.out.println("Program has an issue: " + e);
        }
        finally {
            System.out.println("End of program");
        }

        //Should return "Done!"
        try {
            System.out.println(secondChallenge.probablyIWillThrowException(1.99, 2));
        }
        catch (Exception e) {
            System.out.println("Program has an issue: " + e);
        }
        finally {
            System.out.println("End of program");
        }

    }
}
