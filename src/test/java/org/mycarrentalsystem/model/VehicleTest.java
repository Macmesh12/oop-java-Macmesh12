package org.mycarrentalsystem.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public abstract class VehicleTest {

    protected Vehicle createTestVehicle(String vehicleId, String model, double baseRentalRate) {
        return new Car(vehicleId, model, baseRentalRate, 4); // Using Car for testing examples
    }

    @Test
    public void testVehicleIDValidation() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Car("", "Toyota", 50.0, 4);
        });
        assertEquals("Vehicle ID cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testModelValidation() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Car("CAR001", "", 50.0, 4);
        });
        assertEquals("Model cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testBaseRentalRateValidation() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Car("CAR001", "Toyota", 0, 4);
        });
        assertEquals("Base rental rate must be greater than zero", exception.getMessage());
    }
}