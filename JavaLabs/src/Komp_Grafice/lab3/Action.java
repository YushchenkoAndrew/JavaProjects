package Komp_Grafice.lab3;

import article.ActionEvent.ActionEvent;
import article.GUI.GUI;

import javax.swing.*;
import java.awt.*;

public class Action extends ActionEvent {

    private Draw draw;

    public void connection(Draw draw){
        this.draw = draw;
    }

    @Override
    public void setGUI(GUI gui) {
        super.setGUI(gui);
    }

    @Override
    public void pressButton(int index) throws Exception {
        switch (index) {
            case 0: {       //button for load parameters
                draw.setH_CONST(Integer.parseInt(gui.textFields[1].getText()));
                draw.setR_CONST(Integer.parseInt(gui.textFields[3].getText()));
                draw.setX_CONST(Integer.parseInt(gui.textFields[5].getText()));
                draw.setY_CONST(Integer.parseInt(gui.textFields[7].getText()) * (-1));
                gui.textFields[9].setText("(" + gui.textFields[5].getText() + ", " + Integer.valueOf(gui.textFields[3].getText()) + ")");
                gui.textFields[11].setText("(" + gui.textFields[5].getText() + ", " + Integer.parseInt(gui.textFields[3].getText()) * (-1) + ")");
                draw.setDegreeY(0.25);
                draw.setDistanceY(10);
                draw.setDegreeX(0);
                System.out.println("Press");
                break;
            }
            case 1: {
                draw.setR_CONST(draw.getR_CONST() - 10);
                draw.setDistanceY(draw.getDistanceY() - 1);
                break;
            }
            case 2: {
                draw.setR_CONST(draw.getR_CONST() + 10);
                draw.setDistanceY(draw.getDistanceY() + 1);
                break;
            }
        }
        draw.revalidate();
        draw.repaint();

        gui.jFrame.repaint();
    }

    int x, y;       //start Coordinate
    Timer timer;

    @Override
    public void mousePressed() {
        System.out.println("Mouse Pressed!!!");
        timer = new Timer( 1, e -> mousePressedMove());
        x = MouseInfo.getPointerInfo().getLocation().x - 205;
        y = MouseInfo.getPointerInfo().getLocation().y - 80;
        timer.start();
    }

    @Override
    public void mouseReleased() {
        System.out.println("Mouse Released!!!");
        if (timer != null)
            timer.stop();

    }

    public void mousePressedMove() {
        System.out.println(MouseInfo.getPointerInfo().getLocation().x - 205 + " - X");
        System.out.println(MouseInfo.getPointerInfo().getLocation().y - 80 + " - Y");

        if (y - MouseInfo.getPointerInfo().getLocation().y > 2)
            draw.setViewY(draw.getDegreeY() - 0.05, 0.5);
        else
            if (y - MouseInfo.getPointerInfo().getLocation().y < -2)
                draw.setViewY(draw.getDegreeY() + 0.05, 0.5);

        if (x - MouseInfo.getPointerInfo().getLocation().x > 2)
            draw.setDegreeX(draw.getDegreeX() - 0.05);
        else
            if (x - MouseInfo.getPointerInfo().getLocation().x < -2)
                draw.setDegreeX(draw.getDegreeX() + 0.05);

        x = MouseInfo.getPointerInfo().getLocation().x;
        y = MouseInfo.getPointerInfo().getLocation().y;

        draw.revalidate();
        draw.repaint();

        gui.jFrame.repaint();
    }
}
