package com.softserve.edu.task2;

public class Envelope {

    private static final double PRECISION = 0.000001;
    private double w;
    private double h;

    public Envelope(String width, String height) {
        w = Double.valueOf(width);
        h = Double.valueOf(height);

        if (compareDoubles(w, 0.0d) != 1 || compareDoubles(h, 0.0d) != 1) {
            throw new IllegalArgumentException("Arguments must be greater than zero");
        }
    }

    public int compare(Envelope envlp) {
        double minSide1 = this.getMinSide();
        double minSide2 = envlp.getMinSide();
        double maxSide1 = this.getMaxSide();
        double maxSide2 = envlp.getMaxSide();

        if (compareDoubles(maxSide1, maxSide2) == 1 && compareDoubles(minSide1, minSide2) == 1) {
            return 1;
        }
        if (compareDoubles(maxSide1, maxSide2) == -1 && compareDoubles(minSide1, minSide2) == -1) {
            return -1;
        }
        return 0;
    }

    private static int compareDoubles(double a, double b) {
        double delta = a - b;
        if (delta > PRECISION) {
            return 1;
        } else {
            return delta < -PRECISION ? -1 : 0;
        }
    }

    private double getMinSide() {
        return compareDoubles(w, h) == 1 ? h : w;
    }

    private double getMaxSide() {
        return compareDoubles(w, h) == -1 ? h : w;
    }

}
