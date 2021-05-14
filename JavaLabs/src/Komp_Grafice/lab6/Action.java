package Komp_Grafice.lab6;

import article.ActionEvent.ActionEvent;

import javax.swing.*;
import java.awt.*;

public class Action extends ActionEvent {
    Draw draw;

    public void setDraw(Draw draw) {
        this.draw = draw;
    }

    @Override
    public void pressButton(int index) throws Exception {
        draw.setCoordinate(Integer.parseInt(gui.textFields[1].getText()), Integer.parseInt(gui.textFields[3].getText()), Integer.parseInt(gui.textFields[5].getText()));
        draw.builtShape();

        repaint();
    }


    private void repaint() {
        draw.revalidate();
        draw.repaint();

        gui.arrayPanel[1].repaint();
    }

    int x, y;       //start Coordinate
    Timer timer;

    @Override
    public void mousePressed() {
        timer = new Timer( Integer.parseInt(gui.textFields[7].getText()), e -> mousePressedMove());
        x = MouseInfo.getPointerInfo().getLocation().x;
        y = MouseInfo.getPointerInfo().getLocation().y;
        timer.start();
    }

    @Override
    public void mouseReleased() {
        if (timer != null)
            timer.stop();

    }

    public void mousePressedMove() {

        if ((Math.abs((x - MouseInfo.getPointerInfo().getLocation().x) - (y - MouseInfo.getPointerInfo().getLocation().y)) < 10)  && ((x - MouseInfo.getPointerInfo().getLocation().x) != 0) && ((y - MouseInfo.getPointerInfo().getLocation().y) != 0))
            draw.changeDegreeOZ(0.05 * (x - MouseInfo.getPointerInfo().getLocation().x) / Math.abs((x - MouseInfo.getPointerInfo().getLocation().x)));
        else {
            if (x - MouseInfo.getPointerInfo().getLocation().x > 0)
                draw.changeDegreeOY(0.05);

            if (x - MouseInfo.getPointerInfo().getLocation().x < 0)
                draw.changeDegreeOY(-0.05);

            if (y - MouseInfo.getPointerInfo().getLocation().y > 0)
                draw.changeDegreeOX(0.05);

            if (y - MouseInfo.getPointerInfo().getLocation().y < 0)
                draw.changeDegreeOX(-0.05);

        }
//        if (MouseInfo.getPointerInfo().getLocation().x - MouseInfo.getPointerInfo().getLocation().y > 2)
//            draw.changeDegreeOZ(0.05);

        x = MouseInfo.getPointerInfo().getLocation().x;
        y = MouseInfo.getPointerInfo().getLocation().y;

        draw.eraseShapes();
        draw.setCoordinate(Integer.parseInt(gui.textFields[1].getText()), Integer.parseInt(gui.textFields[3].getText()), Integer.parseInt(gui.textFields[5].getText()));

        draw.builtShape();
        repaint();
    }
}
