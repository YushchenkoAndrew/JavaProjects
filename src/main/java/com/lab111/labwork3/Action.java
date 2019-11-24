package main.java.com.lab111.labwork3;

import article.GUI.GUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Action extends article.ActionEvent.ActionEvent {
    private main.java.com.lab111.labwork3.Image image;

    @Override
    public void setGUI(GUI gui) {
        super.setGUI(gui);
    }

    int width;
    int height;

    @Override
    public void pressButton(int index) throws Exception {
        switch (index) {
            case 0: {
                 image = new RealImage(gui.textFields[1].getText(), gui.label[0]);
                 width = ImageIO.read(new File(gui.textFields[1].getText())).getWidth();
                 height = ImageIO.read(new File(gui.textFields[1].getText())).getHeight();
                 break;
            }
            case 1: {
                image = new Decorator(new RealImage(gui.textFields[1].getText(), gui.label[0]));
                image.setSize(Integer.valueOf(gui.textFields[3].getText()), Integer.valueOf(gui.textFields[5].getText()));

                width = Integer.valueOf(gui.textFields[3].getText());
                height = Integer.valueOf(gui.textFields[5].getText());

                gui.label[1].setBackground(new Color(image.checkPixelColor(1, 1)));
                break;
            }
        }
    }

    public void mouseClicked() {
        if (MouseInfo.getPointerInfo().getLocation().x >= 460 && MouseInfo.getPointerInfo().getLocation().x <= width + 458 && MouseInfo.getPointerInfo().getLocation().y >= 82 && MouseInfo.getPointerInfo().getLocation().y <= height + 80) {
            Color color = new Color(image.checkPixelColor(MouseInfo.getPointerInfo().getLocation().x - 460, MouseInfo.getPointerInfo().getLocation().y - 80));
            gui.label[1].setBackground(color);

            gui.textFields[6].setText("r:" + color.getRed() + ", g:" + color.getGreen() + ", b:" + color.getBlue());

            System.out.println("X  - " + (MouseInfo.getPointerInfo().getLocation().x - 460));
            System.out.println("Y  - " + (MouseInfo.getPointerInfo().getLocation().y - 50));
        }
    }
}
