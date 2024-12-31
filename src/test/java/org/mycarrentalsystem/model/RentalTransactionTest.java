package org.mycarrentalsystem.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RentalTransactionTest {

    @Test
    public void testTotalCostCalculation() {
        Customer customer = new Customer(1L, "Eve", "eve@example.com");
        Vehicle car = new Car("CAR001", "Toyota", 50.0, 4);
        RentalTransaction transaction = new RentalTransaction(customer, car, 3);
        assertEquals(150.0, transaction.getTotalCost(), "Total cost for 3 days should be 150.0");
    }

    @Test
    public void testToString() {
        Customer customer = new Customer(1L, "Eve", "eve@example.com");
        Vehicle car = new Car("CAR001", "Toyota", 50.0, 4);
        RentalTransaction transaction = new RentalTransaction(customer, car, 3);
        assertEquals("RentalTransaction{customer=Eve, vehicle=Toyota, rentalDays=3, totalCost=150.0}", transaction.toString());
    }
}