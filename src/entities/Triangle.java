package entities;

public class Triangle {
   private final double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getArea(){
        double p = this.a+this.b+this.c/2.0f;
        return Math.sqrt(p*(p-this.a)*(p-this.b)*(p-this.c));
    }
}
