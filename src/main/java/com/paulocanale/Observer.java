package com.paulocanale;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer Pattern Example
 * 
 * The Observer pattern establishes a subscription mechanism to allow multiple
 * objects (observers) to listen to changes in another object (subject). 
 * This example demonstrates a temperature monitoring system where devices are 
 * notified when the temperature changes.
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

// Observer interface
interface ObserverPattern {
    void update(float temperature);
}

// Subject class
class TemperatureSensor {
    private List<ObserverPattern> observers = new ArrayList<>();
    private float temperature;

    public void addObserver(ObserverPattern observer) {
        observers.add(observer);
    }

    public void removeObserver(ObserverPattern observer) {
        observers.remove(observer);
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (ObserverPattern observer : observers) {
            observer.update(temperature);
        }
    }
}

// Concrete Observer: DisplayDevice
class DisplayDevice implements ObserverPattern {
    private String name;

    public DisplayDevice(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature) {
        System.out.println(name + " display updated: Current Temperature = " + temperature + "°C");
    }
}

// Main class to demonstrate the Observer pattern
public class Observer {
    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor();

        // Create observers
        DisplayDevice phoneDisplay = new DisplayDevice("Phone");
        DisplayDevice laptopDisplay = new DisplayDevice("Laptop");

        // Register observers
        sensor.addObserver(phoneDisplay);
        sensor.addObserver(laptopDisplay);

        // Change temperature and notify observers
        System.out.println("Setting temperature to 25°C:");
        sensor.setTemperature(25);

        System.out.println("\nSetting temperature to 30°C:");
        sensor.setTemperature(30);

        // Remove an observer and change temperature
        sensor.removeObserver(phoneDisplay);
        System.out.println("\nSetting temperature to 28°C after removing Phone display:");
        sensor.setTemperature(28);
    }
}
