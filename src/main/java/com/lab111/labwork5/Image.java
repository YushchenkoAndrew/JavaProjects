package main.java.com.lab111.labwork5;

import java.awt.image.BufferedImage;

public interface Image {
    int checkPixelColor(int x, int y);

    void setSize(int width, int height);

    BufferedImage getImage();
}
