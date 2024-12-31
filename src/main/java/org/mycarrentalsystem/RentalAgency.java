package org.mycarrentalsystem;

import org.mycarrentalsystem.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class representing the rental agency.
 */
public class RentalAgency {
    private final String name;
    private final List<Vehicle> vehicles = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();
    private final List<RentalTransaction> transactions = new ArrayList<>();
    private final List<Administrator> administrators = new ArrayList<>();

    public RentalAgency(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Agency name cannot be null or empty");
        }
        this.name = name;
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }
        vehicles.add(vehicle);
        System.out.println("Vehicle added: " + vehicle);
    }

    public void removeVehicle(String vehicleId) {
        vehicles.removeIf(vehicle -> vehicle.getVehicleId().equals(vehicleId));
        System.out.println("Vehicle removed: " + vehicleId);
    }

    public void registerCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        customers.add(customer);
        System.out.println("Customer registered: " + customer);
    }

    public void removeCustomer(Long customerId) {
        customers.removeIf(customer -> customer.getId().equals(customerId));
        System.out.println("Customer removed: " + customerId);
    }

    public void registerAdministrator(Administrator administrator) {
        if (administrator == null) {
            throw new IllegalArgumentException("Administrator cannot be null");
        }
        administrators.add(administrator);
        System.out.println("Administrator registered: " + administrator);
    }

    public void displayAvailableVehicles() {
        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                System.out.println(vehicle);
            }
        }
    }

    public void displayVehiclesByCategory(Class<? extends Vehicle> vehicleType) {
        System.out.println("Available " + vehicleType.getSimpleName() + "s:");
        for (Vehicle vehicle : vehicles) {
            if (vehicleType.isInstance(vehicle)) {
                System.out.println(vehicle + ", Available: " + vehicle.isAvailable());
            }
        }
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<RentalTransaction> getTransactions() {
        return transactions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalAgency agency = new RentalAgency("My Rental Agency");

        // Sample administrators and customers
        Administrator admin1 = new Administrator(1L, "Admin One");
        agency.registerAdministrator(admin1);
        Customer customer1 = new Customer(1L, "John Doe", "john.doe@example.com");
        agency.registerCustomer(customer1);

        // Sample vehicles
        Vehicle car1 = new Car("V001", "Toyota Camry", 50.0, 4);
        Vehicle truck1 = new Truck("V002", "Ford F-150", 80.0, 5.0);
        Vehicle motorcycle1 = new Motorcycle("V003", "Harley Davidson", 40.0, true);
        agency.addVehicle(car1);
        agency.addVehicle(truck1);
        agency.addVehicle(motorcycle1);

        // Simple login system
        System.out.println("Welcome to the Car Rental System!");
        System.out.println("Choose your role: ");
        System.out.println("1. Administrator");
        System.out.println("2. Customer");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Logged in as Administrator");
            boolean adminLoggedIn = true;
            while (adminLoggedIn) {
                System.out.println("1. Add Vehicle");
                System.out.println("2. Remove Vehicle");
                System.out.println("3. Add Customer");
                System.out.println("4. Remove Customer");
                System.out.println("5. Display Available Vehicles");
                System.out.println("6. Logout");
                System.out.print("Choose an action: ");
                int action = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (action) {
                    case 1:
                        System.out.print("Enter vehicle type (1: Car, 2: Truck, 3: Motorcycle): ");
                        int vehicleType = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter vehicle ID: ");
                        String vehicleId = scanner.nextLine();
                        System.out.print("Enter model: ");
                        String model = scanner.nextLine();
                        System.out.print("Enter base rental rate: ");
                        double baseRentalRate = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline

                        if (vehicleType == 1) {
                            System.out.print("Enter number of doors: ");
                            int numberOfDoors = scanner.nextInt();
                            Vehicle car = new Car(vehicleId, model, baseRentalRate, numberOfDoors);
                            agency.addVehicle(car);
                        } else if (vehicleType == 2) {
                            System.out.print("Enter load capacity: ");
                            double loadCapacity = scanner.nextDouble();
                            Vehicle truck = new Truck(vehicleId, model, baseRentalRate, loadCapacity);
                            agency.addVehicle(truck);
                        } else if (vehicleType == 3) {
                            System.out.print("Does it have a sidecar? (true/false): ");
                            boolean hasSidecar = scanner.nextBoolean();
                            Vehicle motorcycle = new Motorcycle(vehicleId, model, baseRentalRate, hasSidecar);
                            agency.addVehicle(motorcycle);
                        } else {
                            System.out.println("Invalid vehicle type.");
                        }
                        break;
                    case 2:
                        System.out.print("Enter vehicle ID to remove: ");
                        String removeVehicleId = scanner.nextLine();
                        agency.removeVehicle(removeVehicleId);
                        break;
                    case 3:
                        System.out.print("Enter customer ID: ");
                        Long customerId = scanner.nextLong();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter customer name: ");
                        String customerName = scanner.nextLine();
                        System.out.print("Enter customer contact info: ");
                        String contactInfo = scanner.nextLine();
                        Customer newCustomer = new Customer(customerId, customerName, contactInfo);
                        agency.registerCustomer(newCustomer);
                        break;
                    case 4:
                        System.out.print("Enter customer ID to remove: ");
                        Long removeCustomerId = scanner.nextLong();
                        agency.removeCustomer(removeCustomerId);
                        break;
                    case 5:
                        agency.displayAvailableVehicles();
                        break;
                    case 6:
                        adminLoggedIn = false;
                        System.out.println("Logged out.");
                        break;
                    default:
                        System.out.println("Invalid action.");
                        break;
                }
            }
        } else if (choice == 2) {
            System.out.println("Logged in as Customer");
            agency.displayAvailableVehicles();
            System.out.println("Choose a category to view vehicles: ");
            System.out.println("1. Car");
            System.out.println("2. Truck");
            System.out.println("3. Motorcycle");
            System.out.print("Enter your choice: ");
            int categoryChoice = scanner.nextInt();

            switch (categoryChoice) {
                case 1:
                    agency.displayVehiclesByCategory(Car.class);
                    break;
                case 2:
                    agency.displayVehiclesByCategory(Truck.class);
                    break;
                case 3:
                    agency.displayVehiclesByCategory(Motorcycle.class);
                    break;
                default:
                    System.out.println("Invalid category.");
                    break;
            }
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}