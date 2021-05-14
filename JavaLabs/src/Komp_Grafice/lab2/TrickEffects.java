package Komp_Grafice.lab2;

import java.awt.*;

public class TrickEffects {
    Graphics2D g;
    Design design;
    int num;
    int[] color;

    public TrickEffects(Graphics2D graphics2D) {
        g = graphics2D;
    }

    public void make (Design design, int counter) {
        this.design = design;
        num = design.getK_CONST();
        color = new int[num + 2];

        generateColors();
        shift(counter);

        g.setColor(new Color(color[0], color[0], color[0]));
        g.fill(design.getDrawingFigure());

        for (int i = 0; i < num - 1; i++) {
            g.setColor(new Color(color[i + 1], color[i + 1], color[i + 1]));
            g.fill(design.getDraw()[design.getDraw().length - 2 - i].getPolygon());
        }
    }

    private void generateColors() {
        int j = 0;
        System.out.println(num);
        for (int i = 0; i < 255; i += 255 / (num + 1)) {
            color[j++] = i;
        }
    }

    private void shift (int start) {
        int[] store = color.clone();
        for (int i = start; i < color.length; i++)
            color[i - start] = color[i];

        for (int i = 0; i < start; i++)
            color[color.length - start + i] = store[i];
    }

    public int colorLength() {
        return color.length;
    }
}
