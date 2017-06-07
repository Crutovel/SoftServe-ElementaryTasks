package com.softserve.edu.task7;

public class App {

    public static void main(String[] args) {
        int n = 0;
        if (args.length != 1) {
            System.out.println("Need one argument");
        } else {
            try {
                n = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format, need Integer value");
                System.exit(2);
            }
            if (n <= 0) {
                System.out.println("Parameters must be greater than zero");
            } else {
                double max = (double) Math.sqrt(n);
                int trueMax = (int) max;
                if (max == (double) trueMax) {
                    trueMax--;
                }
                for (int i = 1; i < trueMax; i++) {
                    System.out.print(i + ",");
                }
                System.out.print(trueMax);
            }
        }
    }
}
