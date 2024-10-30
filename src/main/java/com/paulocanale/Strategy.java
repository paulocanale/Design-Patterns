package com.paulocanale;

/**
 * Strategy Pattern Example
 * 
 * The Strategy pattern allows defining a family of algorithms, encapsulating each one,
 * and making them interchangeable. 
 * This example demonstrates a payment system where different payment methods can be 
 * selected at runtime.
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

// Strategy interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategy: CreditCardPayment
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card (Card Number: " + cardNumber + ")");
    }
}

// Concrete Strategy: PayPalPayment
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal (Email: " + email + ")");
    }
}

// Context class: ShoppingCart
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment method selected.");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}

// Main class to demonstrate the Strategy pattern
public class Strategy {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Set the payment strategy to CreditCard and checkout
        cart.setPaymentStrategy(new CreditCardPayment("3333-1234-3333-1234"));
        cart.checkout(100.0);

        // Change the payment strategy to PayPal and checkout
        cart.setPaymentStrategy(new PayPalPayment("paulocanale@me.com"));
        cart.checkout(333.0);
    }
}
