package Java.lab5;

public class lab5 {
    public static void main(String[] args) {
        String string = "Some sentence that contains spacial think. World is word yep, Yep. Again, world is word yep, Yep.";
        StringBuilder str = new StringBuilder(string + " ");
        Text text = new Text(str);
        text.print();
        text.my_task();
        text.print();

        System.out.println("Done!");
    }
}