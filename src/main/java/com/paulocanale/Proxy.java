package com.paulocanale;

/**
 * Proxy Pattern Example
 * 
 * The Proxy pattern provides a surrogate or placeholder for another object to control
 * access to it. 
 * This example demonstrates a virtual proxy that delays the loading of an image until 
 * it is needed for display.
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

// Subject interface
interface Image {
    void display();
}

// Real Subject: RealImage
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}

// Proxy class: ProxyImage
class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); // Load only when needed
        }
        realImage.display();
    }
}

// Main class to demonstrate the Proxy pattern
public class Proxy {
    public static void main(String[] args) {
        Image image = new ProxyImage("photo.jpg");

        System.out.println("Image will be loaded on demand:");
        image.display(); // First call loads the image
        System.out.println("Image already loaded:");
        image.display(); // Second call reuses the loaded image
    }
}
