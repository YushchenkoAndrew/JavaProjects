package main.java.com.lab111.labwork6;

import article.GUI.*;
import article.GUI.Button;
import article.GUI.Panel;

import javax.swing.*;
import java.awt.*;

public class Filler {
    public static void fillGUI(GUI gui, Action action) {
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLayout(null);
        gui.setAction(action);

        gui.createPane("Diagram - 1", new Rectangle(400, 100, 600, 300), new BorderLayout());
        gui.createPane("Table - 1", new Rectangle(2, 2, 400, 125), null);

        gui.arrayPanel[0].setColor(new Color(254, 249, 231));
        gui.arrayPanel[1].setColor(new Color(234, 250, 241));


        gui.add(gui.createButton(new Rectangle(2, 640, 100, 20), true, "Add Diagram"));
        gui.addInPanel(gui.createButton(new Rectangle(150, 25, 100, 20), true, "Add Column"), 1);

        String[] columns = new String[]{"1"};
        gui.addInPanel(gui.createTable(new Rectangle(2, 60, 395, 40), columns, true), 1);
        gui.tables[0].addRow(new String[1]);

        gui.createButtonGroup();

        gui.addInPanel(gui.createRadioButton(new Rectangle(40, 100, 100, 20), "Pie Charts", true, new Color(234, 250, 241), 0), 1);
        gui.radioButtons[0].setSelected(true);
        gui.addInPanel(gui.createRadioButton(new Rectangle(140, 100, 100, 20), "Histogram", true, new Color(234, 250, 241), 0), 1);
        gui.addInPanel(gui.createRadioButton(new Rectangle(240, 100, 100, 20), "Line Charts", true, new Color(234, 250, 241), 0), 1);

        gui.mouseEvent();


        gui.repaint();
    }

    public static void fillPane(GUI gui, Action action) {
        gui.arrayPanel[gui.sizePanel] = new Panel();
        gui.arrayPanel[gui.sizePanel].setColor(new Color(234, 250, 241));
        gui.arrayPanel[gui.sizePanel].setLayoutManager(null);

        gui.buttons[gui.indexButton] = new Button();
        gui.buttons[gui.indexButton].connection(action);

        gui.arrayPanel[gui.sizePanel].addInPanel(gui.buttons[gui.indexButton].createButton(new Rectangle(150, 25, 100, 20), true, "Add Column", gui.indexButton));

        String[] columns = new String[]{"1"};

        gui.tables[gui.indexButton - 1] = new Table();

        JScrollPane scrollPane = new JScrollPane(gui.tables[gui.indexButton - 1].createTable(new Rectangle(2, 60, 395, 40), columns, true));
        scrollPane.setBounds(new Rectangle(2, 60, 395, 40));

        gui.arrayPanel[gui.sizePanel].addInPanel(scrollPane);
        gui.tables[gui.indexButton - 1].addRow(new String[1]);

        gui.radioButtons[gui.indexRadioButton] = new RadioButton();
        gui.radioButtons[gui.indexRadioButton].connection(action);
        gui.radioButtons[gui.indexRadioButton].createRadioButton(new Rectangle(40, 100, 100, 20), "Pie Charts", true, gui.indexRadioButton);
        gui.radioButtons[gui.indexRadioButton].setColor(new Color(234, 250, 241));
        gui.radioButtons[gui.indexRadioButton].setSelected(true);
        gui.buttonGroups[gui.indexButton - 1] = new ButtonGroup();
        gui.buttonGroups[gui.indexButton - 1].add(gui.radioButtons[gui.indexRadioButton].getRadioButton());
        gui.arrayPanel[gui.sizePanel].addInPanel(gui.radioButtons[gui.indexRadioButton++].getRadioButton());

        gui.radioButtons[gui.indexRadioButton] = new RadioButton();
        gui.radioButtons[gui.indexRadioButton].connection(action);
        gui.radioButtons[gui.indexRadioButton].createRadioButton(new Rectangle(140, 100, 100, 20), "Histogram", true, gui.indexRadioButton);
        gui.radioButtons[gui.indexRadioButton].setColor(new Color(234, 250, 241));
        gui.buttonGroups[gui.indexButton - 1].add(gui.radioButtons[gui.indexRadioButton].getRadioButton());
        gui.arrayPanel[gui.sizePanel].addInPanel(gui.radioButtons[gui.indexRadioButton++].getRadioButton());

        gui.radioButtons[gui.indexRadioButton] = new RadioButton();
        gui.radioButtons[gui.indexRadioButton].connection(action);
        gui.radioButtons[gui.indexRadioButton].createRadioButton(new Rectangle(240, 100, 100, 20), "Line Charts", true, gui.indexRadioButton);
        gui.radioButtons[gui.indexRadioButton].setColor(new Color(234, 250, 241));
        gui.buttonGroups[gui.indexButton - 1].add(gui.radioButtons[gui.indexRadioButton].getRadioButton());
        gui.arrayPanel[gui.sizePanel].addInPanel(gui.radioButtons[gui.indexRadioButton++].getRadioButton());

        gui.jFrame.add(gui.arrayPanel[gui.sizePanel++].createPane("Table - " + (gui.sizePanel + 1) / 2, new Rectangle(2 + gui.sizePanel * 10, 2 + gui.sizePanel * 10, 400, 150)));

        gui.arrayPanel[gui.sizePanel] = new Panel();

        gui.arrayPanel[gui.sizePanel].setColor(new Color(254, 249, 231));
        gui.arrayPanel[gui.sizePanel].setLayoutManager(new BorderLayout());
        gui.jFrame.add(gui.arrayPanel[gui.sizePanel++].createPane("Diagram - " + gui.sizePanel / 2, new Rectangle(400 + gui.sizePanel * 10, 100 + gui.sizePanel * 10, 600, 300)));
        gui.indexButton++;
    }
}
