# Patterns - Java Design Patterns

Welcome to the **Patterns** project! This repository is a comprehensive collection of design pattern implementations in Java, crafted with an educational purpose. Design patterns are proven solutions to common problems in software development, providing a structured approach to building scalable, maintainable, and flexible applications. By following best practices and theoretical modeling, design patterns help developers tackle recurring challenges with reliable solutions.

As a software engineer, I’ve developed these examples to offer a hands-on, didactic approach to understanding and applying design patterns in real-world scenarios. This project serves as a practical guide for anyone looking to deepen their understanding of Java design patterns, encapsulating both theoretical concepts and concrete implementations.

The project is open-source and available for all, welcoming those interested in learning about or referencing design patterns, with no commercial intent. Feel free to explore, clone, and experiment with these examples to strengthen your foundation in writing clean, robust Java applications.

## Creational Patterns

1. **Singleton**: Ensures a class has only one instance and provides a global point of access. Common use cases include configuration settings and database connections. [Singleton Class](src/main/java/com/paulocanale/Singleton.java)
2. **Factory Method**: Defines an interface for creating objects, allowing subclasses to alter the type of created objects. Useful for handling multiple types of similar products. [Factory Method Class](src/main/java/com/paulocanale/FactoryMethod.java)
3. **Abstract Factory**: Allows for the creation of related object families without specifying concrete classes, ideal for multi-platform object creation. [Abstract Factory Class](src/main/java/com/paulocanale/AbstractFactory.java)
4. **Builder**: Separates object construction from representation, creating objects step-by-step. Useful for objects with many parameters. [Builder Class](src/main/java/com/paulocanale/Builder.java)
5. **Prototype**: Creates new objects by copying a prototype instance, ideal for efficiently creating similar objects. [Prototype Class](src/main/java/com/paulocanale/Prototype.java)

## Structural Patterns

1. **Adapter**: Converts a class's interface to another expected by clients, allowing incompatible classes to work together. [Adapter Class](src/main/java/com/paulocanale/Adapter.java)
2. **Bridge**: Decouples an abstraction from its implementation, allowing both to vary independently. [Bridge Class](src/main/java/com/paulocanale/Bridge.java)
3. **Composite**: Treats individual and composite objects uniformly, suitable for hierarchical structures like file systems. [Composite Class](src/main/java/com/paulocanale/Composite.java)
4. **Decorator**: Dynamically adds functionalities to an object without altering its class. Ideal for extending behaviors. [Decorator Class](src/main/java/com/paulocanale/Decorator.java)
5. **Facade**: Provides a simplified interface to a complex subsystem. Useful for simplifying interactions with complex systems. [Facade Class](src/main/java/com/paulocanale/Facade.java)
6. **Flyweight**: Optimizes memory by sharing common state among objects instead of storing it in each one. [Flyweight Class](src/main/java/com/paulocanale/Flyweight.java)
7. **Proxy**: Acts as a representative for another object, controlling access to it. [Proxy Class](src/main/java/com/paulocanale/Proxy.java)

## Behavioral Patterns

1. **Chain of Responsibility**: Passes requests along a chain of handlers, with each handler deciding to process or pass it along. [Chain of Responsibility Class](src/main/java/com/paulocanale/ChainOfResponsibility.java)
2. **Command**: Encapsulates a request as an object, allowing parameterization of clients and queuing of requests. [Command Class](src/main/java/com/paulocanale/Command.java)
3. **Interpreter**: Defines a representation for a language’s grammar and interprets sentences of the language. [Interpreter Class](src/main/java/com/paulocanale/Interpreter.java)
4. **Iterator**: Provides a way to access elements in a collection sequentially without exposing its underlying representation. [Iterator Class](src/main/java/com/paulocanale/Iterator.java)
5. **Mediator**: Centralizes communication between classes, reducing dependencies. [Mediator Class](src/main/java/com/paulocanale/Mediator.java)
6. **Memento**: Allows capturing and restoring an object's internal state without breaking encapsulation. Useful for implementing undo functionalities. [Memento Class](src/main/java/com/paulocanale/Memento.java)
7. **Observer**: Sets up a one-to-many dependency, notifying dependents of any state changes. Common in event handling and state change scenarios. [Observer Class](src/main/java/com/paulocanale/Observer.java)
8. **State**: Allows an object to alter its behavior when its internal state changes. [State Class](src/main/java/com/paulocanale/State.java)
9. **Strategy**: Enables choosing an algorithm at runtime, ideal for interchangeable algorithms within an application. [Strategy Class](src/main/java/com/paulocanale/Strategy.java)
10. **Template Method**: Defines the skeleton of an algorithm in a method, allowing subclasses to redefine specific steps. [Template Method Class](src/main/java/com/paulocanale/TemplateMethod.java)
11. **Visitor**: Represents an operation performed on elements of an object structure, adding new operations without changing the class of elements. [Visitor Class](src/main/java/com/paulocanale/Visitor.java)

---