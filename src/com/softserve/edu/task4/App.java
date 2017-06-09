package com.softserve.edu.task4;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {

    public static void main(String[] args) {
        switch (args.length) {
            case 2: {
                FileStrFinder finder;
                try {
                    finder = new FileStrFinder(args[0]);
                    System.out.println("Occurences = " + finder.getOccurences(args[1]));
                } catch (FileNotFoundException g) {
                    System.out.println("File not found. Sad, but true");
                } catch (IOException e) {
                    System.out.println("Sry we have some problem. IOException");
                }
                break;
            }
            case 3: {
                try {
                    FileStrReplacer replacer = new FileStrReplacer(args[0]);
                    if (replacer.replace(args[1], args[2])) {
                        System.out.println("Done!");
                    }
                } catch (FileNotFoundException g) {
                    System.out.println("File not found. Sad, but true");
                } catch (IOException e) {
                    System.out.println("Sry we have some problem. IOException");
                }
                break;
            }
            default: {
                System.out.println("There must be two or three parameters");
            }
        }
    }
}
