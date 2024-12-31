package org.mycarrentalsystem.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a customer of the rental agency.
 */
public class Customer implements User {
    private final Long id;
    private final String name;
    private final String contactInfo;
    private final List<RentalTransaction> rentalHistory;

    /**
     * Constructor for Customer.
     *
     * @param id          the unique ID for the customer
     * @param name        the name of the customer
     * @param contactInfo the contact information for the customer
     */
    public Customer(Long id, String name, String contactInfo) {
        if (id == null) {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (contactInfo == null || contactInfo.isEmpty()) {
            throw new IllegalArgumentException("Contact information cannot be null or empty");
        }

        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.rentalHistory = new ArrayList<>();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public List<RentalTransaction> getRentalHistory() {
        return rentalHistory;
    }

    public void addRentalToHistory(RentalTransaction transaction) {
        rentalHistory.add(transaction);
    }

    public boolean isEligibleForRental() {
        return true; // Simplified eligibility check
    }

    @Override
    public String toString() {
        return String.format("Customer{id=%d, name='%s', contactInfo='%s'}", id, name, contactInfo);
    }
}