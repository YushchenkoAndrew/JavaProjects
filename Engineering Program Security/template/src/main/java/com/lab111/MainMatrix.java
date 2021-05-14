package main.java.com.lab111;

import article.CorrectionPrint;
import article.MathPackage.Matrix;
import article.MathPackage.NeuralNetwork;

public class MainMatrix {
    public static void main(String[] args) {
//        double[][] a = new double[][]{{1, 1, 1}, {10, 10, 1}, {-10, 10, 1}};
//        double[][] b = new double[][]{{-1, -1, -1, -1}, {-1, -2, -4, -8}, {-1, -3, -9, -27}, {-1, -4, -16, -64}};
//
//        double[][] c = new double[][]{{0.7, 0}, {0.3, 0.7}};
//        double[][] d = new double[][]{{1, 0}, {0, 1}};


/*

        int num = 200;
        double[][] c = new double[num][num];
        double[][] y = new double[num][1];

        for (int i = 0; i < num; i++) {
            c[i][i] = 1;
            y[i][0] = i + 1;
        }
*/

        double[][] d = new double[][]{{1, 1, 1, 1}, {1, 2, 2, 3}, {2, 1, -2, 2}, {3, 2, 3, 4}};
////        double[][] y = new double[][]{{2.18}, {0.13}, {2.32}};
////        double[][] y = new double[][]{{8}, {10}, {4}};
//        double[][] y = new double[][]{{1}, {1}, {1}};
        Matrix matrix = new Matrix();
//
        double[][] aa = {
                {-2, 2, -3},
                {-1, 1, 3},
                {2, 0, -1} };
//

        System.out.println(matrix.determinant(d));
//        System.out.println(matrix.determinantMethodGauss(d.clone(), 0));

        CorrectionPrint.printArray(matrix.getTurnedMatrix(d));
        CorrectionPrint.printArray(matrix.multiplication(d, matrix.getTurnedMatrix(d)));

//        System.out.println(matrix.determinant(b));
//
//        CorrectionPrint.printArray(matrix.getTurnedMatrix(d.clone()));

//        CorrectionPrint.printArray(matrix.determinantMethodGayse(a, 0));

//        System.out.println(matrix.determinant(a));
//
//        System.out.println();

//        CorrectionPrint.printArray(matrix.transposition(matrix.getArguments(a, y)));

//        CorrectionPrint.printArray(matrix.transposition(matrix.getArguments(a, y)));

//        NeuralNetwork network = new NeuralNetwork("src\\main\\java\\ProjectComprehendWroteDigests\\NeuralNetworkFiles\\Weights.dat");
//
//        network.saveData("src\\main\\java\\ProjectComprehendWroteDigests\\NeuralNetworkFiles\\SaveWeights.dat");
//
//        network.setInputFilePath("src\\main\\java\\ProjectComprehendWroteDigests\\NeuralNetworkFiles\\InputData.dat");
//
//        network.setCorrectResultFilePath("src\\main\\java\\ProjectComprehendWroteDigests\\NeuralNetworkFiles\\OutputData.dat");
//
//        System.out.println("");

//        network.calculateNeuralNet();
//
//        for (int i = 0; i < network.output.length; i++)
//            CorrectionPrint.printArray(network.output[i]);

//        network.calculateOutputResult();


//        network.machineLearning();


//        System.out.println("Result:");
//
//        CorrectionPrint.printArray(network.getResult(6));
//
//
//        network.saveData("src\\article\\MathPackage\\NeuralNetworkFiles\\SaveWeights.dat");
    }
}
