package main.java.com.lab111.labwork5;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {

    }

    @Override
    public void notifySubjects(int a, int r, int b, int g) {
        for (Observer o : observers)
            o.update(a, r, b, g);
    }

    @Override
    public void notifySubjects() {
        for (Observer o : observers)
            o.update();
    }
}
