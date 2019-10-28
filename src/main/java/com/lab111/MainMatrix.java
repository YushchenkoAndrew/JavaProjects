package main.java.com.lab111;

import article.CorrectionPrint;
import article.MathPackage.Matrix;

public class MainMatrix {
    public static void main(String[] args) {
        double[][] a = new double[][]{{1, 2, 1}, {3, 2, 1}, {4, 3, -2}};
        double[][] b = new double[][]{{-1, -1, -1, -1}, {-1, -2, -4, -8}, {-1, -3, -9, -27}, {-1, -4, -16, -64}};

        int num = 200;
        double[][] c = new double[num][num];
        double[][] y = new double[num][1];

        for (int i = 0; i < num; i++) {
            c[i][i] = 1;
            y[i][0] = i + 1;
        }

        double[][] d = new double[][]{{1, 1, 1, 1, 1}, {1, 2, 2, 3, 4}, {2, 1, -2, 2, -3}, {3, 2, 3, 4, 1}, {-1, 1, -4, 4, 2}};

//        double[][] y = new double[][]{{3}, {9}, {-16}, {2}, {-12}};
//        double[][] y = new double[][]{{8}, {10}, {4}};
        Matrix matrix = new Matrix();

        System.out.println(matrix.determinant(b));

        CorrectionPrint.printArray(matrix.getTurnedMatrix(d.clone()));

//        CorrectionPrint.printArray(matrix.determinantMethodGayse(a, 0));

        System.out.println(matrix.determinant(c));

        System.out.println();

//        CorrectionPrint.printArray(matrix.transposition(matrix.getArguments(c, y)));

        CorrectionPrint.printArray(matrix.transposition(matrix.getArguments(c, y)));

    }
}
