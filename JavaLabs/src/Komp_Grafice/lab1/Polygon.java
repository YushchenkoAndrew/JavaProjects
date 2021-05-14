package Komp_Grafice.lab1;
import static java.lang.Math.sqrt;


public class Polygon {
    java.awt.Polygon polygon = new java.awt.Polygon();
    int num = 4;
    int[] XPoints = new int[num];
    int[] YPoints = new int[num];
    public Polygon(){

    }

    public Polygon(int x, int y, int r){
        for (int i = 0; i < 2; i ++) {
            XPoints[i] = (x + r / 2 * (i == 0 ? -1 : 1));
            YPoints[i * 2] = (int)(y + sqrt(r * r - r * r / 4) * (i == 0 ? -1 : 1));
        }
        XPoints[2] = XPoints[0];
        XPoints[3] = XPoints[1];
        YPoints[1] = YPoints[0];
        YPoints[3] = YPoints[2];
        setPoints(XPoints, YPoints);
    }

    public Polygon (int[] XPoints, int[] YPoints) {
        this.XPoints = XPoints;
        this.YPoints = YPoints;
        setPoints(XPoints, YPoints);
    }

    private void setPoints(int[] XPoints, int[] YPoints){
        for (int i = 0; i < XPoints.length; i++)
            polygon.addPoint(XPoints[i], YPoints[i]);
    }

    public java.awt.Polygon getPolygon() {
        return polygon;
    }

    public int[] getXPoints() {
        return XPoints;
    }

    public int[] getYPoints() {
        return YPoints;
    }
}
