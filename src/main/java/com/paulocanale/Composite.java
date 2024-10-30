package com.paulocanale;

/**
 * Composite Pattern Example
 * 
 * The Composite pattern allows treating individual objects and compositions of objects
 * uniformly. 
 * This example demonstrates a structure of employees in an organization, where both individual 
 * employees and managers can be treated the same way.
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

import java.util.ArrayList;
import java.util.List;

// Component interface
interface Employee {
    void showDetails();
}

// Leaf class: Developer
class Developer implements Employee {
    private String name;
    private String position;

    public Developer(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showDetails() {
        System.out.println("Developer: " + name + ", Position: " + position);
    }
}

// Leaf class: Designer
class Designer implements Employee {
    private String name;
    private String position;

    public Designer(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showDetails() {
        System.out.println("Designer: " + name + ", Position: " + position);
    }
}

// Composite class: Manager
class Manager implements Employee {
    private String name;
    private String position;
    private List<Employee> subordinates;

    public Manager(String name, String position) {
        this.name = name;
        this.position = position;
        this.subordinates = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        subordinates.add(employee);
    }

    public void removeEmployee(Employee employee) {
        subordinates.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("Manager: " + name + ", Position: " + position);
        for (Employee e : subordinates) {
            e.showDetails();
        }
    }
}

// Main class to demonstrate the Composite pattern
public class Composite {
    public static void main(String[] args) {
        // Leaf nodes
        Developer dev1 = new Developer("Paulo", "Senior Developer");
        Developer dev2 = new Developer("Cesar", "Junior Developer");
        Designer des1 = new Designer("Italo", "UI/UX Designer");

        // Composite node (Manager) managing Developers and Designer
        Manager manager = new Manager("Mike", "Project Manager");
        manager.addEmployee(dev1);
        manager.addEmployee(dev2);
        manager.addEmployee(des1);

        // Display the structure
        System.out.println("Employee details under Project Manager:");
        manager.showDetails();
    }
}
