package Komp_Grafice.lab2;

import java.awt.*;

public class DrawingFigure {

    Graphics2D g;

    private float A_CONST;
    private float B_CONST;
    private float R_CONST;
    private float N_CONST;

    Polygon polygon = new Polygon();


    public DrawingFigure(Graphics2D graphics2D) {
        g = graphics2D;
    }

    public void drawFigure(float A_CONST, float B_CONST, float R_CONST, float N_CONST) {
        this.A_CONST = A_CONST;
        this.B_CONST = B_CONST;
        this.R_CONST = R_CONST;
        this.N_CONST = N_CONST;

        for (double t = 0; t < Math.PI * N_CONST; t += 0.001) {
            double x = 300 + A_CONST / B_CONST * R_CONST * Math.cos(t / B_CONST) + 1 / B_CONST * R_CONST * Math.cos(A_CONST * t / B_CONST);
            double y = 300 + A_CONST / B_CONST * R_CONST * Math.sin(t / B_CONST) - 1 / B_CONST * R_CONST * Math.sin(A_CONST * t / B_CONST);
            drawPixel(x, y);
        }
        g.draw(polygon);
    }

    private void drawPixel(double x, double y) {
        polygon.addPoint((int) x, (int) y);
    }

    public float getA_CONST() {
        return A_CONST;
    }

    public float getB_CONST() {
        return B_CONST;
    }

    public float getR_CONST() {
        return R_CONST;
    }

    public float getN_CONST() {
        return N_CONST;
    }

    public Polygon getPolygon() {
        return polygon;
    }
}
