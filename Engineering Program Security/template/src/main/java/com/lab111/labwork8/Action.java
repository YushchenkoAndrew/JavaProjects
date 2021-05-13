package main.java.com.lab111.labwork8;

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
    MementoShape[] mementos = new MementoShape[500];
    Color color = new Color(0, 0, 0);
    boolean fillShapeInColor = false;
    boolean movingFlag = false;
    MementoShape copyMemento;
    private boolean flagCopy = false;

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
                fillShapeInColor = false;
                flagCopy = false;
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
                fillShapeInColor = false;
                flagCopy = false;
                break;
            }
            case 2: {       //buttons's event is draw Line
                shapes.add(factory.getFlyweight("Line", draw));
                movingFlag = false;
                fillShapeInColor = false;
                flagCopy = false;
                break;
            }
            case 3: {       //buttons's event is draw Oval
                shapes.add(factory.getFlyweight("Oval", draw));
                movingFlag = false;
                fillShapeInColor = false;
                flagCopy = false;
                break;
            }
            case 4: {       //buttons's event is draw Rectangle
                shapes.add(factory.getFlyweight("Rectangle", draw));
                movingFlag = false;
                fillShapeInColor = false;
                flagCopy = false;
                break;
            }
            case 5: {       //buttons's event is draw Triangle
                shapes.add(factory.getFlyweight("Triangle", draw));
                movingFlag = false;
                fillShapeInColor = false;
                flagCopy = false;
                break;
            }
            case 6: {       //buttons's event select shape
//                draw.setCheckPressingFlag();
                movingFlag = true;
                fillShapeInColor = false;
                flagCopy = false;
                break;
            }
            case 7: {       //buttons's event paint shape in color
                fillShapeInColor = true;
                movingFlag = false;
                flagCopy = false;
                break;
            }
            case 8: {       //buttons's event past element
                movingFlag = true;
                fillShapeInColor = false;
                this.clickShapeIndex = flagCopy ? clickShapeIndex : -1;
                flagCopy = false;
                if (this.clickShapeIndex != -1)
                    pastCopiedShape();
                break;
            }
            case 9: {       //buttons's event copy element
                if (this.clickShapeIndex != -1)
                    copyMemento = (MementoShape) mementos[this.clickShapeIndex].copy();
                movingFlag = false;
                flagCopy = true;
                fillShapeInColor = false;
                break;
            }
            case 50: {
                shapeSize(Double.parseDouble(gui.textFields[1].getText()));
                fillShapeInColor = false;
                flagCopy = false;
                break;
            }
            default: {
                color = gui.buttons[index].getColor();
                movingFlag = false;
                flagCopy = false;
                break;
            }
        }

        resetSomeValues();
    }

    private void resetSomeValues() {
        if (gui.indexButton == 53)
            Filler.removeDynamicElements(gui);
    }

    int clickShapeIndex;

    @Override
    public void mouseClicked() {
        clickShapeIndex = getIndexOfMousePressedElement();
        resetSomeValues();
        if (fillShapeInColor) {
            fillShapeInColor(getIndexOfMousePressedElement(), color);
        }
        else {
            index = getIndexOfMousePressedElement();
            if (index != -1 && gui.indexButton != 53)
                    Filler.addDynamicElements(gui, mementos[index].getSize());
        }

        if (getIndexOfMousePressedElement() == -1) {
            movingFlag = false;
            fillShapeInColor = false;
        }
    }

    int mementoIndex = 0;

    private int x, y;       //start Coordinate
    private int index;
    Timer timer;


    @Override
    public void mousePressed() {
        resetSomeValues();

        x = MouseInfo.getPointerInfo().getLocation().x - gui.jFrame.getX() - 12;
        y = MouseInfo.getPointerInfo().getLocation().y - gui.jFrame.getY() - gui.arrayPanel[1].getBounds().y - 47;

        if (!movingFlag && !flagCopy) {
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
                takeModuleOfShape(index);

                movingFlag = true;
                shiftMemento(index);
                draw.setMementos(mementos);
            }
            x = MouseInfo.getPointerInfo().getLocation().x;
            y = MouseInfo.getPointerInfo().getLocation().y;
        }
        timer.start();
    }

    private void takeModuleOfShape(int index) {
        try {
            pressButton(draw.shiftShape(index));
        } catch (Exception e) {
            ErrorState.ErrorPopUp("Something broke!! NOOO, WHYY!");
        }
    }

    private void shiftMemento(int index) {
        MementoShape save = mementos[index];

        for (int i = index; i < mementoIndex - 1; i++) {
            mementos[i] = mementos[i + 1];
        }

        mementos[mementoIndex - 1] = save;
    }


    @Override
    public void mouseReleased() {
        if (timer != null)
            timer.stop();
        draw.setFlag(fillShapeInColor || flagCopy);
        if (mementos[mementoIndex] != null && !movingFlag && !fillShapeInColor && gui.indexButton != 53) {
            mementos[mementoIndex++].setRectangle(new Rectangle(x, y, MouseInfo.getPointerInfo().getLocation().x - x - gui.jFrame.getX() - 12, MouseInfo.getPointerInfo().getLocation().y - y - gui.jFrame.getY() - gui.arrayPanel[1].getBounds().y - 47));
        }
    }

    public void mousePressedMove() {
        if (shapes.size() > 0)
            shapes.get(shapes.size() - 1).draw(new Rectangle(x, y, MouseInfo.getPointerInfo().getLocation().x - x - gui.jFrame.getX() - 12, MouseInfo.getPointerInfo().getLocation().y - y - gui.jFrame.getY() - gui.arrayPanel[1].getBounds().y - 47), 0);

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

    private Matrix matrix = new Matrix();

    private void mouseMoveElements() {
        if (shapes.size() > 0 && index != -1) {
            double[][] displacementMatrix = new double[][]{{1, 0, 0}, {0, 1, 0}, {MouseInfo.getPointerInfo().getLocation().x - x, MouseInfo.getPointerInfo().getLocation().y - y, 1}};
            double[][] newPlacement = matrix.multiplication(new double[][]{{mementos[mementoIndex - 1].getRectangle().x, mementos[mementoIndex - 1].getRectangle().y, 1}}, displacementMatrix);

            mementos[mementoIndex - 1].setRectangle(new Rectangle((int)newPlacement[0][0], (int)newPlacement[0][1], mementos[mementoIndex - 1].getRectangle().width, mementos[mementoIndex - 1].getRectangle().height));

            shapes.get(shapes.size() - 1).draw(new Rectangle(mementos[mementoIndex - 1].getRectangle().x, mementos[mementoIndex - 1].getRectangle().y, mementos[mementoIndex - 1].getRectangle().width, mementos[mementoIndex - 1].getRectangle().height), 0);

        }

        x = MouseInfo.getPointerInfo().getLocation().x;
        y = MouseInfo.getPointerInfo().getLocation().y;

        draw.revalidate();
        draw.repaint();
        gui.arrayPanel[1].repaintPanel();
        draw.setFlag(!flagCopy);
    }

    private void fillShapeInColor(int index, Color color) {
        if (shapes.size() > 0 && index != -1) {
            takeModuleOfShape(index);
            fillShapeInColor = true;

            shiftMemento(index);
            draw.setMementos(mementos);

            mementos[mementoIndex - 1].setColor(color);
            mementos[mementoIndex - 1].setColorFill(color);

            shapes.get(shapes.size() - 1).draw(new Rectangle(mementos[mementoIndex - 1].getRectangle().x, mementos[mementoIndex - 1].getRectangle().y, mementos[mementoIndex - 1].getRectangle().width, mementos[mementoIndex - 1].getRectangle().height), 0);

        }

        draw.revalidate();
        draw.repaint();
        gui.arrayPanel[1].repaintPanel();
        draw.setFlag(false);
    }

    private void shapeSize(double size) {
        takeModuleOfShape(index);

        shiftMemento(index);
        draw.setMementos(mementos);
        double[][] sizeMatrix = new double[][]{{size, 0}, {0, size}};
        double[][] newPlacement = matrix.multiplication(new double[][]{{mementos[mementoIndex - 1].getRectangle().width, mementos[mementoIndex - 1].getRectangle().height}}, sizeMatrix);

        mementos[mementoIndex - 1].setSize(size);
        mementos[mementoIndex - 1].setRectangle(new Rectangle(mementos[mementoIndex - 1].getRectangle().x, mementos[mementoIndex - 1].getRectangle().y, (int)newPlacement[0][0], (int)newPlacement[0][1]));

        shapes.get(shapes.size() - 1).draw(new Rectangle(mementos[mementoIndex - 1].getRectangle().x, mementos[mementoIndex - 1].getRectangle().y, mementos[mementoIndex - 1].getRectangle().width, mementos[mementoIndex - 1].getRectangle().height), 0);

        draw.revalidate();
        draw.repaint();
        gui.arrayPanel[1].repaintPanel();
//        flagCopy = true;
        draw.setFlag(false);
    }

    //todo need to finish rotation method. JUST FINISH IT!!!

    private void rotateShape(double degree) {
        takeModuleOfShape(index);

        shiftMemento(index);
        draw.setMementos(mementos);

        mementos[mementoIndex - 1].setDegree(mementos[mementoIndex - 1].getDegree() + degree);

        shapes.get(shapes.size() - 1).draw(mementos[mementoIndex - 1].getRectangle(), mementos[mementoIndex - 1].getDegree());

        mementos = draw.getMementos();

        draw.revalidate();
        draw.repaint();
        gui.arrayPanel[1].repaintPanel();
        flagCopy = true;
        draw.setFlag(false);
    }


    private void pastCopiedShape() {
        takeModuleOfShape(index);

        mementos[mementoIndex - 1] = copyMemento;
        draw.setMementos(mementos);

        shapes.get(shapes.size() - 1).draw(copyMemento.rectangle, copyMemento.degree);

        draw.revalidate();
        draw.repaint();
        gui.arrayPanel[1].repaintPanel();
//        fillShapeInColor = true;
        draw.setFlag(false);
    }
}
