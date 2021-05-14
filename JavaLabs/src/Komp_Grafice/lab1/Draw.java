package Komp_Grafice.lab1;


import Komp_Grafice.lab1.Design;
import Komp_Grafice.lab1.Filler;
import Komp_Grafice.lab1.Polygon;
import Komp_Grafice.lab1.TrickEffects;

import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel {



    public void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D)g;

        Polygon polygon = new Polygon(250, 230, 180);
        graphics2D.draw(polygon.getPolygon());


        Design design = new Design(polygon, 20);
        for (int i = 0; i < design.getDesign().length; i++) {
            graphics2D.draw(design.getPolygon(i));
        }

        TrickEffects trickEffects = new TrickEffects(design, graphics2D);
    }
}
