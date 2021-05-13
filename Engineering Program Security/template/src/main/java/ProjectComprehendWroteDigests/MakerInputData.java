package main.java.ProjectComprehendWroteDigests;

/*
 *  This class will be use for getting input data to neural Network
 */

import article.ImageReaderWriter;

public class MakerInputData extends ImageReaderWriter {

    public MakerInputData() {
        super();
    }

    public MakerInputData(String path) {
        super(path);
    }

    @Override
    public void readImage() {
        super.readImage();
        double[] correction2 = new double[]{0, 37, 40, 39, 39.3, 39.5, 39.2, 39.5, 39.5, 39.5, 39.5, 39.5, 39.5, 39.5, 39.5};
//        for (int m = 5; m < 15; m++) {
//            double[] correction = new double[]{0, 37, 38.5, 39, 39.3, 39.5, 39.2, 39.5, 39.5, 39.5, 39.5, 39.5, 39.5, 39.5, 39.5};
//            for (int k = 0; k < 10; k++) {
//                for (int i = 4 + (int) (correction[k] * k); i < 32 + (int) (correction[k] * k); i++) {
//                    for (int j = (int) (correction2[m] * m); j < 27 + (int) (correction2[m] * m); j++)
//                System.out.printf("%6f;\t", (double)pixelsColor[i][j][1] / 255);
//                    System.out.printf("%6f;", (double)pixelsColor[i][27 + (int) (correction2[m] * m)][1] / 255);
////                        System.out.printf("%4d", pixelsColor[i][j][1]);
//                    System.out.print("\n");
//                }
//                System.out.println("##################################################################################################################");
//            }
//        }
//
//        for (int i = 5; i < 15; i++) {
//            System.out.println("0.8;0.2;0.2;0.2;0.2;0.2;0.2;0.2;0.2;0.2;");
//            System.out.println("###############################################");
//            System.out.println("0.2;0.8;0.2;0.2;0.2;0.2;0.2;0.2;0.2;0.2;");
//            System.out.println("###############################################");
//            System.out.println("0.2;0.2;0.8;0.2;0.2;0.2;0.2;0.2;0.2;0.2;");
//            System.out.println("###############################################");
//            System.out.println("0.2;0.2;0.2;0.8;0.2;0.2;0.2;0.2;0.2;0.2;");
//            System.out.println("###############################################");
//            System.out.println("0.2;0.2;0.2;0.2;0.8;0.2;0.2;0.2;0.2;0.2;");
//            System.out.println("###############################################");
//            System.out.println("0.2;0.2;0.2;0.2;0.2;0.8;0.2;0.2;0.2;0.2;");
//            System.out.println("###############################################");
//            System.out.println("0.2;0.2;0.2;0.2;0.2;0.2;0.8;0.2;0.2;0.2;");
//            System.out.println("###############################################");
//            System.out.println("0.2;0.2;0.2;0.2;0.2;0.2;0.2;0.8;0.2;0.2;");
//            System.out.println("###############################################");
//            System.out.println("0.2;0.2;0.2;0.2;0.2;0.2;0.2;0.2;0.8;0.2;");
//            System.out.println("###############################################");
//            System.out.println("0.2;0.2;0.2;0.2;0.2;0.2;0.2;0.2;0.2;0.8;");
//            System.out.println("###############################################");
//        }

//        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 28; i++) {
                System.out.println("0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5;");
            }
            System.out.println("###############################################");
//        }
    }

    @Override
    public void setImageReaderPath(String path) {
        super.setImageReaderPath(path);
    }
}
