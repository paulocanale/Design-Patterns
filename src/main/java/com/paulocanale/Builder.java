package com.paulocanale;

/**
 * Builder Example
 * 
 * The Builder pattern allows for the step-by-step construction of complex
 * objects. 
 * This pattern is especially useful for creating objects with many optional 
 * parameters or configurations.
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

class House {
    // Required parameters
    private final String foundation;
    private final String structure;

    // Optional parameters
    private int windows;
    private int doors;
    private boolean hasRoof;
    private boolean hasGarage;
    private boolean hasSwimmingPool;

    // Private constructor to enforce object creation through Builder
    private House(HouseBuilder builder) {
        this.foundation = builder.foundation;
        this.structure = builder.structure;
        this.windows = builder.windows;
        this.doors = builder.doors;
        this.hasRoof = builder.hasRoof;
        this.hasGarage = builder.hasGarage;
        this.hasSwimmingPool = builder.hasSwimmingPool;
    }

    // Getters for House attributes
    public String getFoundation() {
        return foundation;
    }

    public String getStructure() {
        return structure;
    }

    public int getWindows() {
        return windows;
    }

    public int getDoors() {
        return doors;
    }

    public boolean hasRoof() {
        return hasRoof;
    }

    public boolean hasGarage() {
        return hasGarage;
    }

    public boolean hasSwimmingPool() {
        return hasSwimmingPool;
    }

    @Override
    public String toString() {
        return "House with foundation: " + foundation + ", structure: " + structure +
                ", windows: " + windows + ", doors: " + doors +
                ", roof: " + hasRoof + ", garage: " + hasGarage +
                ", swimming pool: " + hasSwimmingPool;
    }

    // Static inner Builder class
    public static class HouseBuilder {
        // Required parameters
        private final String foundation;
        private final String structure;

        // Optional parameters with default values
        private int windows = 0;
        private int doors = 0;
        private boolean hasRoof = false;
        private boolean hasGarage = false;
        private boolean hasSwimmingPool = false;

        // Constructor for required parameters
        public HouseBuilder(String foundation, String structure) {
            this.foundation = foundation;
            this.structure = structure;
        }

        // Methods to set optional parameters
        public HouseBuilder windows(int windows) {
            this.windows = windows;
            return this;
        }

        public HouseBuilder doors(int doors) {
            this.doors = doors;
            return this;
        }

        public HouseBuilder hasRoof(boolean hasRoof) {
            this.hasRoof = hasRoof;
            return this;
        }

        public HouseBuilder hasGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public HouseBuilder hasSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        // Build method to create House instance
        public House build() {
            return new House(this);
        }
    }
}

// Main class to demonstrate the Builder pattern
public class Builder {
    public static void main(String[] args) {
        // Using the Builder to create a House instance
        House house = new House.HouseBuilder("Concrete", "Wood")
                .windows(4)
                .doors(2)
                .hasRoof(true)
                .hasGarage(true)
                .hasSwimmingPool(false)
                .build();

        // Output the House details
        System.out.println(house);
    }
}
