package Komp_Grafice.lab6;

import article.CorrectionPrint;
import article.MathPackage.Matrix;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class Draw extends JComponent {
    double[][][] coordinate;
    private double k = 2000;
    private double[] degree = new double[]{0, 0, 0};
    List<Shape> shapes = new ArrayList<>();
    private Matrix matrix = new Matrix();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;
        for(Shape shape : shapes)
            graphics2D.draw(shape);
    }

    public void setCoordinate(int x, int y, int z) {
        coordinate = new double[][][]{{{0, 0, 0}}, {{-x, y, 0}}, {{x, y, 0}}, {{0, y / 2, z}}, {{0, y / 2, -z}}};
    }

    public void builtShape() {
        double[][] shift = new double[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {250, 200, 0, 1}};

        for (int i = 0; i < coordinate.length; i++) {
            coordinate[i] = matrix.multiplication(coordinate[i], matrix.rotationMatrixOX(degree[0]));
            coordinate[i] = matrix.multiplication(coordinate[i], matrix.rotationMatrixOY(degree[1]));
            coordinate[i] = matrix.multiplication(coordinate[i], matrix.rotationMatrixOZ(degree[2]));
            coordinate[i] = new double[][]{{coordinate[i][0][0], coordinate[i][0][1], coordinate[i][0][2], 1}};
            coordinate[i] = matrix.multiplication(coordinate[i], shift);
        }

        shapes.add(new Line2D.Double(coordinate[0][0][0], coordinate[0][0][1], coordinate[1][0][0], coordinate[1][0][1]));
        shapes.add(new Line2D.Double(coordinate[0][0][0], coordinate[0][0][1], coordinate[2][0][0], coordinate[2][0][1]));
        shapes.add(new Line2D.Double(coordinate[1][0][0], coordinate[1][0][1], coordinate[2][0][0], coordinate[2][0][1]));

        for (int i = 0; i < 3; i++) {
            shapes.add(new Line2D.Double(coordinate[3][0][0], coordinate[3][0][1], coordinate[i][0][0], coordinate[i][0][1]));
            shapes.add(new Line2D.Double(coordinate[4][0][0], coordinate[4][0][1], coordinate[i][0][0], coordinate[i][0][1]));
        }

    }

    public void eraseShapes() {
        while (!shapes.isEmpty())
            shapes.remove(0);
    }

    public void changeDegreeOX(double degree) {
        this.degree[0] += degree;
    }
    public void changeDegreeOY(double degree) {
        this.degree[1] += degree;
    }
    public void changeDegreeOZ(double degree) {
        this.degree[2] += degree;
    }
}
