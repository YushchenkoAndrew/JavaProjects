package Komp_Grafice.lab1;

import static java.lang.Math.sqrt;

public class Design {
    Polygon[] design;
    int[] XPoints;
    int[] YPoints;
    int num = 0;

    int count = 0;

    public Design() {
    }

    public Design(Polygon polygon, int a) {
        createDesign(polygon, a);
    }


    int numSecondLine = 0;

    private void createDesign(Polygon polygon, int a) {     //a = length of side

        int countInFirstLine = (polygon.XPoints[1] - polygon.XPoints[0]) / a;
        for (int i = 1; i <= countInFirstLine; i++) {
            num += i;
            numSecondLine += i - 1;
        }
        design = new Polygon[num * 2 + numSecondLine * 2];
        int height = (int)Math.round(sqrt(3) / 2 * a);

        funcForMakingDesign(new int[]{polygon.getXPoints()[0], polygon.getYPoints()[0]}, height, a, num, countInFirstLine, true);
        count = num;
        funcForMakingDesignSecondLine(new int[]{polygon.getXPoints()[0], polygon.getYPoints()[0]}, height, a, numSecondLine, countInFirstLine - 1, true);
        count += numSecondLine;
        funcForMakingDesign(new int[]{polygon.getXPoints()[0], polygon.getYPoints()[3]}, height, a, num, countInFirstLine, false);
        count += num;
        funcForMakingDesignSecondLine(new int[]{polygon.getXPoints()[0], polygon.getYPoints()[3]}, height, a, numSecondLine, countInFirstLine - 1, false);

    }


    private void funcForMakingDesign(int[] startPoint, int height, int weight, int num, int countInFirstLine, boolean flag) {   //flag use for making - (if false), else +
        XPoints = new int[num + 1];
        YPoints = new int[num + 1];

        XPoints[0] = startPoint[0];
        YPoints[0] = startPoint[1];

        int j = 0;
        int store = -1;
        for (int i = 0; i < num; i++) {

                design[i + count] = new Polygon(new int[]{XPoints[i], XPoints[i] + weight, XPoints[i] + weight / 2}, new int[]{YPoints[j], YPoints[j], YPoints[j] + height * (flag ? 1 : -1)});


            if ((i - store) % countInFirstLine != 0)
                XPoints[i + 1] = XPoints[i] + weight;
            else {
                XPoints[i + 1] = XPoints[i + 1 - countInFirstLine--] + weight / 2;
                YPoints[++j] = YPoints[j - 1] + height * (flag ? 1 : -1);
                store = i;
            }
        }

    }

    private void funcForMakingDesignSecondLine(int[] startPoint, int height, int weight, int num, int countInFirstLine, boolean flag) {   //flag use for making - (if false), else +
        XPoints = new int[num + 1];
        YPoints = new int[num + 1];

        XPoints[0] = startPoint[0];
        YPoints[0] = startPoint[1];

        int j = 0;
        int store = -1;
        for (int i = 0; i < num; i++) {
            design[i + count] = new Polygon(new int[]{XPoints[i] + weight / 2, XPoints[i] + weight * 3 / 2, XPoints[i] + weight}, new int[]{YPoints[j] + height * (flag ? 1 : -1), YPoints[j] + height * (flag ? 1 : -1), YPoints[j]});

            if ((i - store) % countInFirstLine != 0)
                XPoints[i + 1] = XPoints[i] + weight;
            else {
                XPoints[i + 1] = XPoints[i + 1 - countInFirstLine--] + weight / 2;
                YPoints[++j] = YPoints[j - 1] + height * (flag ? 1 : -1);
                store = i;
            }
        }

    }

    public Polygon[] getDesign() {
        return design;
    }

    public int getNum() {
        return num;
    }

    public int getNumSecondLine() {
        return numSecondLine;
    }

    public java.awt.Polygon getPolygon(int index) {
        return design[index].getPolygon();
    }
}
