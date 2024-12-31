package org.mycarrentalsystem.model;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MotorcycleTest extends VehicleTest {

    @Override
    protected Vehicle createTestVehicle(String vehicleId, String model, double baseRentalRate) {
        return new Motorcycle(vehicleId, model, baseRentalRate, false);
    }

    @Test
    public void testCalculateRentalCost_WithSidecar() {
        Motorcycle motorcycle = new Motorcycle("MOTO01", "Harley-Davidson", 30.0, true);
        assertEquals(100.0, motorcycle.calculateRentalCost(3), "Calculating rental cost with sidecar");
    }

    @Test
    public void testCalculateRentalCost_WithoutSidecar() {
        Motorcycle motorcycle = new Motorcycle("MOTO02", "Ducati", 30.0, false);
        assertEquals(90.0, motorcycle.calculateRentalCost(3), "Calculating rental cost without sidecar");
    }

    @Test
    public void testToString() {
        Motorcycle motorcycle = new Motorcycle("MOTO01", "Harley-Davidson", 30.0, false);
        assertEquals("Motorcycle{Vehicle{vehicleId='MOTO01', model='Harley-Davidson', baseRentalRate=30.0, isAvailable=true}, hasSidecar=false}", motorcycle.toString());
    }
}