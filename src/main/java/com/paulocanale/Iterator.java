package com.paulocanale;

import java.util.ArrayList;
import java.util.List;

/**
 * Iterator Pattern Example
 * 
 * The Iterator pattern provides a way to access elements of a collection sequentially
 * without exposing its underlying representation. 
 * This example demonstrates iterating through a collection of names.
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

// Iterator interface
interface IteratorPattern<T> {
    boolean hasNext();
    T next();
}

// Collection interface
interface Collection<T> {
    IteratorPattern<T> createIterator();
}

// Concrete Iterator for the NameCollection
class NameIterator implements IteratorPattern<String> {
    private List<String> names;
    private int position = 0;

    public NameIterator(List<String> names) {
        this.names = names;
    }

    @Override
    public boolean hasNext() {
        return position < names.size();
    }

    @Override
    public String next() {
        if (this.hasNext()) {
            return names.get(position++);
        }
        return null;
    }
}

// Concrete Collection: NameCollection
class NameCollection implements Collection<String> {
    private List<String> names = new ArrayList<>();

    public void addName(String name) {
        names.add(name);
    }

    @Override
    public IteratorPattern<String> createIterator() {
        return new NameIterator(names);
    }
}

// Main class to demonstrate the Iterator pattern
public class Iterator {
    public static void main(String[] args) {
        NameCollection nameCollection = new NameCollection();
        nameCollection.addName("Paulo");
        nameCollection.addName("Cesar");
        nameCollection.addName("Italo");

        IteratorPattern<String> iterator = nameCollection.createIterator();

        System.out.println("Iterating through the NameCollection:");
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println("Name: " + name);
        }
    }
}
