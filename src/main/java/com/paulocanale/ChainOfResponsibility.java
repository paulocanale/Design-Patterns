package com.paulocanale;

/**
 * Chain of Responsibility Pattern Example
 * 
 * The Chain of Responsibility pattern allows a request to pass through a chain of handlers
 * until it is processed. 
 * This example demonstrates a logging system where each handler processes logs of a specific 
 * level (INFO, WARNING, ERROR).
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

// Abstract Handler class
abstract class Logger {
    public static int INFO = 1;
    public static int WARNING = 2;
    public static int ERROR = 3;

    protected int level;
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract void write(String message);
}

// Concrete Handler: InfoLogger
class InfoLogger extends Logger {
    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("INFO: " + message);
    }
}

// Concrete Handler: WarningLogger
class WarningLogger extends Logger {
    public WarningLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("WARNING: " + message);
    }
}

// Concrete Handler: ErrorLogger
class ErrorLogger extends Logger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("ERROR: " + message);
    }
}

// Main class to demonstrate the Chain of Responsibility pattern
public class ChainOfResponsibility {
    private static Logger getChainOfLoggers() {
        Logger errorLogger = new ErrorLogger(Logger.ERROR);
        Logger warningLogger = new WarningLogger(Logger.WARNING);
        Logger infoLogger = new InfoLogger(Logger.INFO);

        // Set up the chain: INFO -> WARNING -> ERROR
        infoLogger.setNextLogger(warningLogger);
        warningLogger.setNextLogger(errorLogger);

        return infoLogger;
    }

    public static void main(String[] args) {
        Logger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(Logger.INFO, "This is an information message.");
        loggerChain.logMessage(Logger.WARNING, "This is a warning message.");
        loggerChain.logMessage(Logger.ERROR, "This is an error message.");
    }
}
