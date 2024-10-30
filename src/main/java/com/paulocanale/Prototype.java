package com.paulocanale;

/**
 * Prototype Pattern Example
 * 
 * The Prototype pattern allows for the creation of new objects by copying an existing
 * instance (prototype). 
 * This pattern is useful when object creation is costly or complex.
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

interface PrototypePattern extends Cloneable {
    PrototypePattern clone();
}

// Concrete Prototype: Circle
class CircleImplPrototype implements PrototypePattern {
    private int radius;

    public CircleImplPrototype(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public CircleImplPrototype clone() {
        return new CircleImplPrototype(this.radius);
    }

    public void draw() {
        System.out.println("Drawing a circle with radius: " + radius);
    }
}

// Concrete Prototype: Rectangle
class RectangleImplPrototype implements PrototypePattern {
    private int width;
    private int height;

    public RectangleImplPrototype(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public RectangleImplPrototype clone() {
        return new RectangleImplPrototype(this.width, this.height);
    }

    public void draw() {
        System.out.println("Drawing a rectangle with width: " + width + " and height: " + height);
    }
}

// Main class to demonstrate the Prototype pattern
public class Prototype {
    public static void main(String[] args) {
        // Create an initial Circle instance
        CircleImplPrototype circle1 = new CircleImplPrototype(10);
        circle1.draw();

        // Clone the Circle instance
        CircleImplPrototype circle2 = circle1.clone();
        circle2.setRadius(20);
        circle2.draw();

        // Create an initial Rectangle instance
        RectangleImplPrototype rectangle1 = new RectangleImplPrototype(15, 25);
        rectangle1.draw();

        // Clone the Rectangle instance
        RectangleImplPrototype rectangle2 = rectangle1.clone();
        rectangle2.setWidth(30);
        rectangle2.setHeight(40);
        rectangle2.draw();
    }
}
