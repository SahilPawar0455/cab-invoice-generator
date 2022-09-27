package com.bridgelabz;

import java.util.List;

public class CabInvoiceGenerator {
    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;
    public static double calculateTotalFare(double distance, double time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public static double calculateTotalFare(List<Ride> rideList) {
        double aggregate = 0;
        for (Ride ride : rideList) {
            aggregate += calculateTotalFare(ride.distance, ride.time);
        }
        return aggregate;
    }
}
