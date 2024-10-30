package com.paulocanale;

import java.util.ArrayList;
import java.util.List;

/**
 * Command Pattern Example
 * 
 * The Command pattern encapsulates a request as an object, allowing clients to
 * parameterize with different requests, queue, or log requests, and support
 * undoable operations. 
 * This example demonstrates a light control system with commands to turn on 
 * and off a light.
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

// Command interface
interface CommandPattern {
    void execute();
}

// Receiver class: Light
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Concrete Command: TurnOnCommand
class TurnOnCommand implements CommandPattern {
    private Light light;

    public TurnOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete Command: TurnOffCommand
class TurnOffCommand implements CommandPattern {
    private Light light;

    public TurnOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Invoker class: RemoteControl
class RemoteControl {
    private List<CommandPattern> commandHistory = new ArrayList<>();

    public void submit(CommandPattern command) {
        command.execute();
        commandHistory.add(command);
    }
}

// Main class to demonstrate the Command pattern
public class Command {
    public static void main(String[] args) {
        Light light = new Light();

        // Create commands
        CommandPattern turnOn = new TurnOnCommand(light);
        CommandPattern turnOff = new TurnOffCommand(light);

        // Invoker
        RemoteControl remote = new RemoteControl();

        // Execute commands
        remote.submit(turnOn);   // Output: Light is ON
        remote.submit(turnOff);  // Output: Light is OFF
    }
}
