package com.paulocanale;

/**
 * Singleton Pattern Example
 * 
 * The Singleton pattern ensures that a class has only one instance and provides
 * a global point of access to it. 
 * This example demonstrates a thread-safe implementation of the Singleton pattern, 
 * using lazy initialization.
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

class SingletonPattern {
    // Static variable to hold the single instance of the class
    private static SingletonPattern instance;

    // Private constructor to prevent instantiation from other classes
    private SingletonPattern() {
        // Initialization code here (if needed)
    }

    /**
     * This method provides access to the Singleton instance.
     * Uses synchronized to ensure thread safety when multiple threads attempt to
     * access the instance.
     * 
     * @return SingletonPattern - the single instance of this class
     */
    public static synchronized SingletonPattern getInstance() {
        if (instance == null) {
            instance = new SingletonPattern(); // Lazy initialization
        }
        return instance;
    }

    /**
     * Example method that can be accessed from the Singleton instance.
     */
    public void showMessage() {
        System.out.println("Hello from the Singleton instance!");
    }
}

// Main class to demonstrate the Singleton pattern
public class Singleton {
    public static void main(String[] args) {
        // Get the Singleton instance
        SingletonPattern singletonInstance1 = SingletonPattern.getInstance();

        // Use the instance to call a method
        singletonInstance1.showMessage();

        // Retrieve the Singleton instance again and check if it's the same
        SingletonPattern singletonInstance2 = SingletonPattern.getInstance();

        // Verify both instances are the same
        if (singletonInstance1 == singletonInstance2) {
            System.out.println("Both instances are the same.");
        } else {
            System.out.println("Instances are different, Singleton is not working as expected.");
        }
    }
}
