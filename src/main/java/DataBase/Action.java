package main.java.DataBase;

import article.ActionEvent.ActionEvent;
import org.hibernate.engine.jdbc.CharacterStream;
import org.hibernate.engine.jdbc.internal.CharacterStreamImpl;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.Set;

public class Action extends ActionEvent {
    Color[] colors;
    private MySQLConnector connector;
    Set tablesIndex = new HashSet();

    @Override
    public void pressButton(int index) throws Exception {
        switch (index) {
            case 0 : {
                PreparedStatement prepState  =
                        connector.connection.prepareStatement("INSERT INTO project VALUE (?, null, ?)");
                prepState.setString(1, (String) gui.tables[index].getValueAt(gui.tables[index].counter - 1, 0));
                prepState.setInt(2, Integer.parseInt(gui.tables[index].getValueAt(gui.tables[index].counter - 1, 2).toString()));
                prepState.executeUpdate();
                gui.tables[index].addRow(new String[1]);
                break;
            }
            case 1: {
                PreparedStatement prepState  =
                        connector.connection.prepareStatement("INSERT INTO stage VALUE (?, ?, ?, ?, ?, ?, ?, ?)");
                prepState.setString(1, (String) gui.tables[index].getValueAt(gui.tables[index].counter - 1, 0));
                prepState.setDate(2, Date.valueOf((String) gui.tables[index].getValueAt(gui.tables[index].counter - 1, 1)));
                prepState.setDate(3, Date.valueOf((String) gui.tables[index].getValueAt(gui.tables[index].counter - 1, 2)));
                prepState.setString(4, (String) gui.tables[index].getValueAt(gui.tables[index].counter - 1, 3));
                prepState.setString(5, (String) gui.tables[index].getValueAt(gui.tables[index].counter - 1, 4));
                prepState.setInt(6, Integer.parseInt(gui.tables[index].getValueAt(gui.tables[index].counter - 1, 5).toString()));
                prepState.setInt(7, Integer.parseInt(gui.tables[index].getValueAt(gui.tables[index].counter - 1, 6).toString()));
                prepState.setString(8, (String) gui.tables[index].getValueAt(gui.tables[index].counter - 1, 7));
                prepState.executeUpdate();
                gui.tables[index].addRow(new String[1]);
                break;
            }
            case 2: {
                PreparedStatement prepState  =
                        connector.connection.prepareStatement("INSERT INTO task VALUE (?, ?, ?, ?, ?, ?, ?, ?)");
                prepState.setInt(1, Integer.parseInt(gui.tables[index].getValueAt(gui.tables[index].counter - 1, 0).toString()));
                prepState.setString(2, (String) gui.tables[index].getValueAt(gui.tables[index].counter - 1, 1));
                prepState.setDate(3, Date.valueOf((String) gui.tables[index].getValueAt(gui.tables[index].counter - 1, 2)));
                prepState.setInt(4, Integer.parseInt(gui.tables[index].getValueAt(gui.tables[index].counter - 1, 3).toString()));
                prepState.setString(5, (String) gui.tables[index].getValueAt(gui.tables[index].counter - 1, 4));
                prepState.setString(6, (String) gui.tables[index].getValueAt(gui.tables[index].counter - 1, 5));
                prepState.setInt(7, Integer.parseInt(gui.tables[index].getValueAt(gui.tables[index].counter - 1, 6).toString()));
                prepState.setString(8, (String) gui.tables[index].getValueAt(gui.tables[index].counter - 1, 7));
                prepState.executeUpdate();
                gui.tables[index].addRow(new String[1]);
                break;
            }
            case 3: {
                PreparedStatement prepState  =
                        connector.connection.prepareStatement("INSERT INTO worker VALUE (?, ?, ?, ?, ?, ?, ?)");
                prepState.setString(1, (String) gui.tables[index].getValueAt(gui.tables[index].counter - 1, 0));
                prepState.setString(2, (String) gui.tables[index].getValueAt(gui.tables[index].counter - 1, 1));
                prepState.setString(3, (String) gui.tables[index].getValueAt(gui.tables[index].counter - 1, 2));
                prepState.setInt(4, Integer.parseInt(gui.tables[index].getValueAt(gui.tables[index].counter - 1, 3).toString()));
                prepState.setString(5, (String) gui.tables[index].getValueAt(gui.tables[index].counter - 1, 4));
                prepState.setInt(6, Integer.parseInt(gui.tables[index].getValueAt(gui.tables[index].counter - 1, 5).toString()));
                prepState.setString(7, (String) gui.tables[index].getValueAt(gui.tables[index].counter - 1, 6));
                prepState.executeUpdate();
                gui.tables[index].addRow(new String[1]);
                break;
            }
        }
    }

