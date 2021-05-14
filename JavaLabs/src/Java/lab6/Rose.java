package Java.lab6;

import Java.lab8.MyException;

public class Rose extends Flower {
    public Rose(int cost, int fresh)  throws MyException {
        super(cost, fresh);
    }

    @Override
    public String toString(){
        return "Rose";
    }
}
