package com.smartoffice.observer;

public class Light extends Device {
    public Light() { super("Light"); }

    @Override
    public void update(boolean occupied) {
        if (occupied) System.out.println("Lights turned on.");
        else System.out.println("Lights turned off.");
    }
}
