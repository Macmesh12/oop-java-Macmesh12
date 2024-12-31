package org.mycarrentalsystem.model;

/**
 * Class representing an administrator of the rental agency.
 */
public class Administrator implements User {
    private final Long id;
    private final String name;

    public Administrator(Long id, String name) {
        if (id == null) {
            throw new IllegalArgumentException("Administrator ID cannot be null");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        this.id = id;
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Administrator{id=%d, name='%s'}", id, name);
    }
}