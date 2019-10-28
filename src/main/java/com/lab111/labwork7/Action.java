package main.java.com.lab111.labwork7;

import article.ErrorState;
import article.GUI.GUI;
import article.MathPackage.Matrix;

import javax.swing.*;
import java.awt.Rectangle;
import java.awt.*;
import java.util.ArrayList;

public class Action extends article.ActionEvent.ActionEvent {
    Draw draw;
    java.util.List<Flyweight> shapes = new ArrayList<>();
    FlyweightFactory factory = new FlyweightFactory();
    Memento[] mementos = new Memento[500];
    Color color = new Color(0, 0, 0);
    boolean movingFlag = false;

    public void connection(Draw draw){
        this.draw = draw;
    }

    public void setGUI(GUI gui) {
        super.setGUI(gui);

    }
    @Override
    public void pressButton(int index) throws Exception {
        switch (index) {
            case 0: {       //buttons's event is draw Pixel
//                shapes.add(factory.getFlyweight("Pixel", draw));
                ErrorState.ErrorPopUp("This shape under arrest please don't touch it");
                movingFlag = false;
                break;
            }
            case 1: {       //buttons's event is Erase

                System.out.println("Erase");
                movingFlag = false;
                mementoIndex = 0;
                draw.removeAll();
                draw.revalidate();
                draw.repaint();
                gui.jFrame.repaint();
                break;
            }
            case 2: {       //buttons's event is draw Line
                shapes.add(factory.getFlyweight("Line", draw));
                movingFlag = false;
                break;
            }
            case 3: {       //buttons's event is draw Oval
                shapes.add(factory.getFlyweight("Oval", draw));
                movingFlag = false;
                break;
            }
            case 4: {       //buttons's event is draw Rectangle
                shapes.add(factory.getFlyweight("Rectangle", draw));
                movingFlag = false;
                break;
            }
            case 5: {       //buttons's event is draw Triangle
                shapes.add(factory.getFlyweight("Triangle", draw));
                movingFlag = false;
                break;
            }
            case 6: {       //buttons's event select shape
//                draw.setCheckPressingFlag();
                movingFlag = true;
                break;
            }
            default: {
                color = gui.buttons[index].getColor();
                movingFlag = false;
                break;
            }
        }
    }


    int mementoIndex = 0;

    private int x, y;       //start Coordinate
    private int index;
    Timer timer;


    @Override
    public void mousePressed() {
        x = MouseInfo.getPointerInfo().getLocation().x - gui.jFrame.getX() - 12;
        y = MouseInfo.getPointerInfo().getLocation().y - gui.jFrame.getY() - gui.arrayPanel[1].getBounds().y - 47;

        if (!movingFlag) {
            timer = new Timer(1, e -> mousePressedMove());

            mementos[mementoIndex] = shapes.get(shapes.size() - 1).getMemento();
            if (mementos[mementoIndex] != null)
                mementos[mementoIndex].setColor(color);
            draw.setMementos(mementos);

        }
        else {
            timer = new Timer(20, e -> mouseMoveElements());
            index = getIndexOfMousePressedElement();

            if (index != -1) {
                try {
                    pressButton(draw.shiftShape(index));
                    movingFlag = true;
                } catch (Exception e) {
                    ErrorState.ErrorPopUp("Something broke!! NOOO, WHYY!");
                }
                shiftMemento(index);
                draw.setMementos(mementos);
            }
            x = MouseInfo.getPointerInfo().getLocation().x;
            y = MouseInfo.getPointerInfo().getLocation().y;
        }
        timer.start();
    }

    private void shiftMemento(int index) {
        Memento save = mementos[index];

        for (int i = index; i < mementoIndex - 1; i++) {
            mementos[i] = mementos[i + 1];
        }

        mementos[mementoIndex - 1] = save;
    }


    @Override
    public void mouseReleased() {
        if (timer != null)
            timer.stop();
        draw.setFlag(false);
        if (mementos[mementoIndex] != null && !movingFlag ) {
            mementos[mementoIndex++].setRectangle(new Rectangle(x, y, MouseInfo.getPointerInfo().getLocation().x - x - gui.jFrame.getX() - 12, MouseInfo.getPointerInfo().getLocation().y - y - gui.jFrame.getY() - gui.arrayPanel[1].getBounds().y - 47));
        }
    }

    public void mousePressedMove() {
        if (shapes.size() > 0)
            shapes.get(shapes.size() - 1).draw(new Rectangle(x, y, MouseInfo.getPointerInfo().getLocation().x - x - gui.jFrame.getX() - 12, MouseInfo.getPointerInfo().getLocation().y - y - gui.jFrame.getY() - gui.arrayPanel[1].getBounds().y - 47));

        draw.revalidate();
        draw.repaint();

        gui.arrayPanel[1].repaintPanel();
    }

    private int getIndexOfMousePressedElement() {
        for (int i = 0; i < mementoIndex; i++)
        if (x > (mementos[i].getRectangle().x - Math.abs(mementos[i].getRectangle().width)) && x < (mementos[i].getRectangle().x + Math.abs(mementos[i].getRectangle().width)) && y > (mementos[i].getRectangle().y - Math.abs(mementos[i].getRectangle().height)) && y < (mementos[i].getRectangle().y + Math.abs(mementos[i].getRectangle().height)))
                return i;
        return -1;
    }

    Matrix matrix = new Matrix();

    private void mouseMoveElements() {
        if (shapes.size() > 0 && index != -1) {
            double[][] displacementMatrix = new double[][]{{1, 0, 0}, {0, 1, 0}, {MouseInfo.getPointerInfo().getLocation().x - x, MouseInfo.getPointerInfo().getLocation().y - y, 1}};
            double[][] newPlacement = matrix.multiplication(new double[][]{{mementos[mementoIndex - 1].getRectangle().x, mementos[mementoIndex - 1].getRectangle().y, 1}}, displacementMatrix);

            mementos[mementoIndex - 1].setRectangle(new Rectangle((int)newPlacement[0][0], (int)newPlacement[0][1], mementos[mementoIndex - 1].getRectangle().width, mementos[mementoIndex - 1].getRectangle().height));

            shapes.get(shapes.size() - 1).draw(new Rectangle(mementos[mementoIndex - 1].getRectangle().x, mementos[mementoIndex - 1].getRectangle().y, mementos[mementoIndex - 1].getRectangle().width, mementos[mementoIndex - 1].getRectangle().height));

        }

        x = MouseInfo.getPointerInfo().getLocation().x;
        y = MouseInfo.getPointerInfo().getLocation().y;

        draw.revalidate();
        draw.repaint();
        gui.arrayPanel[1].repaintPanel();
    }

}
