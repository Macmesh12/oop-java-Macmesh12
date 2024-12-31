package org.mycarrentalsystem.model;

import java.time.LocalDate;

/**
 * Class representing a rental item.
 */
public class RentalItem {
    private Long id;              // Unique ID for the rental item
    private Long vehicleId;       // ID of the vehicle being rented
    private Long customerId;      // ID of the customer renting the vehicle
    private LocalDate rentalDate; // Date when the vehicle was rented
    private LocalDate returnDate; // Date when the vehicle was returned

    /**
     * Constructor for RentalItem.
     *
     * @param id          the unique ID for the rental item
     * @param vehicleId   the ID of the vehicle being rented
     * @param customerId  the ID of the customer renting the vehicle
     * @param rentalDate  the date when the vehicle was rented
     * @param returnDate  the date when the vehicle was returned
     */
    public RentalItem(Long id, Long vehicleId, Long customerId, LocalDate rentalDate, LocalDate returnDate) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (vehicleId == null) {
            throw new IllegalArgumentException("Vehicle ID cannot be null");
        }
        if (customerId == null) {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }
        if (rentalDate == null) {
            throw new IllegalArgumentException("Rental date cannot be null");
        }
        if (returnDate != null && returnDate.isBefore(rentalDate)) {
            throw new IllegalArgumentException("Return date cannot be before rental date");
        }

        this.id = id;
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    /**
     * Gets the unique ID for the rental item.
     *
     * @return the ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique ID for the rental item.
     *
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the ID of the vehicle being rented.
     *
     * @return the vehicle ID
     */
    public Long getVehicleId() {
        return vehicleId;
    }

    /**
     * Sets the ID of the vehicle being rented.
     *
     * @param vehicleId the vehicle ID to set
     */
    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * Gets the ID of the customer renting the vehicle.
     *
     * @return the customer ID
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * Sets the ID of the customer renting the vehicle.
     *
     * @param customerId the customer ID to set
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the date when the vehicle was rented.
     *
     * @return the rental date
     */
    public LocalDate getRentalDate() {
        return rentalDate;
    }

    /**
     * Sets the date when the vehicle was rented.
     *
     * @param rentalDate the rental date to set
     */
    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    /**
     * Gets the date when the vehicle was returned.
     *
     * @return the return date
     */
    public LocalDate getReturnDate() {
        return returnDate;
    }

    /**
     * Sets the date when the vehicle was returned.
     *
     * @param returnDate the return date to set
     */
    public void setReturnDate(LocalDate returnDate) {
        if (returnDate != null && returnDate.isBefore(rentalDate)) {
            throw new IllegalArgumentException("Return date cannot be before rental date");
        }
        this.returnDate = returnDate;
    }
}