    @Override
    public void pressComboBox(int index) throws Exception {
        if (!tablesIndex.contains(index)) {
            tablesIndex.add(index);
            Filler.fillPane(gui, this, connector, index);
        }
    }

    private int getIndexOfMousePressedPanel () {
        for (int i = 0; i < gui.sizePanel; i++)
            if (x - gui.jFrame.getX() > gui.arrayPanel[i].getBounds().x && x - gui.jFrame.getX() - 5 < (gui.arrayPanel[i].getBounds().x + gui.arrayPanel[i].getBounds().width) && y - gui.jFrame.getY() - 25 > gui.arrayPanel[i].getBounds().y && y - gui.jFrame.getY() - 25 < (gui.arrayPanel[i].getBounds().y + gui.arrayPanel[i].getBounds().height))
                return i;
        return -1;
    }

    private Timer mouseTimer;
    private int x;
    private int y;
    private int panelIndex;

    @Override
    public void mousePressed() {
        x = MouseInfo.getPointerInfo().getLocation().x;
        y = MouseInfo.getPointerInfo().getLocation().y;
        panelIndex = getIndexOfMousePressedPanel();
        if (panelIndex != -1) {
            if (x - gui.jFrame.getX() + 5 > (gui.arrayPanel[panelIndex].getBounds().x + gui.arrayPanel[panelIndex].getBounds().width) &&
                    x - gui.jFrame.getX() - 5 < (gui.arrayPanel[panelIndex].getBounds().x + gui.arrayPanel[panelIndex].getBounds().width) &&
                    y - gui.jFrame.getY() - 35 < (gui.arrayPanel[panelIndex].getBounds().y + gui.arrayPanel[panelIndex].getBounds().height) &&
                    y - gui.jFrame.getY() - 15 > (gui.arrayPanel[panelIndex].getBounds().y + gui.arrayPanel[panelIndex].getBounds().height)) {
                mouseTimer = new Timer(10, e -> mousePressedResize());
                gui.updateCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
            }
            else {
                mouseTimer = new Timer(10, e -> mousePressedMove());
            gui.updateCursor(new Cursor(Cursor.MOVE_CURSOR));
            }
        }
        if (mouseTimer != null)
            mouseTimer.start();
    }

    @Override
    public void mouseReleased() {
        if (mouseTimer != null) {
            mouseTimer.stop();
            mouseTimer = null;
            gui.updateCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

    }

    private void mousePressedMove() {
        gui.arrayPanel[panelIndex].setBounds(new Rectangle(gui.arrayPanel[panelIndex].getBounds().x + MouseInfo.getPointerInfo().getLocation().x - x,
                gui.arrayPanel[panelIndex].getBounds().y + MouseInfo.getPointerInfo().getLocation().y - y, gui.arrayPanel[panelIndex].getBounds().width,
                gui.arrayPanel[panelIndex].getBounds().height));

        x = MouseInfo.getPointerInfo().getLocation().x;
        y = MouseInfo.getPointerInfo().getLocation().y;

        gui.jFrame.repaint();
    }

    private void mousePressedResize() {
        gui.arrayPanel[panelIndex].setBounds(new Rectangle(gui.arrayPanel[panelIndex].getBounds().x, gui.arrayPanel[panelIndex].getBounds().y,
                gui.arrayPanel[panelIndex].getBounds().width - x + MouseInfo.getPointerInfo().getLocation().x,
                gui.arrayPanel[panelIndex].getBounds().height - y + MouseInfo.getPointerInfo().getLocation().y));

        gui.scrollPane[panelIndex].setBounds(new Rectangle(gui.scrollPane[panelIndex].getBounds().x, gui.scrollPane[panelIndex].getBounds().y,
                gui.scrollPane[panelIndex].getBounds().width - x + MouseInfo.getPointerInfo().getLocation().x,
                gui.scrollPane[panelIndex].getBounds().height - y + MouseInfo.getPointerInfo().getLocation().y));

        gui.tables[panelIndex].setBounds(new Rectangle(gui.tables[panelIndex].getBounds().x, gui.tables[panelIndex].getBounds().y,
                gui.tables[panelIndex].getBounds().width - x + MouseInfo.getPointerInfo().getLocation().x,
                gui.tables[panelIndex].getBounds().height - y + MouseInfo.getPointerInfo().getLocation().y));

        x = MouseInfo.getPointerInfo().getLocation().x;
        y = MouseInfo.getPointerInfo().getLocation().y;

        gui.arrayPanel[panelIndex].repaint();
        gui.jFrame.repaint();
    }

    public void setConnector(MySQLConnector connector) {
        this.connector = connector;
    }
}
