package main.java.com.lab111.labwork7;


import java.awt.*;
import java.awt.Rectangle;

public class Line implements Flyweight {
    Draw draw;
    Memento memento;

    public Memento getMemento() {
        return new MementoShape(new Color(0, 0, 0), null, 1);
    }

    @Override
    public void draw(Rectangle rectangle) {
        draw.drawLine(rectangle);
    }

    @Override
    public void setDraw(Draw draw) {
        this.draw = draw;
    }
}
