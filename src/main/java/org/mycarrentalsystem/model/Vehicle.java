package org.mycarrentalsystem.model;

/**
 * Abstract base class for all vehicles.
 */
public abstract class Vehicle {
    private final String vehicleId;        // Unique identifier for the vehicle
    private final String model;            // Model of the vehicle
    private final double baseRentalRate;   // Base rental rate per day
    private boolean isAvailable;           // Availability status of the vehicle

    /**
     * Constructor to initialize vehicle properties.
     *
     * @param vehicleId      the unique identifier for the vehicle
     * @param model          the model of the vehicle
     * @param baseRentalRate the base rental rate per day
     */
    public Vehicle(String vehicleId, String model, double baseRentalRate) {
        if (vehicleId == null || vehicleId.isEmpty()) {
            throw new IllegalArgumentException("Vehicle ID cannot be null or empty");
        }
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty");
        }
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be greater than zero");
        }

        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = true; // Vehicles are available by default
    }

    /**
     * Gets the unique identifier for the vehicle.
     *
     * @return the vehicle ID
     */
    public String getVehicleId() {
        return vehicleId;
    }

    /**
     * Gets the model of the vehicle.
     *
     * @return the model of the vehicle
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets the base rental rate per day.
     *
     * @return the base rental rate
     */
    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    /**
     * Checks if the vehicle is available for rental.
     *
     * @return true if the vehicle is available, false otherwise
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Marks the vehicle as rented.
     */
    public void rent() {
        this.isAvailable = false;
    }

    /**
     * Marks the vehicle as available.
     */
    public void returnVehicle() {
        this.isAvailable = true;
    }

    /**
     * Calculates the rental cost for the given number of rental days.
     *
     * @param rentalDays the number of rental days
     * @return the rental cost
     */
    public abstract double calculateRentalCost(int rentalDays);

    /**
     * Provides a string representation of the vehicle.
     *
     * @return a string representation of the vehicle
     */
    @Override
    public String toString() {
        return String.format("%s{vehicleId='%s', model='%s', baseRentalRate=%.2f, isAvailable=%s}",
                this.getClass().getSimpleName(), vehicleId, model, baseRentalRate, isAvailable);
    }
}