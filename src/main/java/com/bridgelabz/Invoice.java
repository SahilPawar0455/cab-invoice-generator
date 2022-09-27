package com.bridgelabz;

import java.util.Objects;

public class Invoice {
   int rides;
   double aggregate;
   double average;

    public Invoice(int rides, double aggregate, double average) {
        this.rides = rides;
        this.aggregate = aggregate;
        this.average = average;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;
        Invoice invoice = (Invoice) o;
        return rides == invoice.rides && Double.compare(invoice.aggregate, aggregate) == 0 && Double.compare(invoice.average, average) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rides, aggregate, average);
    }
}
