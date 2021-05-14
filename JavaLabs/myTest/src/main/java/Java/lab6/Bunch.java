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
    Flower[] flowersRange;

    /**
     * @param size - this for set range of array
     */

    public Bunch(int size) throws MyException {
        flowers = new Flower[size];
        flowersRange = new Flower[size];
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

    public Flower get(int index){
        return flowers[index];
    }

    public boolean contains(Object o){
        for(Flower flower : flowers)
            if (o.equals(flower))
                return true;
            return false;
    }

    /**
     * Method print let you print all flower that contain in bunch
     */
    public void print(){
        System.out.print("Bunch: ");
        for (Flower flower : flowers)
            System.out.print(flower.toString1() + " ");
        System.out.println();
    }

    public Flower[] getFlowersRange(){
        return flowersRange;
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
        int j = 0;
        for (int i = start; i < finish; i++) {
            flowersRange[j++] = flowers[i];
            System.out.print(flowers[i].toString1() + " ");
            q = true;
        }
        Flower [] store = new Flower[j];
        for (int k = 0; k < j; k++) {
            store[k] = flowersRange[k];
        }
        flowersRange = new Flower[j];
        flowersRange = store.clone();

        System.out.println();
        if (!q)
//            System.out.println("Error these flowers don't exist!");
            throw new MyException("Error these flowers don't exist!");
    }

}
