package com.example.designpatterns.creational.singleton;

public class LoggerSingleton {
    private static LoggerSingleton instance;

    private LoggerSingleton() {
        // private constructor
    }

    public static LoggerSingleton getInstance() {
        if (instance == null) {
            instance = new LoggerSingleton();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
