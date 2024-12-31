package org.mycarrentalsystem.model;

/**
 * Class representing a truck, inheriting from Vehicle.
 */
public class Truck extends Vehicle {
    private double loadCapacity; // Load capacity of the truck in tons

    /**
     * Constructor for Truck.
     *
     * @param vehicleId      the unique identifier for the vehicle
     * @param model          the model of the truck
     * @param baseRentalRate the base rental rate per day
     * @param loadCapacity   the load capacity of the truck in tons
     */
    public Truck(String vehicleId, String model, double baseRentalRate, double loadCapacity) {
        super(vehicleId, model, baseRentalRate); // Call to the parent class constructor
        if (loadCapacity <= 0) {
            throw new IllegalArgumentException("Load capacity must be greater than zero");
        }
        this.loadCapacity = loadCapacity;
    }

    /**
     * Calculate rental cost specific to Truck.
     *
     * @param rentalDays the number of rental days
     * @return the rental cost
     */
    @Override
    public double calculateRentalCost(int rentalDays) {
        return rentalDays * getBaseRentalRate(); // Rental cost = days * base rate
    }

    /**
     * Provides a string representation of the truck.
     *
     * @return a string representation of the truck
     */
    @Override
    public String toString() {
        return "Truck{" + super.toString() + ", loadCapacity=" + loadCapacity + "}";
    }
}