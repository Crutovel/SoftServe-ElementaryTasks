package com.softserve.edu.task6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path to the file with algorithm");
        String path = scanner.next();
        scanner.close();
        HappyTicketSearcher searcher = new HappyTicketSearcher();
        String alg = "";
        File file = new File(path);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            alg = reader.readLine();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sry file not found");
        } catch (IOException e) {
            System.out.println("IO problem. Something went wrong");
        }
        switch (alg) {
            case "Moskow": {
                System.out.println("Moskow algorithm. Total happy tickets:  " + searcher.getAllMoskow());
                break;
            }
            case "Piter": {
                System.out.println("Piter algorithm. Total happy tickets: " + searcher.getAllPiter());
                break;
            }
            default: {
                System.out.println("There is no algorithm");
            }
        }
    }
}
