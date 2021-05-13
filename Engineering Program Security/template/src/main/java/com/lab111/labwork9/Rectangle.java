package main.java.com.lab111.labwork9;

import java.awt.*;

public class Rectangle implements Flyweight {
    Draw draw;
    @Override
    public void draw(java.awt.Rectangle rectangle, double degree) {
        draw.drawRectangle(rectangle, degree);
    }

    @Override
    public void setDraw(Draw draw) {
        this.draw = draw;
    }

    @Override
    public MementoShape getMemento() {
        return new MementoShape(new Color(0, 0, 0), null, null, 1);
    }
}
