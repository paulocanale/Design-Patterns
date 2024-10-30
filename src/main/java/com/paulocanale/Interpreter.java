package com.paulocanale;

import java.util.Map;

/**
 * Interpreter Pattern Example
 * 
 * The Interpreter pattern defines a way to evaluate language grammar or expressions.
 * This example demonstrates a simple mathematical expression interpreter that can
 * evaluate addition and subtraction expressions.
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

// Abstract Expression
interface Expression {
    int interpret(Map<String, Integer> context);
}

// Terminal Expression: Number
class Number implements Expression {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int interpret(Map<String, Integer> context) {
        return number;
    }
}

// Terminal Expression: Variable
class Variable implements Expression {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Map<String, Integer> context) {
        return context.getOrDefault(name, 0);
    }
}

// Non-terminal Expression: Addition
class Addition implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public Addition(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret(Map<String, Integer> context) {
        return leftExpression.interpret(context) + rightExpression.interpret(context);
    }
}

// Non-terminal Expression: Subtraction
class Subtraction implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public Subtraction(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret(Map<String, Integer> context) {
        return leftExpression.interpret(context) - rightExpression.interpret(context);
    }
}

// Main class to demonstrate the Interpreter pattern
public class Interpreter {
    public static void main(String[] args) {
        // Example: (a + b) - c
        Expression a = new Variable("a");
        Expression b = new Variable("b");
        Expression c = new Variable("c");

        Expression addition = new Addition(a, b);
        Expression expression = new Subtraction(addition, c);

        // Define the context with variable values
        Map<String, Integer> context = Map.of("a", 5, "b", 10, "c", 4);

        // Interpret the expression: (5 + 10) - 4 = 11
        int result = expression.interpret(context);
        System.out.println("Result: " + result); // Output: Result: 11
    }
}
