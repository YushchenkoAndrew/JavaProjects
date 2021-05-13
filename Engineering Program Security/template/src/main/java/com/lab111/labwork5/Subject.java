package main.java.com.lab111.labwork5;

public interface Subject {      //in my case subject is Pixel
    void attach(Observer o);

    void detach(Observer o);

    void notifySubjects(int a, int r, int g, int b);

    void notifySubjects();
}
