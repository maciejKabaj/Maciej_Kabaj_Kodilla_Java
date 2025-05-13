package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    List<Shape> shapes = new ArrayList<Shape>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        if (shapes.contains(shape)) {
            shapes.remove(shape);
            return true;
        }
        return false;
    }

    public Shape getFigure(int n) {
        if (n < 0 || n >= shapes.size()) {
            return null;
        }
        return shapes.get(n);
    }

    public String showFigures() {
        String myShapes = "";
        for (Shape shape : shapes) {
            myShapes += shape.getShapeName() + " ";
        }
        return myShapes.trim();
    }
}
