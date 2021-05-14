package Komp_Grafice.lab5;

import java.awt.*;

public class DrawingFigure {
    Polygon polygon;

    public Polygon drawFigure(double A, double B) {
         polygon = new Polygon();
        for (double t = 0; t < Math.PI * B * 2; t += 0.001) {
            double[] store = getDotLocation(t, A, B);
            drawPixel(store[0], store[1]);
        }
        return polygon;
    }

    private void drawPixel(double x, double y) {
        polygon.addPoint((int) x, (int) y);
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public static double[] getDotLocation(double t, double A, double B) {
        double x = 200 + A / B * Math.cos(t / B) + 1 / B  * Math.cos(A * t / B);
        double y = 200 + A / B  * Math.sin(t / B) - 1 / B  * Math.sin(A * t / B);
        return new double[]{x, y};
    }
}
