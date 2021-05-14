package Java.lab6;

import Java.lab8.MyException;

public class Main {
    public static void main(String[] args) throws MyException {
        Bunch bunch = new Bunch(4);
        bunch.add(new Gladiolus(12, 5));
        bunch.add(new Orchid(5, 0));
        bunch.add(new Rose(50, 2));
        bunch.add(new Jasmine(100, 1));

        bunch.print();
        System.out.println("Bunch cost - " + bunch.getBunch_cost() + "$");
        bunch.sort();
        bunch.print();
        bunch.range(-1, 2);

        System.out.println("Done!");
    }
}
