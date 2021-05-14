package Komp_Grafice.lab2;

import Komp_Grafice.lab2.Draw;
import article.GUI.GUI;

import javax.swing.*;
import java.awt.*;

public class Filler {
    public static void fillGUI(GUI gui, Action action, Draw draw){
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setAction(action);
        int textFieldPaneHeight = 20;
        int textFieldPaneX1 = 15;
        int textFieldPaneX2 = 55;
        int textFieldPaneY = 45;
        int textFieldPaneWidth1 = 30;
        int textFieldPaneWidth2 = 140;


//        gui.createPane("Main registers", new Rectangle(2, 80, 205, 185));

        gui.add(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY, textFieldPaneWidth1, textFieldPaneHeight),
                false, "A", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY, textFieldPaneWidth2, textFieldPaneHeight),
                true, "3", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 20, textFieldPaneWidth1, textFieldPaneHeight),
                false, "B", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 20, textFieldPaneWidth2, textFieldPaneHeight),
                true, "3", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 40, textFieldPaneWidth1, textFieldPaneHeight),
                false, "R", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 40, textFieldPaneWidth2, textFieldPaneHeight),
                true, "100", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 60, textFieldPaneWidth1, textFieldPaneHeight),
                false, "N", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 60, textFieldPaneWidth2, textFieldPaneHeight),
                true, "18", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 80, textFieldPaneWidth1, textFieldPaneHeight),
                false, "K", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 80, textFieldPaneWidth2, textFieldPaneHeight),
                true, "10", true));

        gui.add(gui.createButton(new Rectangle(95, 155, 45, 25), true,  "Load"));

        action.connection(draw);

        gui.add(draw);
        gui.repaint();
    }

}
