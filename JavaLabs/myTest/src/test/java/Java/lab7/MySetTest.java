package Java.lab7;

import Java.lab6.Flower;
import Java.lab6.Gladiolus;
import Java.lab6.Jasmine;
import Java.lab6.Rose;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class MySetTest {
    MySet mySet;

    @Before
    public void before(){
        mySet = new MySet();
    }

    @Test
    public void testSize(){
        Assert.assertEquals(0, mySet.size());
    }

    @Test
    public void add() {
        mySet.add(new Jasmine(100, 1));
        Assert.assertEquals(1, mySet.size());
    }

    @Test
    public void addAll() {
        ArrayList<Flower> flowerSet = new ArrayList<Flower>();
        flowerSet.add(new Gladiolus(12, 5));
        flowerSet.add(new Jasmine(100, 1));
        flowerSet.add(new Rose(500, 100));

        mySet.addAll(flowerSet);
        Assert.assertEquals(3, mySet.size());
    }

    @Test
    public void size() {
        mySet = new MySet();
        ArrayList<Flower> flowerSet = new ArrayList<Flower>();
        flowerSet.add(new Gladiolus(12, 5));
        flowerSet.add(new Jasmine(100, 1));
        flowerSet.add(new Rose(500, 100));

        mySet.addAll(flowerSet);

        Assert.assertEquals(3, mySet.size());
    }

    @Test
    public void isEmpty() {
        mySet = new MySet();
        ArrayList<Flower> flowerSet = new ArrayList<Flower>();
        flowerSet.add(new Gladiolus(12, 5));
        flowerSet.add(new Rose(500, 100));

        mySet.addAll(flowerSet);

        Assert.assertFalse(mySet.isEmpty());
    }

    @Test
    public void contains() {
        mySet = new MySet();
        ArrayList<Flower> flowerSet = new ArrayList<Flower>();

        flowerSet.add(new Gladiolus(12, 5));
        flowerSet.add(new Jasmine(100, 1));
        flowerSet.add(new Rose(500, 100));

        mySet.addAll(flowerSet);

        Assert.assertTrue(mySet.contains(flowerSet.get(0)));
        Assert.assertTrue(mySet.contains(flowerSet.get(1)));
        Assert.assertTrue(mySet.contains(flowerSet.get(2)));
    }

    @Test
    public void iterator() {
        mySet = new MySet();
        ArrayList<Flower> flowerSet = new ArrayList<Flower>();

        flowerSet.add(new Gladiolus(12, 5));
        flowerSet.add(new Jasmine(100, 1));
        flowerSet.add(new Rose(500, 100));

        mySet.addAll(flowerSet);

        Iterator<Flower> i = mySet.iterator();

        Assert.assertEquals(flowerSet.get(0), i.next());
        Assert.assertTrue(i.hasNext());

        Assert.assertEquals(flowerSet.get(1), i.next());
        Assert.assertTrue(i.hasNext());


        Assert.assertEquals(flowerSet.get(2), i.next());
//        Assert.assertFalse(i.hasNext());
    }
    @Test
    public void toArray() {
        mySet = new MySet();
        Flower[] flowers = new Flower[]{new Gladiolus(12, 5), new Jasmine(100, 1), new Rose(500, 100)};

        mySet.add(flowers[0]);
        mySet.add(flowers[1]);
        mySet.add(flowers[2]);

        Assert.assertArrayEquals(flowers, mySet.toArray());
    }
    @Test
    public void toArray1() {
        mySet = new MySet();
        Flower[] flowers = new Flower[]{new Gladiolus(12, 5), new Jasmine(100, 1), new Rose(500, 100)};

        mySet.add(flowers[0]);
        mySet.add(flowers[1]);
        mySet.add(flowers[2]);

        Assert.assertArrayEquals(flowers, mySet.toArray());
    }

    @Test
    public void remove() {
        mySet = new MySet();
        ArrayList<Flower> flowerSet = new ArrayList<Flower>();

        flowerSet.add(new Gladiolus(12, 5));
        flowerSet.add(new Jasmine(100, 1));
        flowerSet.add(new Rose(500, 100));

        mySet.addAll(flowerSet);

        mySet.remove(flowerSet.get(0));
        mySet.remove(flowerSet.get(2));

        Assert.assertEquals(1, mySet.size());

        Assert.assertTrue(mySet.contains(flowerSet.get(1)));

        Assert.assertFalse(mySet.contains(flowerSet.get(0)));
    }


    @Test
    public void containsAll() {
        mySet = new MySet();

        ArrayList<Flower> flowerSet = new ArrayList<Flower>();
        flowerSet.add(new Gladiolus(12, 5));
        flowerSet.add(new Jasmine(100, 1));
        flowerSet.add(new Rose(500, 100));

        mySet.add(flowerSet.get(0));

        Assert.assertFalse(mySet.containsAll(flowerSet));

        mySet.add(flowerSet.get(1));
        mySet.add(flowerSet.get(2));

        Assert.assertTrue(mySet.containsAll(flowerSet));
    }

    @Test
    public void retainAll() {
        mySet = new MySet();

        ArrayList<Flower> flowerSet = new ArrayList<Flower>();
        flowerSet.add(new Gladiolus(12, 5));
        flowerSet.add(new Jasmine(100, 1));
        mySet.addAll(flowerSet);
        Flower flower = new Rose(500, 100);

        mySet.add(flower);

        mySet.retainAll(flowerSet);

        Assert.assertEquals(2, mySet.size());

        Assert.assertFalse(mySet.contains(flower));

        Assert.assertTrue(mySet.containsAll(flowerSet));
    }

    @Test
    public void removeAll() {
        mySet = new MySet();

        ArrayList<Flower> flowerSet = new ArrayList<Flower>();
        flowerSet.add(new Gladiolus(12, 5));
        flowerSet.add(new Jasmine(100, 1));
        flowerSet.add(new Rose(500, 100));
        mySet.addAll(flowerSet);

        mySet.removeAll(flowerSet);
        Assert.assertTrue(mySet.isEmpty());

    }

    @Test
    public void clear() {
        mySet.add(new Jasmine(100, 1));
        mySet.add(new Rose(500, 100));
        mySet.clear();

        Assert.assertTrue(mySet.isEmpty());
    }
}