package main.java.com.lab111.labwork6;

import article.RainbowColors;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;

public class PieChartsStrategy extends JPanel implements Strategy {

    float[] data;
    float sum;
    RainbowColors colors;

    public PieChartsStrategy(float[] data, float sum) {
        this.data = data;
        this.sum = sum;
    }

    //    @Override
    public void drawDiagram(Graphics2D g) {
        float degree = 0;
        for (int i = 0; i < data.length; i++) {
            g.setPaint(colors.getColor());
            g.fill(new Arc2D.Double(150, 10, 250, 250, degree,  data[i] / sum * 360, Arc2D.PIE));
            g.fill(new Rectangle2D.Float(410, 10 + i * 25, 30, 20));
            g.setColor(Color.BLACK);
            g.drawString(" - " + (i + 1), 445, 22 + i * 25);
            degree += data[i] / sum * 360;
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        colors = new RainbowColors();
        drawDiagram((Graphics2D) g);
    }
}
