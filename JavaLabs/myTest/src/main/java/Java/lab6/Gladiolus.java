package Java.lab6;

import Java.lab8.MyException;

public class Gladiolus extends Flower  {
    public Gladiolus(int cost, int fresh)  throws MyException {
        super(cost, fresh);
    }

    @Override
    public String toString1(){
        return "Gladiolus";
    }
}
