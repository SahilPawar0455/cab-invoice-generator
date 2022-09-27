package com.bridgelabz;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class CabInvoiceGenerator {
    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;
    public static List<Customer> customerList = new ArrayList<>();

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

    public static Invoice generateInvoice(List<Ride> rideList) {
        double aggregate = calculateTotalFare(rideList);
        int rides = rideList.size();
        double average = aggregate / rides;
        return new Invoice(rides, aggregate, average);
    }
    public static Invoice invoiceService(int customerId){
        List<Ride> rides = null;
        for (Customer customer : customerList) {
            if (customer.customerId == customerId) {
                rides = customer.rides;
            }
        }
        return generateInvoice(rides);
    }
}
