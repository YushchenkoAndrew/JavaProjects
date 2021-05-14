package Komp_Grafice.lab5;

import article.GUI.GUI;

import javax.swing.*;
import java.awt.*;

public class Filler {
    public static void fillGUI(GUI gui, Action action, Draw draw){
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLayout(null);
        gui.setAction(action);
        int textFieldPaneHeight = 20;
        int textFieldPaneX1 = 15;
        int textFieldPaneX2 = 50;
        int textFieldPaneY = 20;
        int textFieldPaneWidth1 = 30;
        int textFieldPaneWidth2 = 50;


        gui.createPane("Parameters", new Rectangle(2, 2, 280, 460), null);
        gui.createPane("Traces", new Rectangle(284, 2, 400, 460), new BorderLayout());

        gui.arrayPanel[0].setColor(new Color(254, 249, 231));
        gui.arrayPanel[1].setColor(new Color(235, 245, 251));



        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY, textFieldPaneWidth1, textFieldPaneHeight),
                false, "A1", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY, textFieldPaneWidth2, textFieldPaneHeight),
                true, "3", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 20, textFieldPaneWidth1, textFieldPaneHeight),
                false, "A2", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 20, textFieldPaneWidth2, textFieldPaneHeight),
                true, "0.03", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 40, textFieldPaneWidth1, textFieldPaneHeight),
                false, "Sp", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 40, textFieldPaneWidth2, textFieldPaneHeight),
                true, "50", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 60, textFieldPaneWidth1, textFieldPaneHeight),
                false, "Loc", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 60, textFieldPaneWidth2, textFieldPaneHeight),
                true, "0.03", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX1 + 100, textFieldPaneY, textFieldPaneWidth1, textFieldPaneHeight),
                false, "S", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2 + 100, textFieldPaneY, textFieldPaneWidth2, textFieldPaneHeight),
                true, "7", true), 0);

        gui.createButtonGroup();

        gui.addInPanel(gui.createRadioButton(new Rectangle(120, 45, 100, 20), "Direction", true, new Color(254, 249, 231), 0), 0);
        gui.addInPanel(gui.createRadioButton(new Rectangle(120, 65, 100, 20), "Comparing", true, new Color(254, 249, 231), 0), 0);
        gui.addInPanel(gui.createRadioButton(new Rectangle(120, 85, 100, 20), "Disappear", true, new Color(254, 249, 231), 0), 0);

        gui.radioButtons[0].setSelected(true);
        gui.addInPanel(gui.createButton(new Rectangle(35, 425, 100, 25), true,  "Add Trace"), 0);

        gui.addInPanel(gui.createButton(new Rectangle(220, 45, 45, 25), true,  "Load"), 0);

        action.connection(draw);

        gui.addInPanel(draw, 1);
        gui.repaint();
    }
    public static void addDynamicElements(GUI gui, int index) {
        gui.addInPanel(gui.createTextField(new Rectangle(15, index * 100 + 5, 30, 20),
                false, "A1", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(50, index * 100 + 5, 50, 20),
                true, "3", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(15, 25 + index * 100, 30, 20),
                false, "A2", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(50, 25 + index * 100, 50, 20),
                true, "0.03", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(15, index * 100 + 45, 30, 20),
                false, "Sp", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(50, index * 100 + 45, 50, 20),
                true, "50", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(15, 65 + index * 100, 30, 20),
                false, "Loc", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(50, 65 + index * 100, 50, 20),
                true, "0.03", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(115, 5 + index * 100, 30, 20),
                false, "S", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(150, 5 + index * 100, 50, 20),
                true, "7", true), 0);

        gui.addInPanel(gui.createButton(new Rectangle(220, 100 * index + 25, 45, 25), true,  "Load"), 0);

        gui.arrayPanel[0].repaintPanel();
    }
}
