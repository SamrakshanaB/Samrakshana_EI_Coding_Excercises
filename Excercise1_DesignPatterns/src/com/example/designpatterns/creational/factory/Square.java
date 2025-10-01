package com.example.designpatterns.creational.factory;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }

    @Override
    public void printStructure() {
        System.out.println("*******");
        System.out.println("*     *");
        System.out.println("*     *");
        System.out.println("*     *");
        System.out.println("*******");
    }
}
