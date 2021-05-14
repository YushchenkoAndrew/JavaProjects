package Java.lab2;

public class lab2 {
    public static void main(String[] args) {
        long[][] A = {{2, 5, 7},
                {6, 3, 4},
                {5, -2, -3}};

        long[][] B = {{1, -1, 1},
                {-38, 41, -34},
                {27, -29, 24}};
        boolean ok = true;
        int check = -1;

        for (int i = 0; i < A.length; i++)
            if (check == -1)
                check = A[i].length;
            else if (check != A[i].length) {
                ok = false;
                break;
            }
        if (!ok) {
            System.out.println("Matrix A -- out repair");
            System.exit(0);
        } else
            check = -1;

        for (int i = 0; i < B.length; i++)
            if (check == -1)
                check = B[i].length;
            else if (check != B[i].length) {
                ok = false;
                break;
            }
        if ((!ok) || (A[0].length != B.length)) {
            System.out.println("Matrix B -- out repair");
            System.exit(0);
        }
        long[][] C = new long[10][10];
        long min = 0;
        long sum = 0;
        System.out.println("Matrix C");
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < B[i].length; k++) {
                for (int j = 0; j < A.length; j++) {
                    C[i][k] += A[i][j] * B[j][k];
                }
                if (k == 0)
                    min = C[i][k];
                else if (C[i][k] <= min)
                    min = C[i][k];
                System.out.printf("%5d", C[i][k]);
            }
            sum += min;
            System.out.println();
        }
        System.out.println("Sum(min) = " + sum);
    }
}
