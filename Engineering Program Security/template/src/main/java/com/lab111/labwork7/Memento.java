package main.java.com.lab111.labwork7;

import java.awt.*;
import java.awt.Rectangle;

public interface Memento {
    void setColor(Color color);
    Color getColor();

    void setRectangle(Rectangle rectangle);
    Rectangle getRectangle();

    void setSize(double size);
    double getSize();
}
