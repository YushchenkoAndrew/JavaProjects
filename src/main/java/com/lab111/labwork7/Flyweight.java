package main.java.com.lab111.labwork7;

import java.awt.Rectangle;

public interface Flyweight {
    void draw(Rectangle rectangle);
    void setDraw(Draw draw);
    Memento getMemento();
}
