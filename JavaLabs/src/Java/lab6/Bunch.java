package Java.lab6;

import Java.lab8.MyException;

import java.util.Arrays;
import java.util.Comparator;

/**
 * "Bunch of flower" is my class for lab
 * It is also contain some useful method
 */

public class Bunch {
    Flower[] flowers;
    private int i = 0;
    private int bunch_cost = 0;

    /**
     * @param size - this for set range of array
     */

    public Bunch(int size) throws MyException {
        flowers = new Flower[size];
    }

    public void add(Flower flower) throws MyException {
        if (i + 1 > flowers.length){
            /*System.out.println("Error, overflow array - flowers");
            System.exit(-1);*/
            throw new MyException("Overflow array - flowers");
        }
        flowers[i++] = flower;
        bunch_cost += flower.getCost();
    }

    public int getBunch_cost() {
        return bunch_cost;
    }

    /**
     * My task is my task that sort array
     */
    public void sort() throws MyException{
        Arrays.sort(flowers, Comparator.comparingInt(Flower::getFresh));
    }

    /**
     * Method print let you print all flower that contain in bunch
     */
    public void print(){
        System.out.print("Bunch: ");
        for (Flower flower : flowers)
            System.out.print(flower + " ");
        System.out.println();
    }


    /**
     * Method range finds flower that in include in range
     * @param start - start point of range (edge)
     * @param finish - end point of range (edge)
     */
    public void range(int start, int finish) throws MyException {
        boolean q = false;
        if ((start < 0) || (finish < 0) || (finish > flowers.length) || (start > flowers.length)) {
            /*System.out.println("Error, wrong range");
            System.exit(-1);*/
            throw new MyException();
        }
        for (int i = start; i < finish; i++) {
            System.out.print(flowers[i] + " ");
            q = true;
        }
        System.out.println();
        if (!q)
//            System.out.println("Error these flowers don't exist!");
            throw new MyException("Error these flowers don't exist!");
    }

}
