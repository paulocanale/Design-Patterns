package com.paulocanale;

import java.util.ArrayList;
import java.util.List;

/**
 * Mediator Pattern Example
 * 
 * The Mediator pattern provides a way to reduce the coupling between interacting
 * objects by having them communicate through a mediator. 
 * This example demonstrates a chat room where users communicate with each other 
 * through a ChatMediator.
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

// Mediator interface
interface ChatMediator {
    void sendMessage(String message, User user);

    void addUser(User user);
}

// Concrete Mediator: ChatRoom
class ChatRoom implements ChatMediator {
    private List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (u != user) { // send message to all users except the sender
                u.receive(message);
            }
        }
    }
}

// Colleague class: User
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);

    public abstract void receive(String message);
}

// Concrete Colleague: ConcreteUser
class ConcreteUser extends User {

    public ConcreteUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + " receives: " + message);
    }
}

// Main class to demonstrate the Mediator pattern
public class Mediator {
    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();

        User user1 = new ConcreteUser(chatRoom, "Paulo");
        User user2 = new ConcreteUser(chatRoom, "Cesar");
        User user3 = new ConcreteUser(chatRoom, "Italo");
        User user4 = new ConcreteUser(chatRoom, "Diana");

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);
        chatRoom.addUser(user4);

        user1.send("Hello, everyone!");
        user3.send("Hi, Paulo!");
    }
}
