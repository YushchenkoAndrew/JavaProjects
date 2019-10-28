package main.java.com.lab111.labwork4;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Action extends article.ActionEvent.ActionEvent {
    Draw draw;
    java.util.List<Flyweight> shapes = new ArrayList<>();
    FlyweightFactory factory = new FlyweightFactory();


    public void connection(Draw draw){
        this.draw = draw;
        draw.setjFrame(gui.jFrame);
    }

    @Override
    public void pressButton(int index) throws Exception {
        switch (index) {
            case 0: {       //buttons's event is draw Pixel
                    shapes.add(factory.getFlyweight("Pixel", draw));
                break;
            }
            case 1: {       //buttons's event is Erase

                System.out.println("Erase");
                draw.removeAll();
                draw.revalidate();
                draw.repaint();
                gui.jFrame.repaint();
                break;
            }
            case 2: {       //buttons's event is draw Line
                shapes.add(factory.getFlyweight("Line", draw));
                break;
            }
            case 3: {       //buttons's event is draw Oval
                shapes.add(factory.getFlyweight("Oval", draw));
                break;
            }
            case 4: {       //buttons's event is draw Rectangle
                shapes.add(factory.getFlyweight("Rectangle", draw));
                break;
            }
            case 5: {       //buttons's event is draw Triangle
                shapes.add(factory.getFlyweight("Triangle", draw));
                break;
            }
            case 6: {       //buttons's event is draw Triangle
                draw.setCheckPressingFlag();
                break;
            }
        }
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
        draw.setFlag(false);

    }

    public void mousePressedMove() {
        System.out.println(MouseInfo.getPointerInfo().getLocation().x - 205 + " - X");
        System.out.println(MouseInfo.getPointerInfo().getLocation().y - 80 + " - Y");
        if (shapes.size() > 0)
            shapes.get(shapes.size() - 1).draw(new Rectangle(x, y, MouseInfo.getPointerInfo().getLocation().x - 205 - x, MouseInfo.getPointerInfo().getLocation().y - 80 - y));

        draw.revalidate();
        draw.repaint();

        gui.jFrame.repaint();
    }

}
