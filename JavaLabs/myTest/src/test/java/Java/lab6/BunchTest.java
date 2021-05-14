package Java.lab6;

import org.junit.Assert;
import org.junit.Test;

public class BunchTest {
    Bunch bunch;

    @Test
    public void add() {
        Flower[] flowers = new Flower[]{new Gladiolus(5, 10), new Jasmine(500, 2), new Rose(50, 1),
                new Jasmine(5000, 2)};

        bunch = new Bunch(4);
        bunch.add(flowers[0]);
        bunch.add(flowers[1]);
        bunch.add(flowers[2]);
        bunch.add(flowers[3]);
        bunch.sort();

        Assert.assertTrue(bunch.contains(flowers[0]));

        Assert.assertTrue(bunch.contains(flowers[1]));

        Assert.assertTrue(bunch.contains(flowers[2]));

        Assert.assertTrue(bunch.contains(flowers[3]));
    }

    @Test
    public void getBunch_cost() {
        bunch = new Bunch(4);
        bunch.add(new Rose(50, 1));
        bunch.add(new Jasmine(500, 2));
        bunch.add(new Gladiolus(5, 10));
        bunch.add(new Jasmine(5000, 2));

        Assert.assertEquals(5555, bunch.getBunch_cost());
    }

    @Test
    public void sort() {
        Flower[] flowers = new Flower[]{new Gladiolus(5, 10), new Jasmine(500, 2), new Rose(50, 1),
                                        new Jasmine(5000, 2)};

        bunch = new Bunch(4);
        bunch.add(flowers[0]);
        bunch.add(flowers[1]);
        bunch.add(flowers[2]);
        bunch.add(flowers[3]);
        bunch.sort();

        Assert.assertEquals(flowers[2], bunch.get(0));
    }

    @Test
    public void range() {
        Flower[] flowers = new Flower[]{new Jasmine(500, 2), new Rose(50, 1)};

        bunch = new Bunch(4);
        bunch.add(new Gladiolus(5, 10));
        bunch.add(flowers[0]);
        bunch.add(flowers[1]);
        bunch.add(new Jasmine(5000, 2));

        bunch.range(1, 3);

        Assert.assertArrayEquals(flowers, bunch.getFlowersRange());

    }
}