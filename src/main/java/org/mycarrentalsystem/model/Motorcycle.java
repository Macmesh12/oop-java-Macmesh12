package org.mycarrentalsystem.model;

/**
 * Class representing a motorcycle, inheriting from Vehicle.
 */
public class Motorcycle extends Vehicle {
    private boolean hasSidecar; // Indicates if the motorcycle has a sidecar

    /**
     * Constructor for Motorcycle.
     *
     * @param vehicleId      the unique identifier for the vehicle
     * @param model          the model of the motorcycle
     * @param baseRentalRate the base rental rate per day
     * @param hasSidecar     indicates if the motorcycle has a sidecar
     */
    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean hasSidecar) {
        super(vehicleId, model, baseRentalRate); // Call to the parent class constructor
        this.hasSidecar = hasSidecar;
    }

    /**
     * Calculate rental cost specific to Motorcycle.
     *
     * @param rentalDays the number of rental days
     * @return the rental cost
     */
    @Override
    public double calculateRentalCost(int rentalDays) {
        double cost = rentalDays * getBaseRentalRate(); // Base cost
        if (hasSidecar) {
            cost += 10 * rentalDays; // Additional charge if there's a sidecar
        }
        return cost;
    }

    /**
     * Provides a string representation of the motorcycle.
     *
     * @return a string representation of the motorcycle
     */
    @Override
    public String toString() {
        return "Motorcycle{" + super.toString() + ", hasSidecar=" + hasSidecar + "}";
    }
}