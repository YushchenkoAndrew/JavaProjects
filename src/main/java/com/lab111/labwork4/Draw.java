package main.java.com.lab111.labwork4;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Draw extends JPanel {

    JFrame jFrame = new JFrame();

    boolean flag = false;        //flag need to check buttons is pressed or not
    boolean checkPressingFlag = true;

    List<Shape> shapes = new ArrayList<>();

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D graphics2D = (Graphics2D) g;
        for (Shape s : shapes)
            graphics2D.draw(s);

    }


    public void repaint() {
        super.repaint();
        flag = true;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void drawPixel(int x, int y) {
        System.out.println("Draw Pixel!");
        shapes.add(new Line2D.Float(x, y, x, y));
    }

    public void drawLine(Rectangle rectangle) {
        System.out.println("Draw Line!");

        checkPressing();
        shapes.add(new Line2D.Float(rectangle.x, rectangle.y, rectangle.x + rectangle.width, rectangle.y + rectangle.height));
    }

    public void drawOval(Rectangle rectangle) {
        System.out.println("Draw Oval!");

        checkPressing();
        shapes.add(new Ellipse2D.Float(rectangle.x, rectangle.y, rectangle.width,rectangle.height));
    }

    public void drawRectangle(Rectangle rectangle) {
        System.out.println("Draw Rectangle!");

        checkPressing();
        shapes.add(new Rectangle2D.Float(rectangle.x, rectangle.y, rectangle.width,rectangle.height));
    }

    public void drawTriangle(Rectangle rectangle) {
        System.out.println("Draw Triangle!");
        Polygon polygon = new Polygon();
        polygon.addPoint(rectangle.x, rectangle.y);
        polygon.addPoint(rectangle.x, rectangle.y + rectangle.height);
        polygon.addPoint(rectangle.x + rectangle.width, rectangle.y + rectangle.height);

        checkPressing();
        shapes.add(polygon);
    }

    public void removeAll() {
        while (shapes.size() > 0)
            shapes.remove(0);
    }

    public void setjFrame(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    private void checkPressing() {
        if (flag && shapes.size() > 0 && checkPressingFlag)
            shapes.remove(shapes.size() - 1);
    }

    public void setCheckPressingFlag() {
        checkPressingFlag = !checkPressingFlag;
    }
}
