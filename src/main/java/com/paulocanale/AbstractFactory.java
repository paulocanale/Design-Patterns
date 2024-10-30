package com.paulocanale;

/**
 * Abstract Factory Pattern Example
 * 
 * The Abstract Factory pattern provides an interface for creating families of related
 * or dependent objects without specifying their concrete classes. 
 * This example demonstrates creating different types of GUI components (Button and Checkbox)
 * for different operating systems (Windows and Mac).
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

// Abstract Product A: Button
interface Button {
    void paint();
}

// Concrete Product A1: WindowsButton
class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Painting a button in Windows style.");
    }
}

// Concrete Product A2: MacButton
class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Painting a button in Mac style.");
    }
}

// Abstract Product B: Checkbox
interface Checkbox {
    void paint();
}

// Concrete Product B1: WindowsCheckbox
class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Painting a checkbox in Windows style.");
    }
}

// Concrete Product B2: MacCheckbox
class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Painting a checkbox in Mac style.");
    }
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory: WindowsFactory
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Concrete Factory: MacFactory
class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Main class to demonstrate the Abstract Factory pattern
public class AbstractFactory {
    public static void main(String[] args) {
        // Choose the factory based on the operating system
        GUIFactory factory;
        String osType = "Windows"; // Change to "Mac" to test MacFactory

        if (osType.equalsIgnoreCase("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        // Create products
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        // Paint the products
        button.paint();     // Output depends on the factory type
        checkbox.paint();   // Output depends on the factory type
    }
}
