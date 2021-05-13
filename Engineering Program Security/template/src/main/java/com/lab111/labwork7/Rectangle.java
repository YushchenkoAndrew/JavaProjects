package main.java.com.lab111.labwork7;

import java.awt.*;

public class Rectangle implements Flyweight {
    Draw draw;
    @Override
    public void draw(java.awt.Rectangle rectangle) {
        draw.drawRectangle(rectangle);
    }

    @Override
    public void setDraw(Draw draw) {
        this.draw = draw;
    }

    @Override
    public Memento getMemento() {
        return new MementoShape(new Color(0, 0, 0), null, 1);
    }
}
