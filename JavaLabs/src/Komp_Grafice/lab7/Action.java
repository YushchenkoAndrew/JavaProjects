package Komp_Grafice.lab7;

import article.ActionEvent.ActionEvent;

import javax.swing.*;
import java.awt.*;

public class Action extends ActionEvent {
    private Draw draw;
    private Timer timer;

    public void setDraw(Draw draw) {
        this.draw = draw;
    }

    @Override
    public void pressButton(int index) throws Exception {
        draw.setCoordinate(Double.parseDouble(gui.textFields[1].getText()), Double.parseDouble(gui.textFields[3].getText()), Double.parseDouble(gui.textFields[5].getText()), Double.parseDouble(gui.textFields[9].getText()));
        draw.setIntensity(Double.parseDouble(gui.textFields[11].getText()));
        draw.builtShape();
        if (timer != null)
            timer.stop();
        timer = new Timer(Integer.parseInt(gui.textFields[7].getText()), e -> shapeRotation());
        timer.start();
        repaint();
    }


    private void repaint() {
        draw.revalidate();
        draw.repaint();

        gui.arrayPanel[1].repaint();
    }

    private int rotationIndex;

    @Override
    public void pressedRadioButton(int index) {
        rotationIndex = index;
    }

    private void setRotationAxe(int index) {
        switch (index) {
            case 0: {
                draw.changeDegreeOX(0.05);
                break;
            }
            case 1: {
                draw.changeDegreeOY(0.05);
                break;
            }
            case 2: {
                draw.changeDegreeOZ(0.05);
                break;
            }
            case 3: {
                setRotationAxe(0);
                setRotationAxe(1);
                break;
            }
            case 4: {
                setRotationAxe(1);
                setRotationAxe(2);
                break;
            }
            case 5: {
                setRotationAxe(0);
                setRotationAxe(2);
                break;
            }
            case 6: {
                setRotationAxe(3);
                setRotationAxe(2);
                break;
            }
        }
    }

    public void shapeRotation() {
        setRotationAxe(rotationIndex);

        draw.eraseShapes();
        draw.setCoordinate(Integer.parseInt(gui.textFields[1].getText()), Integer.parseInt(gui.textFields[3].getText()), Integer.parseInt(gui.textFields[5].getText()), Double.parseDouble(gui.textFields[9].getText()));

        draw.builtShape();
        repaint();
    }

    private Timer mouseTimer;
    private int x;
    private int y;

    @Override
    public void mousePressed() {
        x = MouseInfo.getPointerInfo().getLocation().x;
        y = MouseInfo.getPointerInfo().getLocation().y;
        if (x - gui.jFrame.getX() - gui.arrayPanel[1].getBounds().x - 7 > draw.getLightCoordinate()[0][0] - 12 && x - gui.jFrame.getX() - gui.arrayPanel[1].getBounds().x - 7 < draw.getLightCoordinate()[0][0] + 12 && y - gui.jFrame.getY() - gui.arrayPanel[1].getBounds().y - 52 > draw.getLightCoordinate()[0][1] - 12 && y - gui.jFrame.getY() - gui.arrayPanel[1].getBounds().y - 52 < draw.getLightCoordinate()[0][1] + 12) {
            mouseTimer = new Timer(10, e -> mouseMoving());
            mouseTimer.start();
        }
    }

    @Override
    public void mouseReleased() {
        if (mouseTimer != null)
            mouseTimer.stop();
    }

    private void mouseMoving() {
        draw.setLightCoordinate(new double[][]{{draw.getLightCoordinate()[0][0] + MouseInfo.getPointerInfo().getLocation().x - x, draw.getLightCoordinate()[0][1] + MouseInfo.getPointerInfo().getLocation().y - y, draw.getLightCoordinate()[0][2]}});

        x = MouseInfo.getPointerInfo().getLocation().x;
        y = MouseInfo.getPointerInfo().getLocation().y;
        repaint();
    }
}
