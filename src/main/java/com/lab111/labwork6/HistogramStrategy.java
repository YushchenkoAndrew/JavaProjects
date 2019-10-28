package main.java.com.lab111.labwork6;

import article.RainbowColors;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class HistogramStrategy extends JPanel implements Strategy {
    float[] data;
    float max;
    RainbowColors colors;

    public HistogramStrategy(float[] data, float max) {
        this.data = data;
        this.max = max;
    }


    @Override
    public void drawDiagram(Graphics2D g) {
        g.drawLine(70, 10, 70, 250);
        g.drawLine(70, 250, 470, 250);
        for (int i = 0; i < data.length; i++) {
            g.setColor(colors.getColor());
            g.fill(new Rectangle2D.Float(70 + 400 / data.length * i,250 - (int)(data[i] * 200 / max), 400 / data.length, (int)(data[i] * 200 / max)));
            g.setColor(Color.BLACK);
            g.drawString(Integer.toString(i + 1), 70 + 400 / data.length / 2 + 400 / data.length * (i), 270);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        colors = new RainbowColors();
        drawDiagram((Graphics2D) g);
    }
}
