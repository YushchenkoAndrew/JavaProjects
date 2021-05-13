package main.java.TheoryOfPossibility;

import article.CorrectionPrint;
import article.MathPackage.Matrix;

public class MagicClass {

    private Matrix matrix = new Matrix();

    public double[] getPossibilities(double[][] array) {
        double[] result = new double[array.length];
        int stat = 1;
        int nexStat = 1;

        for (long j = 0; j < 1000; j++) {
            double rand;
            double min = Integer.MAX_VALUE;
            for (int i = 0; i < array.length; i++) {
                rand = array[stat][i] != 0 ? (-1) / array[stat][i] * Math.log(Math.random()) : -1;
                if (min > rand && rand != -1) {
                    min = rand;
                    nexStat = i;
                }
            }
            result[stat] += min;
            stat = nexStat;
        }
        int total = 0;
        for (int i = 0; i < result.length; i++)
            total += result[i];
        result = matrix.multiplication(new double[][]{result}, 1.0 / total)[0];

        return result;
    }

    public double[] magicTransformation(double[][] array) {
        double[][] newTesting = new double[array.length * array.length][array.length * array.length];

        int increase = 0;

        int[][] store = new int[newTesting.length][newTesting.length];

        for (int i = 0; i < array.length; i++) {
            int k = 0;
            for (int j = 0; j < array.length; j++)
                if (array[i][j] != 0) {
                    newTesting[i][array.length + increase] = 2 * array[i][j];
                    newTesting[array.length + increase++][j] = 2 * array[i][j];
                    store[i][k++] = array.length + increase - 1;
                }
        }
        double[] result = new double[array.length];
        double[] oldResult = getPossibilities(newTesting);

//        CorrectionPrint.printArray(new double[][]{oldResult});

        for (int i = 0; i < result.length; i++) {
            result[i] = oldResult[i];
            int j = 0;
            while (store[i][j] != 0) {
                result[i] += oldResult[store[i][j++]];
            }
        }

        return result;
    }
}
