package main.java.com.lab111.labwork8;

import java.awt.Rectangle;

public interface Flyweight {
    void draw(Rectangle rectangle, double degree);
    void setDraw(Draw draw);
    MementoShape getMemento();
}
