package main.java.com.lab111.labwork7;


import java.awt.Rectangle;

public class Pixel implements Flyweight {
    Draw draw;
    @Override
    public void draw(Rectangle rectangle) {
        draw.drawPixel(rectangle.x + rectangle.width, rectangle.y + rectangle.height);
    }

    @Override
    public void setDraw(Draw draw) {
        System.out.println("Done!");
        this.draw = draw;
    }

    @Override
    public Memento getMemento() {
        return null;
    }
}
