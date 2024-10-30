package com.paulocanale;

/**
 * Bridge Pattern Example
 * 
 * The Bridge pattern decouples an abstraction from its implementation, allowing
 * both to vary independently. 
 * This example demonstrates how a shape can be drawn with different colors by 
 * separating the shape (abstraction) and the color (implementation).
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

// Implementor interface
interface Color {
    void applyColor();
}

// Concrete Implementor: Red color
class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying red color.");
    }
}

// Concrete Implementor: Blue color
class BlueColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying blue color.");
    }
}

// Abstraction class
abstract class ShapeAbstraction {
    protected Color color;

    public ShapeAbstraction(Color color) {
        this.color = color;
    }

    public abstract void draw();
}

// Refined Abstraction: CircleImp
class CircleShape extends ShapeAbstraction {
    public CircleShape(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.print("Drawing a Circle with ");
        color.applyColor();
    }
}

// Refined Abstraction: SquareImpl
class SquareShape extends ShapeAbstraction {
    public SquareShape(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.print("Drawing a Square with ");
        color.applyColor();
    }
}

// Main class to demonstrate the Bridge pattern
public class Bridge {
    public static void main(String[] args) {
        // Create shapes with different colors
        ShapeAbstraction redCircle = new CircleShape(new RedColor());
        ShapeAbstraction blueSquare = new SquareShape(new BlueColor());

        // Draw shapes
        redCircle.draw();   // Output: Drawing a Circle with Applying red color.
        blueSquare.draw();  // Output: Drawing a Square with Applying blue color.
    }
}
