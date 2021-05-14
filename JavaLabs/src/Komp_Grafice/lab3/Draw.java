package Komp_Grafice.lab3;

import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel {
    public int H_CONST;
    private int R_CONST;
    public int X_CONST;
    private int Y_CONST;
    private double degreeX = 0;
    private double degreeY = 0.25;
    private double distanceY = 10;
    private double distance_CONST = 10;
    Function function;

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D graphics2D = (Graphics2D)g;

        function = new Function(graphics2D);
        Polygon[] polygons = function.draw(X_CONST, Y_CONST,H_CONST, R_CONST, degreeY, degreeX, distanceY);
        for (int i = 0; i < H_CONST; i++)
            graphics2D.draw(polygons[i]);
    }

    public void setH_CONST(int h_CONST) {
        H_CONST = h_CONST;
    }

    public void setR_CONST(int r_CONST) {
        R_CONST = r_CONST;
    }

    public void setViewY(double degree, double step) {
        if (Math.abs(degree) <= 1) {
            this.degreeY = degree;
//            distanceY = 10;
            distanceY = distanceY < distance_CONST ? distanceY + 0.5 : distanceY;
        } else
            distanceY -= step;
    }

    public double getDegreeY() {
        return degreeY;
    }

    public void setDegreeY(double degreeY) {
        this.degreeY = degreeY;
    }

    public void setDistanceY(double distanceY) {
        this.distanceY = distanceY;
        distance_CONST = distanceY;
    }

    public double getDegreeX() {
        return degreeX;
    }

    public void setDegreeX(double degreeX) {
//        if (Math.abs(Math.cos(degreeX)) <= 0.8) {
            this.degreeX = degreeX;
//        }
    }

    public int getR_CONST() {
        return R_CONST;
    }

    public double getDistanceY() {
        return distanceY;
    }

    public void setX_CONST(int x_CONST) {
        X_CONST = x_CONST;
    }

    public void setY_CONST(int y_CONST) {
        Y_CONST = y_CONST;
    }
}
