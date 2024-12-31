package org.mycarrentalsystem.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TruckTest extends VehicleTest {

    @Override
    protected Vehicle createTestVehicle(String vehicleId, String model, double baseRentalRate) {
        return new Truck(vehicleId, model, baseRentalRate, 2.0);
    }

    @Test
    public void testCalculateRentalCost() {
        Truck truck = new Truck("TRUCK001", "Ford F-150", 80.0, 2.0);
        assertEquals(160.0, truck.calculateRentalCost(1), "Calculating rental cost with load capacity");
    }

    @Test
    public void testToString() {
        Truck truck = new Truck("TRUCK001", "Ford F-150", 80.0, 2.0);
        assertEquals("Truck{Vehicle{vehicleId='TRUCK001', model='Ford F-150', baseRentalRate=80.0, isAvailable=true}, loadCapacity=2.0}", truck.toString());
    }
}