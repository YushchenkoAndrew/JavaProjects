package main.java.TheoryOfPossibility;

import article.CorrectionPrint;
import article.MathPackage.Matrix;

public class Main {
    public static void main(String[] args) {
        MagicClass magic = new MagicClass();

        double[][] array = new double[][]{
                {0, 1, 2},
                {0, 0, 3},
                {0.5, 0, 0}};
        System.out.println("Practical result:");
        CorrectionPrint.printArray(new double[][]{magic.magicTransformation(array)});

        Matrix matrix = new Matrix();

        double[][] x = new double[][]{
                {1, 1, 1},
                {-(array[0][0] + array[0][1] + array[0][2]), array[1][0], array[2][0]},
                {array[0][1], -(array[1][0] + array[1][1] + array[1][2]), array[2][1]}};

        double[][] y = new double[][]{{1}, {0}, {0}};

        System.out.println("Theoretical result:");
        CorrectionPrint.printArray(matrix.transposition(matrix.getArguments(x, y)));
    }
}
