package main.java.com.lab111.labwork4;


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
}
