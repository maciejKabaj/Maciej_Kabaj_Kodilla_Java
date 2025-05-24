package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    //Additional task implementation
    public int power(int a, int b) {
        if (b == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= b; i++) {
            result = result * a;
        }
        return result;
    }

    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();

        try {
            double result = firstChallenge.divide(3, 0);
            System.out.println(result);
        }
        catch(ArithmeticException e) {
            System.out.println("You can't divide by zero! Error: " + e);
        }
        finally {
            System.out.println("Finished operations!");
        }

        //Additional task test
        int resultToThePowerOfZero = firstChallenge.power(2, 0);
        int resultToThePowerOfOne = firstChallenge.power(2, 1);
        int resultToThePowerOfTwo = firstChallenge.power(2, 2);
        System.out.println(resultToThePowerOfZero + " " + resultToThePowerOfOne + " " + resultToThePowerOfTwo);
    }
}