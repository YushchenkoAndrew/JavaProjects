package Komp_Grafice.lab7;

import article.CorrectionPrint;
import article.MathPackage.Matrix;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public class Draw extends JComponent {
    double[][][] coordinate;
    private double k;
    private double[] degree = new double[]{0, 0, 0};
    private double[][][] d = new double[9][][];
    int[] store = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    private boolean[] flag = new boolean[9];
    private List<Shape> shapes = new ArrayList<>();
    private double[] lightIntensity = new double[20];
    private Matrix matrix = new Matrix();
    private double[][] lightCoordinate = new double[][]{{220, 210, 0}};
    private List<Integer> brightnessOfPlot = new ArrayList<>();
    private double intensity = 1;

    public Draw() {
        for (int i = 0; i < 9; i++)
            d[i] = new double[][]{{-1}, {-1}, {-1}};
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;
        if (shapes.size() > 0) {
            graphics2D.setColor(new Color(247, 220, 111));
            graphics2D.fill(shapes.get(0));
        }
        for(int i = 1; i < shapes.size(); i++) {
            graphics2D.setColor(new Color(brightnessOfPlot.get(i) > 250 ? 250 : brightnessOfPlot.get(i), brightnessOfPlot.get(i) > 250 ? 250 : brightnessOfPlot.get(i), brightnessOfPlot.get(i) > 250 ? 250 : brightnessOfPlot.get(i)));
            graphics2D.fill(shapes.get(i));
//            graphics2D.draw(shapes.get(i));
        }
    }

    public void setCoordinate(double x, double y, double z, double k) {
        coordinate = new double[][][]{{{1, 1, 1}}, {{x, y, 1}}, {{-x, y, 1}}, {{1.0001, 1, z}}, {{x, y, z}}, {{-x, y, z}}, {{0, 3 * y, z / 2}}};
        this.k = k;


    }

    public void builtShape() {
        double[][] shiftA = new double[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {k, k, k, 1}};
        double[][] shiftB = new double[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {220, 210, 0, 1}};

        for (int i = 0; i < coordinate.length; i++) {
            coordinate[i] = new double[][]{{coordinate[i][0][0], coordinate[i][0][1], coordinate[i][0][2], 1}};
            coordinate[i] = matrix.multiplication(coordinate[i], shiftA);
            coordinate[i] = new double[][]{{coordinate[i][0][0], coordinate[i][0][1], coordinate[i][0][2]}};
            coordinate[i] = matrix.multiplication(coordinate[i], matrix.rotationMatrixOX(degree[0]));
            coordinate[i] = matrix.multiplication(coordinate[i], matrix.rotationMatrixOY(degree[1]));
            coordinate[i] = matrix.multiplication(coordinate[i], matrix.rotationMatrixOZ(degree[2]));
        }

        double[][] pointInside = new double[1][3];

        for (int i = 0; i < coordinate.length; i++)
            pointInside[0] = new double[]{pointInside[0][0] + coordinate[i][0][0], pointInside[0][1] + coordinate[i][0][1], pointInside[0][2] + coordinate[i][0][2], coordinate.length};

        pointInside = matrix.multiplication(pointInside, 1.0 / (coordinate.length));

        double[][][] plots = new double[][][]{
                matrix.multiplication(matrix.getArguments(new double[][]{coordinate[0][0], coordinate[1][0], coordinate[2][0]}, d[0].clone()), store[0]),
                matrix.multiplication(matrix.getArguments(new double[][]{coordinate[3][0], coordinate[4][0], coordinate[5][0]}, d[0].clone()), store[1]),
                matrix.multiplication(matrix.getArguments(new double[][]{coordinate[0][0], coordinate[1][0], coordinate[3][0]}, d[0].clone()), store[2]),
                matrix.multiplication(matrix.getArguments(new double[][]{coordinate[0][0], coordinate[2][0], coordinate[3][0]}, d[0].clone()), store[3]),

                matrix.multiplication(matrix.getArguments(new double[][]{coordinate[2][0], coordinate[1][0], coordinate[6][0]}, d[0].clone()), store[4]),
                matrix.multiplication(matrix.getArguments(new double[][]{coordinate[4][0], coordinate[5][0], coordinate[6][0]}, d[0].clone()), store[5]),
                matrix.multiplication(matrix.getArguments(new double[][]{coordinate[2][0], coordinate[5][0], coordinate[6][0]}, d[0].clone()), store[6]),
                matrix.multiplication(matrix.getArguments(new double[][]{coordinate[4][0], coordinate[1][0], coordinate[6][0]}, d[0].clone()), store[7])};

        double[] result = new double[plots.length];
        for (int i = 0; i < plots.length; i++) {
            result[i] = matrix.multiplication(pointInside, new double[][]{{plots[i][0][0]}, {plots[i][1][0]}, {plots[i][2][0]}, {1}})[0][0];
        }

        for (int i = 0; i < plots.length; i++)
            plots[i] = matrix.multiplication(plots[i], result[i] >= 0 ? 1 : -1);

        double[][] point = new double[][]{{0, 100, 700000}};

        point = new double[][]{{point[0][0], point[0][1], point[0][2], 1}};
        point = matrix.multiplication(point, shiftB);

        for (int i = 0; i < plots.length; i++) {
            result[i] = matrix.multiplication(point, new double[][]{{plots[i][0][0]}, {plots[i][1][0]}, {plots[i][2][0]}, {1}})[0][0];
        }

        for (int i = 0; i < coordinate.length; i++) {
            coordinate[i] = new double[][]{{coordinate[i][0][0], coordinate[i][0][1], coordinate[i][0][2], 1}};
            coordinate[i] = matrix.multiplication(coordinate[i], shiftB);
        }
        borderBrightness();

        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[0] >= 0)
                drawPlot1();

            if (i == 1 && result[1] >= 0)
                drawPlot2();

            if (i == 2 && result[2] >= 0)
                drawPlot3();

            if (i == 3 && result[3] >= 0)
                drawPlot4();

            if (i == 4 && result[4] >= 0)
                drawPlot5();

            if (i == 5 && result[5] >= 0)
                drawPlot6();

            if (i == 6 && result[6] >= 0)
                drawPlot7();

            if (i == 7 && result[7] >= 0)
                drawPlot8();
        }

    }

    private void borderBrightness() {
        for (int i = 0; i < coordinate.length; i++) {
            double[][] temporalDistance = new double[][]{{coordinate[i][0][0] - lightCoordinate[0][0], coordinate[i][0][1] - lightCoordinate[0][1], coordinate[i][0][2] - lightCoordinate[0][2]}};
            double distance = matrix.multiplication(temporalDistance, matrix.transposition(temporalDistance))[0][0];
            lightIntensity[i] = lightIntensity[i] + intensity * 30000 / (distance + 50) * Math.cos(Math.sqrt(distance * distance - temporalDistance[0][1] * temporalDistance[0][1]) / distance);
        }
    }

    private double bright(double[][] coordinate, double[] I) {
        double[] t = new double[]{
                Math.abs(coordinate[0][0] - coordinate[1][0]) / (Math.abs(coordinate[2][0] - coordinate[1][0]) == 0 ? -1 : Math.abs(coordinate[2][0] - coordinate[1][0])),
                Math.abs(coordinate[0][1] - coordinate[1][1]) / (Math.abs(coordinate[2][1] - coordinate[1][1]) == 0 ? -1 : Math.abs(coordinate[2][1] - coordinate[1][1])),
                Math.abs(coordinate[0][2] - coordinate[1][2]) / (Math.abs(coordinate[2][2] - coordinate[1][2]) == 0 ? -1 : Math.abs(coordinate[2][2] - coordinate[1][2]))};
        double intensity = 0;
        for (int i = 0; i < 3; i++)
            if (t[i] >= 0)
            intensity += (1 - t[i]) * I[0] + t[i] * I[1];
        return intensity / 3;
    }

    private int plotBrightness(int a, int b, int c) {
        double intensity = bright(new double[][]{coordinate[a][0], new double[]{
                (coordinate[a][0][0] + coordinate[b][0][0]) / 2,
                (coordinate[a][0][1] + coordinate[b][0][1]) / 2,
                (coordinate[a][0][2] + coordinate[b][0][2]) / 2}, coordinate[b][0]}, new double[]{lightIntensity[a], lightIntensity[b]});

        intensity += bright(new double[][]{coordinate[c][0], new double[]{
                (coordinate[c][0][0] + coordinate[b][0][0]) / 2,
                (coordinate[c][0][1] + coordinate[b][0][1]) / 2,
                (coordinate[c][0][2] + coordinate[b][0][2]) / 2}, coordinate[b][0]}, new double[]{lightIntensity[c], lightIntensity[b]});

        intensity += bright(new double[][]{coordinate[a][0], new double[]{
                (coordinate[a][0][0] + coordinate[c][0][0]) / 2,
                (coordinate[a][0][1] + coordinate[c][0][1]) / 2,
                (coordinate[a][0][2] + coordinate[c][0][2]) / 2}, coordinate[c][0]}, new double[]{lightIntensity[a], lightIntensity[c]});
        return (int)(intensity / 3);
    }

    private void splitTriangle(double[][] coordinate) {
        int n = 2;
        double height = (coordinate[0][1] - coordinate[1][1]) / n;
        double kLine1 = (coordinate[0][1] - coordinate[1][1]) / (coordinate[0][0] - coordinate[1][0]);
        double kLine2 = (coordinate[0][1] - coordinate[2][1]) / (coordinate[0][0] - coordinate[2][0]);
        double width = (coordinate[0][1] - height) / kLine2 - coordinate[0][1] + kLine2 * coordinate[0][0] - (coordinate[0][1] - height) / kLine1 + coordinate[0][1] - kLine1 * coordinate[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n + 1; j++) {
                Polygon polygon = new Polygon();
                polygon.addPoint((int)(coordinate[0][0] - width * i), (int)(coordinate[0][1] - height * i));
                polygon.addPoint((int)(coordinate[0][0] + j / 3 * width / 2), (int)(coordinate[2][1] - height * (i + 1)));
                polygon.addPoint((int)(coordinate[1][0] + j / 3 * width), (int)(coordinate[1][1] - height * (i + 1)));
            }
        }
    }

    private void drawPlot1() {
        Polygon polygon = new Polygon();
        polygon.addPoint((int)coordinate[0][0][0], (int)coordinate[0][0][1]);
        polygon.addPoint((int)coordinate[1][0][0], (int)coordinate[1][0][1]);
        polygon.addPoint((int)coordinate[2][0][0], (int)coordinate[2][0][1]);
        shapes.add(polygon);

        brightnessOfPlot.add(plotBrightness(0, 1, 2));
    }
    private void drawPlot2() {
        Polygon polygon = new Polygon();
        polygon.addPoint((int)coordinate[3][0][0], (int)coordinate[3][0][1]);
        polygon.addPoint((int)coordinate[5][0][0], (int)coordinate[5][0][1]);
        polygon.addPoint((int)coordinate[4][0][0], (int)coordinate[4][0][1]);
        shapes.add(polygon);

        brightnessOfPlot.add(plotBrightness(3, 4, 5));
    }
    private void drawPlot3() {
        Polygon polygon = new Polygon();
        polygon.addPoint((int)coordinate[0][0][0], (int)coordinate[0][0][1]);
        polygon.addPoint((int)coordinate[1][0][0], (int)coordinate[1][0][1]);
        polygon.addPoint((int)coordinate[4][0][0], (int)coordinate[4][0][1]);
        polygon.addPoint((int)coordinate[3][0][0], (int)coordinate[3][0][1]);
        shapes.add(polygon);

        brightnessOfPlot.add(plotBrightness(0, 3, 4));
    }
    private void drawPlot4() {
        Polygon polygon = new Polygon();
        polygon.addPoint((int)coordinate[0][0][0], (int)coordinate[0][0][1]);
        polygon.addPoint((int)coordinate[2][0][0], (int)coordinate[2][0][1]);
        polygon.addPoint((int)coordinate[5][0][0], (int)coordinate[5][0][1]);
        polygon.addPoint((int)coordinate[3][0][0], (int)coordinate[3][0][1]);
        shapes.add(polygon);

        brightnessOfPlot.add(plotBrightness(0, 5, 2));
    }
    private void drawPlot5() {
        Polygon polygon = new Polygon();
        polygon.addPoint((int)coordinate[2][0][0], (int)coordinate[2][0][1]);
        polygon.addPoint((int)coordinate[1][0][0], (int)coordinate[1][0][1]);
        polygon.addPoint((int)coordinate[6][0][0], (int)coordinate[6][0][1]);
        shapes.add(polygon);

        brightnessOfPlot.add(plotBrightness(2, 1, 6));
    }
    private void drawPlot6() {
        Polygon polygon = new Polygon();
        polygon.addPoint((int)coordinate[4][0][0], (int)coordinate[4][0][1]);
        polygon.addPoint((int)coordinate[5][0][0], (int)coordinate[5][0][1]);
        polygon.addPoint((int)coordinate[6][0][0], (int)coordinate[6][0][1]);
        shapes.add(polygon);

        brightnessOfPlot.add(plotBrightness(4, 5, 6));
    }
    private void drawPlot7() {
        Polygon polygon = new Polygon();
        polygon.addPoint((int)coordinate[2][0][0], (int)coordinate[2][0][1]);
        polygon.addPoint((int)coordinate[5][0][0], (int)coordinate[5][0][1]);
        polygon.addPoint((int)coordinate[6][0][0], (int)coordinate[6][0][1]);
        shapes.add(polygon);

        brightnessOfPlot.add(plotBrightness(2, 5, 6));
    }
    private void drawPlot8() {
        Polygon polygon = new Polygon();
        polygon.addPoint((int)coordinate[4][0][0], (int)coordinate[4][0][1]);
        polygon.addPoint((int)coordinate[1][0][0], (int)coordinate[1][0][1]);
        polygon.addPoint((int)coordinate[6][0][0], (int)coordinate[6][0][1]);
        shapes.add(polygon);

        brightnessOfPlot.add(plotBrightness(4, 1, 6));
    }

    public void eraseShapes() {
        while (!shapes.isEmpty()) {
            shapes.remove(0);
            brightnessOfPlot.remove(0);
        }
        shapes.add(new Ellipse2D.Double(lightCoordinate[0][0] - 10, lightCoordinate[0][1] - 10, 20, 20));
        brightnessOfPlot.add(175);
        lightIntensity = new double[20];
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

    public double[][] getLightCoordinate() {
        return lightCoordinate;
    }

    public void setLightCoordinate(double[][] lightCoordinate) {
        this.lightCoordinate = lightCoordinate;
    }

    public double getIntensity() {
        return intensity;
    }

    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }
}
