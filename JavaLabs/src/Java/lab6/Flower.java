package Java.lab6;

import Java.lab8.MyException;

public class Flower {
    private int cost;
    private int fresh;  //left days

    public Flower(int cost, int fresh) throws MyException {
        if (cost < 0 || fresh < 0)
            throw new MyException();
        this.cost = cost;
        this.fresh = fresh;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() throws MyException {
        throw new MyException("This flower doesn't exit");
    }

    public int getFresh() {
        return fresh;
    }

}
