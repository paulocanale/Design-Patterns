package com.paulocanale;

/**
 * Template Method Pattern Example
 * 
 * The Template Method pattern defines the skeleton of an algorithm in an operation,
 * allowing subclasses to define certain steps without changing the algorithm's structure.
 * This example demonstrates a beverage preparation system where specific details of
 * preparing tea and coffee are implemented by subclasses.
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

// Abstract class defining the template method
abstract class Beverage {
    // Template method
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    protected abstract void brew();
    protected abstract void addCondiments();

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }
}

// Concrete class: Tea
class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}

// Concrete class: Coffee
class Coffee extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

// Main class to demonstrate the Template Method pattern
public class TemplateMethod {
    public static void main(String[] args) {
        Beverage tea = new Tea();
        Beverage coffee = new Coffee();

        System.out.println("Preparing tea:");
        tea.prepareRecipe();

        System.out.println("\nPreparing coffee:");
        coffee.prepareRecipe();
    }
}
