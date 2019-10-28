package main.java.com.lab111.labwork7;


import java.awt.*;
import java.awt.Rectangle;

public class Oval implements Flyweight {
    Draw draw;
    @Override
    public void draw(Rectangle rectangle) {
        draw.drawOval(rectangle);
    }

    public void setDraw(Draw draw) {
        this.draw = draw;
    }

    @Override
    public Memento getMemento() {
        return new MementoShape(new Color(0, 0, 0), null, 1);
    }
}
