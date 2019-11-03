package main.java.com.lab111.labwork9;

import java.awt.Rectangle;
import java.awt.*;

public interface Memento {
    void setColor(Color color);
    Color getColor();

    void setRectangle(Rectangle rectangle);
    Rectangle getRectangle();

    void setSize(double size);
    double getSize();

    void setColorFill(Color color);
    Color getColorFill();

    void setDegree(double degree);
    double getDegree();
}
