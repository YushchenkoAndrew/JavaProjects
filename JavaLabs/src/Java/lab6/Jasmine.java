package Java.lab6;

import Java.lab8.MyException;

public class Jasmine extends Flower {
    public Jasmine(int cost, int fresh) throws MyException {
        super(cost, fresh);
    }

    @Override
    public String toString(){
        return "Jasmine";
    }
}
