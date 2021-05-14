package Java.lab7;

import Java.lab6.Flower;
import Java.lab6.Gladiolus;
import Java.lab6.Jasmine;
import Java.lab6.Rose;
import Java.lab8.MyException;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws MyException {
            ArrayList<Flower> flowerSet = new ArrayList<Flower>();
            Flower flowerTest = new Gladiolus(12, 5);

            flowerSet.add(new Gladiolus(12, 5));
            flowerSet.add(new Jasmine(100, 1));
            flowerSet.add(new Rose(500, 100));

            MySet mySet = new MySet(flowerSet);

            System.out.println(mySet.contains(new Gladiolus(12, 5)));

            Iterator<Flower> i = mySet.iterator();
            mySet.remove(flowerTest);

            while (i.hasNext())
                System.out.println(i.next());
        System.out.println("Done!");
    }
}
