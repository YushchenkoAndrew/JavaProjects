package main.java.com.lab111.labwork8;

import java.awt.Rectangle;
import java.awt.*;

public class Triangle implements Flyweight {
    Draw draw;
    @Override
    public void draw(Rectangle rectangle, double degree) {
        draw.drawTriangle(rectangle, degree);
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
