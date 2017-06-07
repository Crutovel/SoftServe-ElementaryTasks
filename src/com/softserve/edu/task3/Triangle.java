package com.softserve.edu.task3;

public class Triangle {
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
            throw new IllegalArgumentException();
        }
        sides[0] = fSide;
        sides[1] = sSide;
        sides[2] = tSide;
        area = calculateArea();
    }

    @Override
    public String toString() {
        return "[Triangle " + name + "]: " + String.format("%.2f", area) + " cm";
    }

    public static Triangle valueOf(String input) {
        String name = "";
        double[] trSides = new double[3];
        String str = new String(input.toLowerCase());
        str = deleteSymbols(str, " ");
        str = deleteSymbols(str, "\t");
        int index = 0;
        int commaChecker;
        for (commaChecker = 0; index != -1; commaChecker++) {
            index = str.indexOf(",");
            if (commaChecker == 0) {
                if (index == 0) {
                    throw new IllegalArgumentException();
                } else {
                    name = str.substring(0, index);
                }
            }
            if (commaChecker == 1) {
                trSides[0] = Double.valueOf(str.substring(0, index));
            }
            if (commaChecker == 2) {
                trSides[1] = Double.valueOf(str.substring(0, index));
                trSides[2] = Double.valueOf(str.substring(index + 1, str.length()));
            }
            str = str.substring(index + 1, str.length());
        }
        if (commaChecker != 4) {
            throw new IllegalArgumentException();
        }
        return new Triangle(name, trSides[0], trSides[1], trSides[2]);
    }

    private static boolean triangleSidesValidator(double a, double b, double c) {
        if (a <= 0.0 || b <= 0.0 || c <= 0.0 || a + b < c || c + b < a || a + c < b) {
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
}
