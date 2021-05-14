package Java.lab1;

import java.util.Scanner;

public class lab1 {
    public static void main(String[] args){
        byte c = 52;
        char a, b, n, m, store;
        float s = 0;
        System.out.println("Enter only 1 char for each value, if you enter more, program will use first");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter value - a");
        a = scanner.next().charAt(0);
        System.out.println("Enter value - b");
        b = scanner.next().charAt(0);
        System.out.println("Enter value - n");
        n = scanner.next().charAt(0);
        System.out.println("Enter value - m");
        m = scanner.next().charAt(0);
        if (n < a) {
            store = n;
            n = a;
            a = store;
        }
        if (m < b) {
            store = m;
            m = b;
            b = store;
        }
        if ((a - c) * (n - c) > 0) {
            for (char i = a; i <= n; i++)
                for (char j = b; j <= m; j++)
                    s += (float) (i - j) / (i - c);
            System.out.printf("S = %.3f ", s);
        }
        else
            System.out.println("Something went wrong");
    }

}
