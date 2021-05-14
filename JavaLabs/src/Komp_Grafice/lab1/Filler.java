package Komp_Grafice.lab1;

import article.GUI.GUI;

import javax.swing.*;

public class Filler {
    public static void fillGUI(GUI gui, Draw draw){
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gui.add(draw);
        gui.repaint();
    }

}
