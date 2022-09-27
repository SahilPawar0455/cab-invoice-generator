package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CabInvoiceTest {
    @Test
    public void givenDistanceAndTimeShouldReturnTotalFare() {
        double totalFare = CabInvoiceGenerator.calculateTotalFare(2.0, 4.0);
        Assert.assertEquals(24.0, totalFare, 0.0);
    }
    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinimumFare() {
        double fare = CabInvoiceGenerator.calculateTotalFare(0.1, 1.0);
        Assert.assertEquals(5, fare, 0.0);
    }
    @Test
    public void givenMultipleRidesShouldReturnAggregateFare() {
        Ride ride1 = new Ride(5, 10);
        Ride ride2 = new Ride(4, 8);
        Ride ride3 = new Ride(2, 9);
        Ride ride4 = new Ride(6, 3);
        List<Ride> rideList = new ArrayList<>();
        rideList.add(ride1);
        rideList.add(ride2);
        rideList.add(ride3);
        rideList.add(ride4);
        double totalFare = CabInvoiceGenerator.calculateTotalFare(rideList);
        Assert.assertEquals(200.0, totalFare, 0.0);
    }
    @Test
    public void givenMultipleRidesShouldReturnsInvoice() {
        Ride ride1 = new Ride(5, 10);
        Ride ride2 = new Ride(4, 8);
        Ride ride3 = new Ride(2, 9);
        Ride ride4 = new Ride(6, 3);
        List<Ride> rideList = new ArrayList<>();
        rideList.add(ride1);
        rideList.add(ride2);
        rideList.add(ride3);
        rideList.add(ride4);
        Invoice expectedInvoice = new Invoice(rideList.size(), 200, 50);
        Invoice actualInvoice = CabInvoiceGenerator.generateInvoice(rideList);
        Assert.assertEquals(expectedInvoice, actualInvoice);
    }
}
