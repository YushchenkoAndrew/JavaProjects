package main.java.com.lab111.labwork9;


import java.awt.Rectangle;
import java.awt.*;

public class Oval implements Flyweight {
    Draw draw;
    @Override
    public void draw(Rectangle rectangle, double degree) {
        draw.drawOval(rectangle);
    }

    public void setDraw(Draw draw) {
        this.draw = draw;
    }

    @Override
    public MementoShape getMemento() {
        return new MementoShape(new Color(0, 0, 0), null, null, 1);
    }
}
