package com.softserve.edu.task1;

public class App {

    public static void main(final String[] args) {
        if (args.length != 2) {
            System.out.println("Need two arguments: [height], [width]");
        } else {
            try {
                ChessBoard brd = new ChessBoard(args[0], args[1]);
                brd.printInStream(System.out);
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format, need Integer value");
            } catch (IllegalArgumentException e) {
                System.out.println("Parameters must be greater than zero");
            }
        }
    }
}
