package Java.lab6;

import Java.lab8.MyException;
import org.junit.Assert;
import org.junit.Test;

public class FlowerTest {
    Flower flower;
    @Test
    public void getCost() throws MyException {
        flower = new Jasmine(10, 2);
        Assert.assertEquals(10, flower.getCost());
    }

    @Test
    public void getFresh() {
        flower = new Rose(10, 200);
        Assert.assertEquals(200, flower.getFresh());
    }
}