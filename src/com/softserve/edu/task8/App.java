package com.softserve.edu.task8;

public class App {

    public static void main(String[] args) {
        Fibonacci nums = new Fibonacci();
        switch (args.length) {
            case 1: {
                nums = new Fibonacci(getArg(args[0]));
                break;
            }
            case 2: {
                nums = new Fibonacci(getArg(args[0]), getArg(args[1]));
                break;
            }
            default: {
                System.out.println("There must be one or two parameters");
            }
        }
        System.out.println(nums.toString());
    }

    private static int getArg(String arg) {
        int result = 0;
        try {
            result = Integer.valueOf(arg);
        } catch (NumberFormatException e) {
            System.out.println("Wrong number format, need Integer value");
            System.exit(1);
        }
        if (result <= 0) {
            System.out.println("Parameters must be greater than zero and not greater than " + Integer.MAX_VALUE);
            System.exit(2);
        }
        return result;
    }

}
