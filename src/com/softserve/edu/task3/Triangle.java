package com.softserve.edu.task3;

import java.util.Scanner;

public class Triangle {

    private static final double PRECISION = 0.000001;

    private String name;
    private double sides[];

    private double area;

    public double getArea() {
        return area;
    }

    public Triangle() {
        name = "null";
        sides = new double[3];
    }

    public Triangle(String name, double fSide, double sSide, double tSide) {
        this();
        this.name = name;
        if (!triangleSidesValidator(fSide, sSide, tSide)) {
            throw new IllegalArgumentException("Impossible sides");
        }
        sides[0] = fSide;
        sides[1] = sSide;
        sides[2] = tSide;
        area = calculateArea();
    }

    @Override
    public String toString() {
        return "[Triangle " + name + "]: " + String.format("%.2f", area) + " cm2";
    }

    public static Triangle valueOf(String input) {
        if (input == "") {
            throw new IllegalArgumentException("Empty String");
        }
        String name = "";
        double[] trSides = new double[3];
        String str = new String(input.toLowerCase());
        str = deleteSymbols(str, " ");
        str = deleteSymbols(str, "\t");

        String[] args = new String[4];

        Scanner scanner = new Scanner(input);

        scanner.useDelimiter(",");

        int count = 0;
        while (scanner.hasNext()) {
            args[count] = scanner.next();
            count++;
        }
        scanner.close();
        if (count != 4) {
            throw new IllegalArgumentException("Wrong Format");
        }

        name = args[0];
        trSides[0] = Double.valueOf(args[1]);
        trSides[1] = Double.valueOf(args[2]);
        trSides[2] = Double.valueOf(args[3]);

        return new Triangle(name, trSides[0], trSides[1], trSides[2]);
    }

    private static boolean triangleSidesValidator(double a, double b, double c) {
        if (a <= 0.0 || b <= 0.0 || c <= 0.0) {
            return false;
        }
        if (compareDoubles(c, (a + b)) != -1 || compareDoubles(a, c + b) != -1 || compareDoubles(b, a + c) != -1) {
            return false;
        }
        return true;
    }

    private static String deleteSymbols(String str, String symb) {
        StringBuilder temp = new StringBuilder(str);
        int index = 0;
        for (;;) {
            index = temp.indexOf(symb);
            if (index == -1) {
                break;
            } else {
                temp = temp.deleteCharAt(index);
            }
        }
        return temp.toString();
    }

    private double calculateArea() {
        double p = (sides[0] + sides[1] + sides[2]) / 2;
        return Math.sqrt(p * (p - sides[0]) * (p - sides[1]) * (p - sides[2]));
    }

    private static int compareDoubles(double a, double b) {
        double delta = a - b;
        if (delta > PRECISION) {
            return 1;
        } else {
            return delta < -PRECISION ? -1 : 0;
        }
    }
}
