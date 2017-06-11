package com.softserve.edu.task5;

public class App {

    public static void main(String[] args) {
      //  BigNumber num = new BigNumber();
     //   num = new BigNumber("");
     //   System.out.println(num.toString());
        if (args.length == 1) {
            BigNumber num = new BigNumber();
            try {
                num = new BigNumber(args[0]);
                System.out.println(num.toString());
            } catch (NumberFormatException e) {
                System.out.println("Wrong Format");
            } catch (IllegalArgumentException e) {
                System.out.println("The number is too large");
            }
        } else {
            System.out.println("Need one parameter");
        }

    }

}
