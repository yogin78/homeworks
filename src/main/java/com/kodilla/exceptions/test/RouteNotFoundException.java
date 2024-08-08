package com.kodilla.exceptions.test;

public class RouteNotFoundException extends Exception {
    public RouteNotFoundException(String message) {
        super(message);
    }
}
