package com.kodilla.exceptions.test;

public class Main {
    public static void main(String[] args) {
        FindFlight findFlight = new FindFlight();

        Flight flight1 = new Flight("Wrocław", "Warszawa");
        Flight flight2 = new Flight("Warszawa", "Rzeszów");
        Flight flight3 = new Flight("Kraków", "Gdańsk");

        try {
            boolean isFlight1Reachable = findFlight.findFlight(flight1);
            System.out.println("Flight 1 is reachable: " + isFlight1Reachable);

            boolean isFlight2Reachable = findFlight.findFlight(flight2);
            System.out.println("Flight 2 is reachable: " + isFlight2Reachable);

            boolean isFlight3Reachable = findFlight.findFlight(flight3);
            System.out.println("Flight 3 is reachable: " + isFlight3Reachable);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}