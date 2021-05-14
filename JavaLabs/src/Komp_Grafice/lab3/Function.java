package Komp_Grafice.lab3;

import java.awt.*;

public class Function {
    Graphics2D g;
    Polygon[] polygon;

    public Function(Graphics2D g) {
        this.g = g;
        polygon = new Polygon[50];
    }

    public Polygon[] draw(int X_CONST, int Y_CONST, int H_CONST, int R_CONST, double degreeY, double degreeX, double distance) {
        for (int j = 0; j < H_CONST; j++) {
            polygon[j] = new Polygon();
            for (float i = 0; i < 2 * Math.PI; i += 0.001) {
                drawPoint(R_CONST * Math.cos(i) + X_CONST + 300 + (j + 1) * degreeX, R_CONST * Math.sin(i) * degreeY + Y_CONST + distance * j + j / 1.3 * degreeY * Math.sin(i) + 200, j);
            }
        }
        return polygon;
    }

    private void drawPoint(double x, double y, int j) {
        polygon[j].addPoint((int)x, (int)y);
    }


}
