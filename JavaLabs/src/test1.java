import java.io.PrintWriter;
public class test1 {
    public static void main(String[] args) {
        System.out.println("Hey there are!");
        PrintWriter printWriter = new PrintWriter(System.out, true);
        printWriter.println("aa =" + '1' + '\u0305' + '\u0005');
        System.out.println(8229 % 2);
        System.out.println(8229 % 3);
        System.out.println(8229 % 11);
    }
}
