package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

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
}
