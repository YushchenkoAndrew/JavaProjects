package Java.lab7;

import Java.lab6.Flower;

import java.util.*;

public class MySet implements Set<Flower> {
    int mySize = 15;
    int addSize = 5;
    int i = 0;
    Flower[] flowers = new Flower[mySize];

    public MySet(){

    }

    public MySet(Flower flower){
        add(flower);
    }

    public MySet(Collection <Flower> flowers){
        addAll(flowers);
    }

    @Override
    public boolean add(Flower flower){
        if (i + 1 > mySize) {
            mySize += mySize * 30 / 100;
            Flower[] flower1 = new Flower[mySize];
            int j = 0;
            for (Flower f : flowers)
                flower1[j++] = f;
            flowers = flower1;
        }
        if (!contains(flower))
            flowers[i++] = flower;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Flower> c) {
        for (Flower flower : c)
            add(flower);
        return false;
    }

    @Override
    public int size() {
        return i;
    }

    @Override
    public boolean isEmpty() {
        return i == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int j = 0; j < flowers.length; j++)
            if (o.equals(flowers[j])) {
                return true;
            }
        return false;
    }


    @Override
    public Iterator<Flower> iterator() {
        return new Iterator<Flower>() {
            int j = 0;
            @Override
            public boolean hasNext() {
                return j < i;
            }

            @Override
            public Flower next() {
                return flowers[j++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(flowers, size());
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays.copyOf(flowers, mySize, a.getClass());
    }

    @Override
    public boolean remove(Object o) {
        Iterator<Flower> flowerIterator = iterator();
        Flower[] flowers1 = new Flower[mySize];
        boolean flag = false;
        int i = -1, j = 0;
        while (flowerIterator.hasNext()) {
            i++;
            if (o.equals(flowerIterator.next())) {
                flag = true;
            } else {
                flowers1[i - j] = flowers[i];

            }
        }
        this.i--;
        if (flag) {
            flowers = flowers1;
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c)
            if (!contains(o))
                return false;
        return true;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        Iterator<Flower> flowerIterator = iterator();
        Flower[] flowers = new Flower[mySize];
        int j = 0;
        while (flowerIterator.hasNext()){
            Flower flower = flowerIterator.next();
           for(Object o : c)
               if (o.equals(flower))
                   flowers[j++] = flower;
            }
        this.i = j;
        this.flowers = flowers;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c)
            remove(o);
        return false;
    }

    @Override
    public void clear() {
        flowers = new Flower[mySize];
        i = 0;
    }
}
