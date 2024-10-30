package com.paulocanale;

/**
 * Factory Method Pattern Example
 * 
 * The Factory Method pattern defines an interface for creating an object, but lets
 * subclasses alter the type of object that will be created. 
 * This example demonstrates creating different types of vehicles using a factory method.
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

// Abstract product
abstract class Vehicle {
    public abstract void drive();
}

// Concrete product: Car
class Car extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car...");
    }
}

// Concrete product: Truck
class Truck extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a truck...");
    }
}

// Creator class with Factory Method Pattern
abstract class VehicleFactory {
    // Factory method
    public abstract Vehicle createVehicle();

    public void driveVehicle() {
        Vehicle vehicle = createVehicle();
        vehicle.drive();
    }
}

// Concrete Factory: CarFactory
class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}

// Concrete Factory: TruckFactory
class TruckFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Truck();
    }
}

// Main class to demonstrate the Factory Method pattern
public class FactoryMethod {
    public static void main(String[] args) {
        // Create factories
        VehicleFactory carFactory = new CarFactory();
        VehicleFactory truckFactory = new TruckFactory();

        // Use factories to create and drive vehicles
        carFactory.driveVehicle(); // Output: Driving a car...
        truckFactory.driveVehicle(); // Output: Driving a truck...
    }
}
