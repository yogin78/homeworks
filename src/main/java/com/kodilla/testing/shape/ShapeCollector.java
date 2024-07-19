package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> shapes;

    public ShapeCollector() {
        shapes = new ArrayList<>();
    }

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        return shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        if (n >= 0 && n < shapes.size()) {
            return shapes.get(n);
        }
        return null;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public String showFigures() {
        StringBuilder figures = new StringBuilder();
        for (Shape shape : shapes) {
            figures.append(shape.getShapeName()).append(" ");
        }
        return figures.toString();
    }

    public static void main(String[] args) {
        ShapeCollector collector = new ShapeCollector();

        Shape circle = new Circle(5);
        Shape square = new Square(4);
        Shape triangle = new Triangle(3, 6);

        collector.addFigure(circle);
        collector.addFigure(square);
        collector.addFigure(triangle);

        System.out.println("All figures: " + collector.showFigures());

        collector.removeFigure(square);
        System.out.println("After removing square: " + collector.showFigures());

        Shape retrievedShape = collector.getFigure(1);
        if (retrievedShape != null) {
            System.out.println("Retrieved shape: " + retrievedShape.getShapeName());
        }
    }
}
