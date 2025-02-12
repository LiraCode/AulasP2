package application;

public class AreaCalculator {
    public static double calcTriangle(double side1, double side2, double side3) {

        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));

    }
    public static double calcSquare(double side1) {
        return Math.sqrt(side1);
    }

    public static double calcRectangle(double side1, double side2){
        return side1*side2;
    }

    public static double calcRectangle2(double side1, double side2, double side3, double side4) {
        return (side1 +side2) * (side3 + side4)/2.0f;
    }

    public static double calcCircle(double radius) {
        return Math.PI * (radius * radius);
    }
}
