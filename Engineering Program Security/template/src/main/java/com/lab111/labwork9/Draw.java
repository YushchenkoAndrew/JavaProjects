package main.java.com.lab111.labwork9;

import article.MathPackage.Matrix;

import javax.swing.*;
import java.awt.Rectangle;
import java.awt.*;
import java.awt.geom.Line2D;

public class Draw extends JPanel {

    private boolean flag = false;        //flag need to check buttons is pressed or not
    private boolean checkPressingFlag = true;

    MementoShape[] mementos;
    Matrix matrix = new Matrix();

    Color color;

    Shape[] shapes = new Shape[500];
    int[] shapeIndex = new int[500];        //yep, I know that is bad idea but why not. Index in this massive are the same like in pressButton - method in Action

    private int indexShape = 0;

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D graphics2D = (Graphics2D) g;
        for (int i = 0; i < indexShape; i++) {
            if (mementos[i] != null) {
                graphics2D.setColor(mementos[i].getColor());
                if (mementos[i].getColorFill() != null)
                    graphics2D.fill(shapes[i]);
            }
            else {
                graphics2D.setColor(new Color(0, 0, 0));
            }

            graphics2D.draw(shapes[i]);
        }

    }

    public void setMementos(MementoShape[] mementos) {
        this.mementos = mementos;
    }

    public void repaint() {
        super.repaint();
        flag = true;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void drawPixel(int x, int y) {
        shapeIndex[indexShape] = 0;
        shapes[indexShape++] = new Line2D.Float(x, y, x, y);
    }

    public void drawLine(Rectangle rectangle,  double degree) {

        checkPressing();
        shapeIndex[indexShape] = 2;

        shapes[indexShape++] = new Line2D.Float(rectangle.x - rectangle.width, rectangle.y - rectangle.height, rectangle.x + rectangle.width, rectangle.y + rectangle.height);
//        mementos.add(memento);
    }

    public void drawOval(Rectangle rectangle) {
        Polygon polygon = new Polygon();
        for (float i = 0; i < 2 * Math.PI; i += 0.006) {
            polygon.addPoint((int) (rectangle.width * Math.cos(i)) + rectangle.x, (int) (rectangle.height * Math.sin(i) + rectangle.y));
        }

        checkPressing();

        shapeIndex[indexShape] = 3;
        shapes[indexShape++] = polygon;
    }


    public void drawRectangle(Rectangle rectangle, double degree) {
        Polygon polygon = new Polygon();

        polygon.addPoint(rectangle.x - rectangle.width, rectangle.y - rectangle.height);
        polygon.addPoint(rectangle.x + rectangle.width, rectangle.y - rectangle.height);
        polygon.addPoint(rectangle.x + rectangle.width, rectangle.y + rectangle.height);
        polygon.addPoint(rectangle.x - rectangle.width, rectangle.y + rectangle.height);

        checkPressing();
        shapeIndex[indexShape] = 4;
        shapes[indexShape++] = polygon;
    }

    public void drawTriangle(Rectangle rectangle, double degree) {
        Polygon polygon = new Polygon();
        polygon.addPoint(rectangle.x, rectangle.y);
        polygon.addPoint(rectangle.x, rectangle.y + rectangle.height);
        polygon.addPoint(rectangle.x + rectangle.width, rectangle.y + rectangle.height);

        checkPressing();
        shapeIndex[indexShape] = 5;
        shapes[indexShape++] = polygon;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void removeAll() {
        for (int i = 0; i < indexShape; i++)
            shapes[i] = null;

        indexShape = 0;

        for (int i = 0; i < 500; i++)
            mementos[i] = null;

    }

    private void checkPressing() {
        if (flag && indexShape > 0 && checkPressingFlag) {
            shapes[indexShape - 1] = null;
            indexShape--;
//            mementos.remove(mementos.size() - 1);
        }
    }

    public void setMemento(int index, MementoShape memento) {
        mementos[index] = memento;
    }

    public int shiftShape(int index) {
        int store = shapeIndex[index];

        for (int i = index; i < indexShape; i++) {
            shapes[i] = shapes[i + 1];
            shapeIndex[i] = shapeIndex[i + 1];
        }
        indexShape--;
        return store;
    }

    public MementoShape[] getMementos() {
        return mementos.clone();
    }

    public void setIndexShape(int indexShape) {
        this.indexShape = indexShape;
    }

    public int getIndexShape() {
        return indexShape;
    }


    public void setCheckPressingFlag(boolean flag) {
        checkPressingFlag = flag;
    }
}
