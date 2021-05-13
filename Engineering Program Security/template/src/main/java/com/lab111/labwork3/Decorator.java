package main.java.com.lab111.labwork3;

public class Decorator implements Image {
    Image component;

    public Decorator(Image image) {
        component = image;
    }

    @Override
    public void setSize(int width, int height) {
        component.setSize(width, height);
        System.out.println("Decorator - setSize");
    }

    @Override
    public int checkPixelColor(int x, int y) {
        System.out.println("Decorator - checkPixelColor");
        return component.checkPixelColor(x, y);
    }
}
