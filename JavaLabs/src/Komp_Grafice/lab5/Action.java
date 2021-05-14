package Komp_Grafice.lab5;

import article.ActionEvent.ActionEvent;
import article.GUI.GUI;

import javax.swing.*;

public class Action extends ActionEvent {
    private Draw draw;
    private int indexOfTrace = 1;

    Timer[] timer = new Timer[10];

    private long counter = 0;

    private void printTime(long counter) {
        System.out.println("What time is it?");
        System.out.println("It's muffin time. Actually it's " + counter);
    }

    public void connection(Draw draw){
        this.draw = draw;
    }

    @Override
    public void pressButton(int index) throws Exception {
        switch (index) {
            case 0 : {
                Filler.addDynamicElements(gui, indexOfTrace++);
                break;
            }
            default: {
                draw.setAandB(Float.parseFloat(gui.textFields[(index - 1) * 10 + 1].getText()), Float.parseFloat(gui.textFields[(index - 1) * 10 + 3].getText()), Float.parseFloat(gui.textFields[(index - 1) * 10 + 7].getText()), Float.parseFloat(gui.textFields[(index - 1) * 10 + 9].getText()), index - 1);
                if (timer[index - 1] != null) {
                    timer[index - 1].stop();
                }
//                if (index == 2){
//
//                    timer[9] = new Timer(10, e -> printTime(counter += 10));
//                    timer[9].start();
//                }
                timer[index - 1] = new Timer(Integer.parseInt(gui.textFields[(index - 1) * 10 + 5].getText()), e -> movingShapes(index - 1));
                timer[index - 1].start();
                break;
            }
        }
        repaint();
    }

    @Override
    public void pressedRadioButton(int index) {
        switch (index % 3) {
            case 0 : {
                draw.setFlags(true, false, false, index / 3);
                break;
            }
            case 1 : {
                draw.setFlags(false, true, false, index / 3);
                break;
            }
            case 2 : {
                draw.setFlags(false, false, true, index / 3);
                break;
            }
        }
    }

    private void repaint() {
        draw.revalidate();
        draw.repaint();

        gui.arrayPanel[1].repaint();
    }

    private void movingShapes(int index) {
        draw.setDotsPlace(index, 0.001);
        repaint();
    }

}
