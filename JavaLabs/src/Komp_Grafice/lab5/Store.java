package Komp_Grafice.lab5;

import java.awt.*;

public class Store {
    Shape trace;
    double t;      //store save last value of t
    double A;
    double B;
    boolean flag = true;        //need for changing direction
    boolean flagColor = true;       //need for disappear circle
    boolean flagCompare = true;
    double size = 0;
    int index = -1;

    public Shape getTrace() {
        return trace;
    }

    public void setTrace(Shape trace) {
        this.trace = trace;
    }

    public double getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public double getA() {
        return A;
    }

    public void setA(int a) {
        this.A = a;
    }

    public double getB() {
        return B;
    }

    public void setB(int b) {
        this.B = b;
    }
}
