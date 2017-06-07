package com.softserve.edu.task1;

import java.io.PrintStream;

public class ChessBoard {
    private int height;
    private int width;

    public ChessBoard(String hght, String wdth) {
        height = Integer.valueOf(hght);
        width = Integer.valueOf(wdth);
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public void printInStream(PrintStream out) {
        for (int i = 0; i < height; i++) {
            for (int k = 0; k < width; k++) {
                if ((k + i) % 2 == 0) {
                    out.print("*");
                } else {
                    out.print(" ");
                }
            }
            out.println();
        }
    }
}
