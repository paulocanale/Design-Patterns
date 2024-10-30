package com.paulocanale;

import java.util.Stack;

/**
 * Memento Pattern Example
 * 
 * The Memento pattern captures and restores the internal state of an object without
 * exposing its implementation details. 
 * This example demonstrates a text editor that can save and restore content states.
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

// Memento class
class TextMemento {
    private String content;

    public TextMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// Originator class: TextEditor
class TextEditor {
    private String content;

    public void write(String text) {
        content = text;
    }

    public String getContent() {
        return content;
    }

    public TextMemento save() {
        return new TextMemento(content);
    }

    public void restore(TextMemento memento) {
        content = memento.getContent();
    }
}

// Caretaker class: EditorHistory
class EditorHistory {
    private Stack<TextMemento> history = new Stack<>();

    public void save(TextEditor editor) {
        history.push(editor.save());
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            editor.restore(history.pop());
        } else {
            System.out.println("No states to undo.");
        }
    }
}

// Main class to demonstrate the Memento pattern
public class Memento {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        EditorHistory history = new EditorHistory();

        editor.write("Version 1");
        history.save(editor);
        System.out.println("Content: " + editor.getContent());

        editor.write("Version 2");
        history.save(editor);
        System.out.println("Content: " + editor.getContent());

        editor.write("Version 3");
        System.out.println("Content: " + editor.getContent());

        System.out.println("\nUndoing changes:");
        history.undo(editor);
        System.out.println("Content: " + editor.getContent());

        history.undo(editor);
        System.out.println("Content: " + editor.getContent());
    }
}
