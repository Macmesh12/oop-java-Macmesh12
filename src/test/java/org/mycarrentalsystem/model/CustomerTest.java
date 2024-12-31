package org.mycarrentalsystem.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void testCustomerIDValidation() {
        Customer customer = new Customer(1L, "John Doe", "john@example.com");
        assertEquals(1L, customer.getId());
    }

    @Test
    public void testContactInfoValidation() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Customer(2L, "Jane Doe", "");
        });
        assertEquals("Contact information cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testAddRentalToHistory() {
        Customer customer = new Customer(3L, "Alice", "alice@example.com");
        Vehicle car = new Car("CAR002", "Honda Civic", 40.0, 4);
        RentalTransaction transaction = new RentalTransaction(customer, car, 2);
        customer.addRentalToHistory(transaction);
        assertEquals(1, customer.getRentalHistory().size(), "Rental history should contain one transaction");
    }

    @Test
    public void testEligibilityForRental() {
        Customer customer = new Customer(4L, "Bob", "bob@example.com");
        assertTrue(customer.isEligibleForRental(), "New customer should be eligible for rental");
    }
}