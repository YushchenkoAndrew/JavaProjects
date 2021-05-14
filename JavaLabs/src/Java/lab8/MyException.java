package Java.lab8;

public class MyException extends RuntimeException {
    public MyException() {
        System.out.println("Something went wrong (");
    }
    public MyException(String str) {
        System.out.println("Something went wrong ( \n" + str);
    }
}
