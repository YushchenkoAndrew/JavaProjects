package Komp_Grafice.lab2;

import article.ActionEvent.ActionEvent;
import article.GUI.GUI;

import javax.swing.*;
import java.awt.*;

public class Action extends ActionEvent {
    private Draw draw;
    private float A_CONST;
    private float B_CONST;
    private float R_CONST;
    private float N_CONST;
    private float K_CONST;

    @Override
    public void setGUI(GUI gui) {
        super.setGUI(gui);
    }

    public void connection(Draw draw){
        this.draw = draw;
    }

    @Override
    public void pressButton(int index) throws Exception {
        A_CONST = Float.valueOf(gui.textFields[1].getText());
        B_CONST = Float.valueOf(gui.textFields[3].getText());
        R_CONST = Float.valueOf(gui.textFields[5].getText());
        N_CONST = Float.valueOf(gui.textFields[7].getText());
        K_CONST = Float.valueOf(gui.textFields[9].getText());

        draw.setA_CONST(A_CONST);
        draw.setB_CONST(B_CONST);
        draw.setR_CONST(R_CONST);
        draw.setN_CONST(N_CONST);
        draw.setK_CONST(K_CONST);
        draw.setjFrame(gui.jFrame);

        draw.revalidate();
        draw.repaint();

        gui.jFrame.repaint();
    }
}
