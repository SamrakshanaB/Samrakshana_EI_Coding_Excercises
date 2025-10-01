package com.smartoffice.observer;

public class AirConditioner extends Device {
    public AirConditioner() { super("Air Conditioner"); }

    @Override
    public void update(boolean occupied) {
        if (occupied) System.out.println("AC turned on.");
        else System.out.println("AC turned off.");
    }
}
