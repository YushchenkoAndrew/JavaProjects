package main.java.com.lab111.labwork9;


import java.awt.Rectangle;
import java.awt.*;

public class Line implements Flyweight {
    Draw draw;
    Memento memento;

    public MementoShape getMemento() {
        return new MementoShape(new Color(0, 0, 0), null, null, 1);
    }

    @Override
    public void draw(Rectangle rectangle, double degree) {
        draw.drawLine(rectangle, degree);
    }

    @Override
    public void setDraw(Draw draw) {
        this.draw = draw;
    }
}
