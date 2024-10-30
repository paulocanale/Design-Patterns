package com.paulocanale;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight Pattern Example
 * 
 * The Flyweight pattern is used to minimize memory usage by sharing as much data
 * as possible with similar objects. 
 * This example demonstrates a system that manages a forest of trees where each tree 
 * shares common attributes like type and color.
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

// Flyweight class: TreeType
class TreeType {
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void display(int x, int y) {
        System.out.println("Displaying " + name + " tree at (" + x + ", " + y + ") with color " + color + " and texture " + texture);
    }
}

// Flyweight Factory: TreeFactory
class TreeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + color + texture;
        if (!treeTypes.containsKey(key)) {
            treeTypes.put(key, new TreeType(name, color, texture));
            System.out.println("Creating new TreeType: " + name);
        }
        return treeTypes.get(key);
    }
}

// Context class: Tree
class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void display() {
        type.display(x, y);
    }
}

// Main class to demonstrate the Flyweight pattern
public class Flyweight {
    public static void main(String[] args) {
        TreeType oakType = TreeFactory.getTreeType("Oak", "Green", "Rough");
        TreeType pineType = TreeFactory.getTreeType("Pine", "Dark Green", "Smooth");

        // Creating individual trees with shared TreeType instances
        Tree tree1 = new Tree(10, 20, oakType);
        Tree tree2 = new Tree(30, 40, oakType);
        Tree tree3 = new Tree(50, 60, pineType);

        // Display trees
        tree1.display();
        tree2.display();
        tree3.display();
    }
}
