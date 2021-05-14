package Komp_Grafice.lab5;


import article.RainbowColors;

import javax.swing.*;
import java.awt.*;

public class Draw extends JComponent {
    private Store[] store = new Store[10];
    private RainbowColors colors;
    boolean direction = true;
    boolean disappear = false;
    boolean comparing = false;

    DrawingFigure drawingFigure = new DrawingFigure();

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        colors = new RainbowColors();
        colors.setStep(Math.PI / 3);
        Graphics2D graphics2D = (Graphics2D)g;
        for(int i = 0; i < store.length; i++) {
            graphics2D.setColor(colors.getColor());
            if (store[i] != null) {
                graphics2D.draw(store[i].trace);
                double[] location = DrawingFigure.getDotLocation(store[i].t, store[i].A, store[i].B);
                if(store[i].flagColor)
                    graphics2D.fillOval((int)(location[0] - store[i].size), (int)(location[1] - store[i].size), (int)store[i].size * 2, (int)store[i].size * 2);
            }
        }

    }

    public void setAandB(float A, float B, float t, float size, int index) {
        if(store[index] == null)
            store[index] = new Store();

        store[index].trace = drawingFigure.drawFigure(A, B);
        store[index].A = A;
        store[index].B = B;
        store[index].t = t;
        store[index].size = size;
        store[index].flagCompare = true;
    }

    public void setFlags(boolean direction, boolean comparing, boolean disappear, int index) {
        this.direction = direction;
        this.disappear = disappear;
        this.comparing = comparing;
        visible(-1);
    }

    public void visible(int index) {
        for (int i = 0; i < store.length; i++) {
            if (store[i] != null && i != index) {
                store[i].flagColor = true;
            }
        }
    }

    public void compare(int i, int index) {
        store[index].A = store[i].A;
        store[index].B = store[i].B;
        store[index].t = store[i].t;
        store[index].size = store[i].size;
        store[index].flag = store[i].flag;

    }

    public void setDotsPlace(int index, double t) {
        if (!store[index].flagCompare) {
            store[index].t = store[store[index].index].t;
            return;
        }

        store[index].t += t * (store[index].flag ? 1 : -1);
        double[] dotLocation = DrawingFigure.getDotLocation(store[index].t, store[index].A, store[index].B);

        if (!store[index].flagColor)
            return;

        for (int i = 0; i < store.length; i++) {
            if (store[i] != null && (i != index)) {
                double[] location = DrawingFigure.getDotLocation(store[i].t, store[i].A, store[i].B);
                if (((Math.abs(dotLocation[0] - location[0]) < 7) && (Math.abs(dotLocation[1] - location[1]) < 7)) && store[i].flagColor) {
                    if (direction || disappear) {
                        store[index].flag = !store[index].flag;
                        store[index].t += 2 * t * (store[index].flag ? 1 : -1);

                        store[i].flagColor = disappear != store[i].flagColor;
//                        System.out.println("######################Done!!################################");
                        visible(i);
                        continue;
                    }
                    if (comparing && store[i].flagCompare) {
                        compare(i, index);
                        store[index].index = i;
                        store[index].flagCompare = false;
                    }
                }
            }
        }

    }
}