package org.mycarrentalsystem.model;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarTest extends VehicleTest {

    @Override
    protected Vehicle createTestVehicle(String vehicleId, String model, double baseRentalRate) {
        return new Car(vehicleId, model, baseRentalRate, 4);
    }

    @Test
    public void testCalculateRentalCost() {
        Vehicle car = createTestVehicle("CAR001", "Toyota", 50.0);
        assertEquals(150.0, car.calculateRentalCost(3), "Calculating rental cost for 3 days");
    }

    @Test
    public void testToString() {
        Car car = new Car("CAR001", "Toyota", 50.0, 4);
        assertEquals("Car{Vehicle{vehicleId='CAR001', model='Toyota', baseRentalRate=50.0, isAvailable=true}, numberOfDoors=4}", car.toString());
    }

    @Test
    public void testEquality() {
        Car car1 = new Car("CAR001", "Toyota", 50.0, 4);
        Car car2 = new Car("CAR001", "Toyota", 50.0, 4);
        assertEquals(car1, car2, "Cars should be equal");
    }
}