package Java.lab6;

import Java.lab8.MyException;

public class Orchid extends Flower {
    public Orchid(int cost, int fresh)  throws MyException {
        super(cost, fresh);
    }

    @Override
    public String toString1(){
        return "Orchid";
    }
}
