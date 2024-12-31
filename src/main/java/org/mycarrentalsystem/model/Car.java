package org.mycarrentalsystem.model;

/**
 * Class representing a car, inheriting from Vehicle.
 */
public class Car extends Vehicle {
    private int numberOfDoors; // Number of doors in the car

    /**
     * Constructor for Car.
     *
     * @param vehicleId      the unique identifier for the vehicle
     * @param model          the model of the car
     * @param baseRentalRate the base rental rate per day
     * @param numberOfDoors  the number of doors in the car
     */
    public Car(String vehicleId, String model, double baseRentalRate, int numberOfDoors) {
        super(vehicleId, model, baseRentalRate); // Call to the parent class constructor
        if (numberOfDoors <= 0) {
            throw new IllegalArgumentException("Number of doors must be greater than zero");
        }
        this.numberOfDoors = numberOfDoors;
    }

    /**
     * Calculate rental cost specific to Car.
     *
     * @param rentalDays the number of rental days
     * @return the rental cost
     */
    @Override
    public double calculateRentalCost(int rentalDays) {
        return rentalDays * getBaseRentalRate(); // Rental cost = days * base rate
    }

    /**
     * Provides a string representation of the car.
     *
     * @return a string representation of the car
     */
    @Override
    public String toString() {
        return "Car{" + super.toString() + ", numberOfDoors=" + numberOfDoors + "}";
    }
}