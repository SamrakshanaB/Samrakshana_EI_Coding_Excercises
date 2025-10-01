package com.example.designpatterns.creational.factory;

public class ShapeFactory {
    public static Shape getShape(String type) {
        return switch (type.toLowerCase()) {
            case "circle" -> new Circle();
            case "square" -> new Square();
            case "rectangle" -> new Rectangle();
            default -> throw new IllegalArgumentException("Unknown shape type");
        };
    }
}
