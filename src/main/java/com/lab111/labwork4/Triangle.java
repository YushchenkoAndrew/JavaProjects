package main.java.com.lab111.labwork4;

import java.awt.Rectangle;

public class Triangle implements Flyweight {
    Draw draw;
    @Override
    public void draw(Rectangle rectangle) {
        draw.drawTriangle(rectangle);
    }

    @Override
    public void setDraw(Draw draw) {
        this.draw = draw;
    }
}
