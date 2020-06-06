package main.java.LeetCode;

public class Task6 {
    public static void main(String[] args) {
        System.out.println(reverse(-556));
    }

    public static int reverse(int x) {
        int result = 0;
        int a = x > 0 ? 1 : -1;
        if ((x < 1 << 31) && (x > 1 << 30))
            return 0;
        x = Math.abs(x);
        int size = (int)Math.log10(x) + 1;
        for (int i = 0; i < size; i++) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return a * result;
    }
}
