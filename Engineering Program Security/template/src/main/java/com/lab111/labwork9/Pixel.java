package main.java.com.lab111.labwork9;


import java.awt.Rectangle;

public class Pixel implements Flyweight {
    Draw draw;
    @Override
    public void draw(Rectangle rectangle, double degree) {
        draw.drawPixel(rectangle.x + rectangle.width, rectangle.y + rectangle.height);
    }

    @Override
    public void setDraw(Draw draw) {
        System.out.println("Done!");
        this.draw = draw;
    }

    @Override
    public MementoShape getMemento() {
        return null;
    }
}
