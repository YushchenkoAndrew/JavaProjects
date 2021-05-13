package main.java.com.lab111.labwork5;

import article.GUI.Label;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class RealImage implements Image {
    String path;
    Label label;
    BufferedImage image;
    public RealImage(String path, Label label) throws Exception {
        this.path = path;
        this.label = label;

        load(ImageIO.read(new File(path)));
    }

    public void load(BufferedImage image) {
        this.image = image;
        label.getLabel().setIcon(new ImageIcon(image));
        System.out.println(path);
    }

    @Override
    public void setSize(int width, int height) {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();

        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();
        load(bufferedImage);
        label.setBounds(new Rectangle(252, 2, width, height));

        System.out.println("RealImage - setSize");
    }

    @Override
    public int checkPixelColor(int x, int y) {
        System.out.println("RealImage - checkPixelColor");
        return image.getRGB(x, y);
    }

    public BufferedImage getImage() {
        return image;
    }
}
