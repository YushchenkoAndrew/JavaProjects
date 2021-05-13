package main.java.com.lab111.labwork8;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private Map<String, Flyweight> flyweightMap = new HashMap<>();      //It's a dictionary

    public Flyweight getFlyweight(String name, Draw draw) {

            Flyweight shape = flyweightMap.get(name);

            if (shape == null) {
                switch (name) {
                    case "Pixel": {
                        shape = new Pixel();
                        break;
                    }
                    case "Oval": {
                        shape = new Oval();
                        break;
                    }
                    case "Line": {
                        shape = new Line();
                        break;
                    }
                    case "Rectangle": {
                        shape = new Rectangle();
                        break;
                    }
                    case "Triangle": {
                        shape = new Triangle();
                        break;
                    }
                }
                flyweightMap.put(name, shape);
                shape.setDraw(draw);
            }
        return shape;
    }
}
