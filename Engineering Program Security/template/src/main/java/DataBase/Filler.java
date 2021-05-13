package main.java.DataBase;

import article.GUI.GUI;

import javax.swing.*;
import java.awt.*;

public class Filler {
    public static void fillGUI(GUI gui, Action action, MySQLConnector connector) throws Exception {
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLayout(null);
        gui.setAction(action);

        gui.createPane("Project", new Rectangle(2, 2, 300, 125), null);

        action.colors = new Color[connector.getSize("SHOW tables", "Tables_in_database_project")];
        action.colors[0] = new Color(234, 250, 241);
        action.colors[1] = new Color(254, 249, 231);
        action.colors[2] = new Color(244, 236, 247 );
        action.colors[3] = new Color(251, 238, 230 );

//        gui.arrayPanel[0].setColor(new Color(254, 249, 231));
        gui.arrayPanel[0].setColor(action.colors[0]);

        gui.add(gui.createComboBox(new Rectangle(2, 640, 100, 20), true, connector.getResultOfCommand("SHOW tables", "Tables_in_database_project")));

        gui.addInPanel(gui.createButton(new Rectangle(100, 25, 100, 20), true, "Add data"), 0);

        String[] columns = connector.getResultOfCommand("DESCRIBE project", "Field");
        gui.addInPanel(gui.createTable(new Rectangle(2, 60, 295, 40), columns, true), 0);

        for (int i = 0; i < connector.getSize("SELECT * FROM project", "name"); i++) {
            String[] row = new String[columns.length];
            for (int j = 0; j < columns.length; j++)
                row[j] = connector.getResultOfCommand("SELECT * FROM project", columns[j])[i];
        gui.tables[0].addRow(row);
        }
        gui.tables[0].addRow(new String[1]);

        gui.mouseEvent();
        action.setConnector(connector);
        action.tablesIndex.add(0);
        gui.repaint();

    }

    public static void fillPane(GUI gui, Action action, MySQLConnector connector, int index) throws Exception {
        String[] columns = connector.getResultOfCommand("SHOW tables", "Tables_in_database_project");
        gui.createPane(columns[index], new Rectangle(2 + index * 20, 2 + index * 20, 300, 125), null);

        gui.arrayPanel[gui.sizePanel - 1].setColor(action.colors[index]);

        gui.addInPanel(gui.createButton(new Rectangle(100, 25, 100, 20), true, "Add data"), gui.sizePanel - 1);

        String[] tableColumns = connector.getResultOfCommand("DESCRIBE " + columns[index], "Field");
        gui.addInPanel(gui.createTable(new Rectangle(2, 60, 295, 40), tableColumns, true), gui.sizePanel - 1);

        for (int i = 0; i < connector.getSize("SELECT * FROM " + columns[index], "name"); i++) {
            String[] row = new String[tableColumns.length];
            for (int j = 0; j < tableColumns.length; j++)
                row[j] = connector.getResultOfCommand("SELECT * FROM " + columns[index], tableColumns[j])[i];
            gui.tables[gui.indexTable].addRow(row);
        }
        gui.tables[gui.indexTable].addRow(new String[1]);

        gui.repaint();
    }
}
