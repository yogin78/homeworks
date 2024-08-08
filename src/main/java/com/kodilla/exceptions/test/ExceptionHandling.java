package com.kodilla.exceptions.test;

public class ExceptionHandling {

    public String handleException(double x, double y) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            return secondChallenge.probablyIWillThrowException(x, y);
        } catch (Exception e) {
            return "Exception caught: " + e.getMessage();
        }finally{
            System.out.println("Program ends");
        }
    }
}
