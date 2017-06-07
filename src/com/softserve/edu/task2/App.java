package com.softserve.edu.task2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        String confirm = "";
        String width = "";
        String height = "";
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        while (!exit) {
            try {
                System.out.println("Enter a: ");
                width = scanner.next();
                System.out.println("Enter b: ");
                height = scanner.next();
                Envelope first = new Envelope(width, height);
                System.out.println("Enter c: ");
                width = scanner.next();
                System.out.println("Enter d: ");
                height = scanner.next();
                Envelope second = new Envelope(width, height);
                if (first.compare(second) != 0) {
                    System.out.println("Possible");
                } else {
                    System.out.println("Impossible");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format");
            } catch (IllegalArgumentException e) {
                System.out.println("Numbers must be greater than zero");
            }
            System.out.println("Do you want to continue?");
            confirm = scanner.next();
            confirm = confirm.toLowerCase();
            switch (confirm) {
                case "y": {
                    break;
                }
                case "yes": {
                    break;
                }
                default: {
                    System.out.println("bb");
                    exit = true;
                    scanner.close();
                }
            }
        }
    }
}
