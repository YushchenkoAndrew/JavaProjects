package Komp_Grafice.lab2;

import java.awt.*;

public class Design {

    Graphics2D g;
    DrawingFigure[] draw;
    int K_CONST;

    DrawingFigure drawingFigure;

    public Design(Graphics2D graphics2D) {
            g = graphics2D;
    }

    public void makeDesign(DrawingFigure drawingFigure, float K_CONST) {
        float A_CONST = drawingFigure.getA_CONST();
        float B_CONST = drawingFigure.getB_CONST();
        float R_CONST = drawingFigure.getR_CONST();
        float N_CONST = drawingFigure.getN_CONST();
        this.drawingFigure = drawingFigure;
        this.K_CONST = (int) K_CONST;

        System.out.println("designing");
        draw = new DrawingFigure[(int) K_CONST];

        int counter = -1;
        for (int i = (int) (R_CONST / K_CONST); i < R_CONST; i += (int) R_CONST / K_CONST) {
            draw[++counter] = new DrawingFigure(g);
            draw[counter].drawFigure(A_CONST, B_CONST, i, N_CONST);
        }
    }

    public int getK_CONST() {
        return K_CONST;
    }

    public DrawingFigure[] getDraw() {
        return draw;
    }

    public Polygon getDrawingFigure() {
        return drawingFigure.getPolygon();
    }
}
