package main.java.com.lab111.labwork6;

import article.ErrorState;
import article.GUI.*;

import javax.swing.*;
import java.awt.*;

public class Action extends article.ActionEvent.ActionEvent {

    public Action() {
        tableCheckingTimer.start();
    }

    @Override
    public void setGUI(GUI gui) {
        super.setGUI(gui);
    }

    @Override
    public void pressButton(int index) throws Exception {
        switch (index) {
            case 0: {
                Filler.fillPane(gui, this);
                gui.jFrame.repaint();
                break;
            }
            default: {
                String[] columns = new String[gui.tables[index - 1].getColumns().length + 1];
                String[] data = new String[gui.tables[index - 1].getColumns().length + 1];

                for (int i = 0; i < gui.tables[index - 1].getColumns().length; i++) {
                    columns[i] = gui.tables[index - 1].getColumns()[i];
                    data[i] = (String) gui.tables[index - 1].getValueAt(0, i);
                }

                columns[gui.tables[index - 1].getColumns().length] = Integer.toString(gui.tables[index - 1].getColumns().length + 1);

                gui.tables[index - 1].setBounds(new Rectangle(gui.tables[index - 1].getBounds().x, gui.tables[index - 1].getBounds().y, gui.tables[index - 1].getBounds().width + 80, gui.tables[index - 1].getBounds().height));
                gui.tables[index - 1].createColumns(columns);
                gui.tables[index - 1].addRow(data);
                break;
            }
        }

    }

    private int[] selectedDiagram = new int[20];

    public void pressedRadioButton(int index) {
        selectedDiagram[index / 3] = index % 3;
        drawDiagram(index / 3);
    }


    Timer tableCheckingTimer = new Timer(1000, e -> tableChecking());

    private void tableChecking () {
        int index = -1;
        for (int i = 0; i < gui.indexButton - 1; i++)       //buttonIndex almost the some as tableIndex
            if (gui.tables[i].isFocusOwner()) {
                index = i;
            }

        if (index != -1) {
            drawDiagram(index);
            gui.buttons[1].getjButton().requestFocus();
        }
    }

    Strategy[] strategy = new Strategy[10];

    private void drawDiagram(int index) {
        float[] data = new float[gui.tables[index].getColumns().length];
        float sum = 0;
        float max = -100;

        for (int i = 0; i < gui.tables[index].getColumns().length; i++) {
            if (gui.tables[index].getValueAt(0, i) == null) {        //need to check -- Do all elements set?
                return;
            }
            try {
            data[i] = Float.valueOf((String) gui.tables[index].getValueAt(0, i));
            sum += data[i];
            max = Float.valueOf((String) gui.tables[index].getValueAt(0, i)) > max ? Float.valueOf((String) gui.tables[index].getValueAt(0, i)) : max;
            if (data[i] < 0)
                throw new Exception();
            }
            catch (Exception e) {
                ErrorState.ErrorPopUp("Error! You enter is wrong!");
                return;
            }
        }
        if (strategy[index] != null)
            gui.arrayPanel[index == 0 ? index : index * 2 + 1].remove(strategy[index]);
        switch (selectedDiagram[index]) {
            case 0: {       //Diagram  -  Pie charts
                strategy[index] = new PieChartsStrategy(data, sum);
                break;
            }
            case 1: {       //Diagram  -  Histogram
                strategy[index] = new HistogramStrategy(data, max);
                break;
            }
            case 2: {       //Diagram  -  Line Graphs
                strategy[index] = new LineGraphsStrategy(data, max);
            }
        }

        gui.arrayPanel[index == 0 ? index : index * 2 + 1].addInPanel(strategy[index]);
        strategy[index].revalidate();
        strategy[index].repaint();

        gui.arrayPanel[index == 0 ? index : index * 2 + 1].repaintPanel();
    }


    private Timer mouseTimer;
    private int x;
    private int y;
    private int panelIndex;

    private int getIndexOfMousePressedPanel () {
        for (int i = 0; i < gui.sizePanel - 1; i++)
            if (x - gui.jFrame.getX() > gui.arrayPanel[i].getBounds().x && x - gui.jFrame.getX() < (gui.arrayPanel[i].getBounds().x + gui.arrayPanel[i].getBounds().width) && y - gui.jFrame.getY() - 25 > gui.arrayPanel[i].getBounds().y && y - gui.jFrame.getY() - 25 < (gui.arrayPanel[i].getBounds().y + gui.arrayPanel[i].getBounds().height))
                return i;
            return gui.sizePanel - 1;
    }

    @Override
    public void mousePressed() {
        x = MouseInfo.getPointerInfo().getLocation().x;
        y = MouseInfo.getPointerInfo().getLocation().y;
        panelIndex = getIndexOfMousePressedPanel();

        if (x - gui.jFrame.getX() > gui.arrayPanel[panelIndex].getBounds().x && x - gui.jFrame.getX() < (gui.arrayPanel[panelIndex].getBounds().x + gui.arrayPanel[panelIndex].getBounds().width) &&
                y - gui.jFrame.getY() - 25 > gui.arrayPanel[panelIndex].getBounds().y && y - gui.jFrame.getY() - 25 < (gui.arrayPanel[panelIndex].getBounds().y + gui.arrayPanel[panelIndex].getBounds().height)) {
            mouseTimer = new Timer(10, e -> mousePressedMove());
            mouseTimer.start();
        }
    }

    @Override
    public void mouseReleased() {
        if (mouseTimer != null)
            mouseTimer.stop();
    }

    private void mousePressedMove() {
        gui.arrayPanel[panelIndex].setBounds(new Rectangle(gui.arrayPanel[panelIndex].getBounds().x + MouseInfo.getPointerInfo().getLocation().x - x,
                gui.arrayPanel[panelIndex].getBounds().y + MouseInfo.getPointerInfo().getLocation().y - y, gui.arrayPanel[panelIndex].getBounds().width,
                gui.arrayPanel[panelIndex].getBounds().height));

        x = MouseInfo.getPointerInfo().getLocation().x;
        y = MouseInfo.getPointerInfo().getLocation().y;

        gui.jFrame.repaint();
    }
}
