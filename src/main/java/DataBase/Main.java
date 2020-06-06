package main.java.DataBase;

import article.GUI.GUI;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MySQLConnector connector = new MySQLConnector();
        try {
            connector.setConnection("jdbc:mysql://127.0.0.1:3306/database_project");

            GUI gui = new GUI(new Rectangle(200, 50, 1200, 700));
            Action action = new Action();
            Filler.fillGUI(gui, action, connector);

        } catch (Exception ex) {
            System.out.println("Noooo");
        }

//        connector.close();
//        System.out.println("Yep");
    }
}
