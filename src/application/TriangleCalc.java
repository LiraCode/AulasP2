package application;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import entities.Triangle;

public class TriangleCalc {


    public static void main(String[] args) {
        ArrayList<Triangle> triangles = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String answer = "S";
        while (answer.equalsIgnoreCase("S")) {
            System.out.println("Deseja s um Triângulo (S/N)?");
            answer = sc.next();
            System.out.println(answer);

            if (answer.equalsIgnoreCase("S")) {
                System.out.println("informe as medidas do triangulo");
                double a = sc.nextDouble();
                double b = sc.nextDouble();
                double c = sc.nextDouble();
                triangles.add(new Triangle(a, b, c));
                double k = triangles.getLast().getArea();
                DecimalFormat df = new DecimalFormat("#.##");
                df.setRoundingMode(RoundingMode.CEILING);
                System.out.println("A área do triângulo é: " + df.format(k));
            } else {
                int tam;
                for (Triangle triangle : triangles) {
                    double a = triangle.getArea();


                }
                System.out.println("Encerrando o programa...");
            }
        }
        }

    }

