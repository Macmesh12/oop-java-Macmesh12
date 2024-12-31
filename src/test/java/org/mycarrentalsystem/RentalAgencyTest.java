package org.mycarrentalsystem;

import org.mycarrentalsystem.model.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mycarrentalsystem.model.Customer;

public class RentalAgencyTest {

    private RentalAgency agency;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        agency = new RentalAgency("Best Car Rentals");
        customer = new Customer(1L, "John Doe", "john@example.com");
        agency.registerCustomer(customer);
    }

    @Test
    public void testRentVehicleSuccessfully() {
        Vehicle car = new Car("CAR001", "Toyota Corolla", 50.0, 4);
        agency.addVehicle(car);
        agency.rentVehicle(customer, car, 3);

        assertFalse(car.isAvailable(), "Car should not be available after rental");
        assertEquals(1, customer.getCurrentRentals().size(), "Customer should have one current rental");
    }

    @Test
    public void testRentUnavailableVehicle() {
        Vehicle car = new Car("CAR001", "Toyota Corolla", 50.0, 4);
        agency.addVehicle(car);
        agency.rentVehicle(customer, car, 3);
        agency.rentVehicle(customer, car, 1);  // Attempting to rent the same car again

        assertEquals(1, customer.getCurrentRentals().size(), "Customer should still have only one current rental");
    }

    @Test
    public void testReturnVehicle() {
        Vehicle car = new Car("CAR001", "Toyota Corolla", 50.0, 4);
        agency.addVehicle(car);
        agency.rentVehicle(customer, car, 3);
        agency.returnVehicle(car, customer);

        assertTrue(car.isAvailable(), "Car should be available after return");
        assertEquals(0, customer.getCurrentRentals().size(), "Customer should have no current rentals");
    }
}