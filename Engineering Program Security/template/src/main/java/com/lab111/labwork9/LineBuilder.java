package main.java.com.lab111.labwork9;

import java.awt.*;
import java.awt.Rectangle;

public class LineBuilder implements Builder {
    private Action action;

    @Override
    public void buildShape(int[] data) {
        try {
            action.pressButton(2);
        } catch (Exception e) {
            System.out.println("Nooo");
        }

        action.draw.setFlag(false);
        action.shapes.get(action.shapes.size() - 1).draw(new java.awt.Rectangle(data[0], data[1], data[2], data[3]), 0);
        action.mementos[action.mementoIndex] = action.shapes.get(action.shapes.size() - 1).getMemento();

        action.mementos[action.mementoIndex].setRectangle(new Rectangle(data[0], data[1], data[2], data[3]));
        if (data[4] == 1)
            action.mementos[action.mementoIndex].setColorFill(new Color(data[5], data[6], data[7]));

        action.mementos[action.mementoIndex++].setColor(new Color(data[5], data[6], data[7]));

        action.draw.setMementos(action.mementos);
        action.draw.revalidate();
        action.draw.repaint();

        action.gui.arrayPanel[1].repaintPanel();
        action.drawFirstElement = true;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
