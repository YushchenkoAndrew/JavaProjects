package main.java.com.lab111.labwork5;

import java.awt.image.BufferedImage;

public class ConcreteObserver implements Observer {
    BufferedImage image;

    public ConcreteObserver(BufferedImage image) {
        this.image = image;

        if (image == null)
            System.out.println("Nooo!!");
    }

    @Override
    public void update(int a, int r, int g, int b) {
        for (int i = 0; i < image.getWidth(); i++)
            for (int j = 0; j < image.getHeight(); j++) {
                int p = image.getRGB(i, j);

                int newA = (p >> 24) & 0xFF;

                int newR;
                if (r > 170)
                    newR = ((p >> 16) & 0xFF) > r ? r : ((p >> 16) & 0xFF);
                else
                    newR = r * (p & 0xFF) / b;

                int newG = ((p >> 8) & 0xFF) > g ? g : ((p >> 8) & 0xFF);

                int newB;
                if (r < 170)
                    newB = (p & 0xFF) > b ? b : (p & 0xFF);
                else
                    newB = b * newR / r;

                image.setRGB(i, j,((newA << 24) | (newR << 16) | (newG << 8) | newB));

            }
    }

    @Override
    public void update() {
        System.out.println("Update!!!");
        for (int i = 0; i < image.getWidth(); i++)
            for (int j = 0; j < image.getHeight(); j++) {
                int p = image.getRGB(i, j);

                int a = (p >> 24) & 0xff;
                int r = (p >> 16)&0xff;
                int g = (p >> 8)&0xff;
                int b = p & 0xff;
                int newColor = (r + b + g) / 3;

                image.setRGB(i, j,((a << 24) | (newColor << 16) | (newColor << 8) | newColor));

            }
    }
}
