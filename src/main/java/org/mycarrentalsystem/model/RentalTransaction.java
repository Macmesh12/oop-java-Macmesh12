package org.mycarrentalsystem.model;

/**
 * Class representing a rental transaction.
 */
public class RentalTransaction {
    private final Customer customer;      // Customer who rented the vehicle
    private final Vehicle vehicle;        // Vehicle being rented
    private final int rentalDays;         // Number of days rented

    /**
     * Constructor for RentalTransaction.
     *
     * @param customer   the customer who rented the vehicle
     * @param vehicle    the vehicle being rented
     * @param rentalDays the number of days rented
     */
    public RentalTransaction(Customer customer, Vehicle vehicle, int rentalDays) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }
        if (rentalDays <= 0) {
            throw new IllegalArgumentException("Rental days must be greater than zero");
        }

        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
    }

    /**
     * Gets the customer who rented the vehicle.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Gets the vehicle being rented.
     *
     * @return the vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Gets the number of days rented.
     *
     * @return the rental days
     */
    public int getRentalDays() {
        return rentalDays;
    }

    /**
     * Calculates the total cost for the rental.
     *
     * @return the total rental cost
     */
    public double getTotalCost() {
        return vehicle.calculateRentalCost(rentalDays); // Use vehicle's calculation
    }

    /**
     * Provides a string representation of the rental transaction.
     *
     * @return a string representation of the rental transaction
     */
    @Override
    public String toString() {
        return String.format("RentalTransaction{customer=%s, vehicle=%s, rentalDays=%d, totalCost=%.2f}",
                customer.getName(), vehicle.getModel(), rentalDays, getTotalCost());
    }
}