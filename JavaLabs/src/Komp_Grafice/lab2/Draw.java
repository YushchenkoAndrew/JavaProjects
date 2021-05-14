package Komp_Grafice.lab2;


import Komp_Grafice.lab1.Filler;
import Komp_Grafice.lab1.Polygon;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Draw extends JPanel {
    private JFrame jFrame;

    private float A_CONST;
    private float B_CONST;
    private float R_CONST;
    private float N_CONST;
    private float K_CONST;
    int c = 0;      //c - counter

    DrawingFigure drawingFigure;
    Design design;
    Graphics2D graphics2D;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        System.out.println(K_CONST);


        graphics2D = (Graphics2D)g;

        drawingFigure = new DrawingFigure(graphics2D);
        drawingFigure.drawFigure(A_CONST, B_CONST, R_CONST, N_CONST);

        design = new Design(graphics2D);
        design.makeDesign(drawingFigure, K_CONST);

        TrickEffects effects = new TrickEffects(graphics2D);
        effects.make(design, c++);

        c = c >= effects.colorLength() ? 0 : c;

        revalidate();
        repaint();

        jFrame.repaint();
    }

    public void setA_CONST(float a_CONST) {
        A_CONST = a_CONST;
    }

    public void setB_CONST(float b_CONST) {
        B_CONST = b_CONST;
    }

    public void setR_CONST(float r_CONST) {
        R_CONST = r_CONST;
    }

    public void setN_CONST(float n_CONST) {
        N_CONST = n_CONST;
    }

    public void setK_CONST(float k_CONST) {
        K_CONST = k_CONST;
    }

    public void setjFrame(JFrame jFrame) {
        this.jFrame = jFrame;
    }
}