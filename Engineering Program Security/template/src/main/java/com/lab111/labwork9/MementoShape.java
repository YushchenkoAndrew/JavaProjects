package main.java.com.lab111.labwork9;

import java.awt.Rectangle;
import java.awt.*;

public class MementoShape implements Memento, Prototype {
    public Color color;
    public Rectangle rectangle;
    public Color shapeColor;
    public double size = 1;
    public double degree = 0;

    public MementoShape(Color color, Rectangle rectangle, Color shapeColor, double size) {
        this.color = color;
        this.rectangle = rectangle;
        this.shapeColor = shapeColor;
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
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public double getSize() {
        return size;
    }

    @Override
    public void setColorFill(Color c) {
        shapeColor = c;
    }

    @Override
    public Color getColorFill() {
        return shapeColor;
    }

    @Override
    public void setDegree(double degree) {
        this.degree = degree;
    }

    @Override
    public double getDegree() {
        return degree;
    }

    @Override
    public Object copy() {
        return new MementoShape(color, rectangle, shapeColor, size);
    }
}
