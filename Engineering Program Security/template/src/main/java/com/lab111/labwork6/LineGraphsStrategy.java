package main.java.com.lab111.labwork6;

import article.RainbowColors;
import main.java.com.lab111.labwork4.Oval;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class LineGraphsStrategy extends JPanel implements Strategy {
    float[] data;
    float max;
    RainbowColors colors;

    public LineGraphsStrategy(float[] data, float max) {
        this.data = data;
        this.max = max;
    }

    @Override
    public void drawDiagram(Graphics2D g) {
        g.drawLine(70, 10, 70, 250);
        g.drawLine(70, 250, 470, 250);
        int lastX = -1;
        int lastY = -1;
        for (int i = 0; i < data.length; i++) {
            g.setColor(colors.getColor());
            if (lastX != -1)
                g.draw(new Line2D.Float(75 + 400 / data.length * (2 * i + 1) / 2, 255 - (int)(data[i] * 200 / max), lastX, lastY));
            g.fill(new Ellipse2D.Float(70 + 400 / data.length * (2 * i + 1) / 2, 250 - (int)(data[i] * 200 / max), 10, 10));
            lastX = 75 + 400 / data.length * (2 * i + 1) / 2;
            lastY = 255 - (int)(data[i] * 200 / max);
            g.setColor(Color.BLACK);
            g.drawString(Integer.toString(i + 1), 70 + 400 / data.length * (2 * i + 1) / 2, 270);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        colors = new RainbowColors();
        drawDiagram((Graphics2D) g);
    }
}
