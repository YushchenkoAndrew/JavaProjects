package main.java.com.lab111.labwork7;

import java.awt.*;
import java.awt.Rectangle;

public class MementoShape implements Memento {
    Color color;
    java.awt.Rectangle rectangle;
    double size;

    public MementoShape(Color color, java.awt.Rectangle rectangle, int size) {
        this.color = color;
        this.rectangle = rectangle;
        this.size = size;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setRectangle(java.awt.Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public void setSize(double x) {
        this.size = x;
    }

    @Override
    public double getSize() {
        return size;
    }
}
