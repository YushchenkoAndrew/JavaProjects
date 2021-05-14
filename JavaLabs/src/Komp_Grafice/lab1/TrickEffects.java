package Komp_Grafice.lab1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrickEffects {
    Design design;
    Graphics2D g2d;

    public TrickEffects(Design design, Graphics2D g2d) {
        this.design = design;
        this.g2d = g2d;
        paint();
    }

    private void paint() {
        int counterColor = 0;
        for (int  i = 0; i < design.getNum(); i++){
            g2d.setColor(new Color(counterColor, counterColor, counterColor));
            g2d.fill(design.getDesign()[i].getPolygon());
            counterColor += 255 / design.getNum();
        }
        counterColor = 20;
        for (int  i = design.getNum(); i < design.getNum() + design.getNumSecondLine(); i++){
            g2d.setColor(new Color(counterColor, counterColor, counterColor));
            g2d.fill(design.getDesign()[i].getPolygon());
            counterColor += 230 / design.getNumSecondLine();
        }

        counterColor = 0;
        for (int  i = design.getNum() + design.getNumSecondLine(); i < design.getNum() * 2 + design.getNumSecondLine(); i++){
            g2d.setColor(new Color(0, 0, counterColor));
            g2d.fill(design.getDesign()[i].getPolygon());
            counterColor += 255 / design.getNum();
        }
        counterColor = 20;
        for (int  i = design.getNum() * 2 + design.getNumSecondLine(); i < (design.getNum() + design.getNumSecondLine()) * 2; i++){
            g2d.setColor(new Color(0, 0, counterColor));
            g2d.fill(design.getDesign()[i].getPolygon());
            counterColor += 230 / design.getNumSecondLine();
        }
    }

}
