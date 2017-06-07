package com.softserve.edu.task8;

import java.math.BigInteger;

public class Matrix {

    public static final int ROWS = 2;
    public static final int COLS = 2;
    public static Matrix one;

    static {
        one = new Matrix();
        one.set(0, 0, BigInteger.ZERO);
        one.set(0, 1, BigInteger.ONE);
        one.set(1, 0, BigInteger.ONE);
        one.set(1, 1, BigInteger.ONE);
    }

    private BigInteger[][] values;

    public Matrix() {
        values = new BigInteger[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int k = 0; k < COLS; k++) {
                values[i][k] = BigInteger.ZERO;
            }
        }
    }

    public BigInteger get(int row, int col) {
        if (row < 0 || col < 0 || row > ROWS - 1 || col > COLS - 1) {
            throw new IllegalArgumentException();
        }
        return values[row][col];
    }

    public void set(int row, int col, BigInteger value) {
        if (row < 0 || col < 0 || row > ROWS - 1 || col > COLS - 1) {
            throw new IllegalArgumentException();
        }
        values[row][col] = value;
    }

    public Matrix multiply(Matrix m) {
        Matrix result = new Matrix();
        result.values[0][0] = values[0][0].multiply(m.values[0][0]).add(values[0][1].multiply(m.values[1][0]));
        result.values[0][1] = values[0][0].multiply(m.values[0][1]).add(values[0][1].multiply(m.values[1][1]));
        result.values[1][0] = values[1][0].multiply(m.values[0][0]).add(values[1][1].multiply(m.values[1][0]));
        result.values[1][1] = values[1][0].multiply(m.values[0][1]).add(values[1][1].multiply(m.values[1][1]));

        return result;
    }

    public Matrix pow(int exp) {
        if (exp == 0) {
            return one;
        }
        if (exp == 1) {
            return this;
        }
        if (exp == 2) {
            return multiply(this);
        }
        if (exp % 2 == 1) {
            return one.multiply(pow(exp - 1));
        }
        return pow(2).pow(exp / 2);
    }

}
