package main.java.com.lab111.labwork4;

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
}
