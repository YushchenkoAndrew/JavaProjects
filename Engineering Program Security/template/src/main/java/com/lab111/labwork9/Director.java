package main.java.com.lab111.labwork9;

import article.ActionEvent.ActionEvent;

import java.util.ArrayList;
import java.util.List;

public class Director {
    public List<Builder> builders = new ArrayList<>();
    private Action action;

    public void add(Builder builder) {
        builders.add(builder);
        builder.setAction(action);
    }

    public void setAction(Action action) {
        this.action = action;
    }

}
