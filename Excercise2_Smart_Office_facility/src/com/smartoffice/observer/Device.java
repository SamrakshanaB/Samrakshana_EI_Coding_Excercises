package com.smartoffice.observer;

public abstract class Device implements Observer {
    protected String name;

    public Device(String name) {
        this.name = name;
    }
}
