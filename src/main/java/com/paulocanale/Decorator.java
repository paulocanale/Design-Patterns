package com.paulocanale;

/**
 * Decorator Pattern Example
 * 
 * The Decorator pattern allows additional functionalities to be added to an object
 * dynamically. 
 * This pattern is useful for extending the capabilities of a class in a flexible and 
 * reusable way.
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

// Component interface
interface Notifier {
    void send(String message);
}

// Concrete Component: Basic Notifier
class BasicNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending basic notification: " + message);
    }
}

// Abstract Decorator class
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

// Concrete Decorator: EmailNotifier
class EmailNotifier extends NotifierDecorator {
    public EmailNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending email notification: " + message);
    }
}

// Concrete Decorator: SMSNotifier
class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS notification: " + message);
    }
}

// Main class to demonstrate the Decorator pattern
public class Decorator {
    public static void main(String[] args) {
        // Basic notification
        Notifier notifier = new BasicNotifier();
        notifier.send("Hello!");

        System.out.println("\nAdding Email and SMS Decorators:");

        // Adding Email and SMS decorators
        Notifier emailNotifier = new EmailNotifier(notifier);
        Notifier smsNotifier = new SMSNotifier(emailNotifier);
        smsNotifier.send("Hello with enhancements!");
    }
}
