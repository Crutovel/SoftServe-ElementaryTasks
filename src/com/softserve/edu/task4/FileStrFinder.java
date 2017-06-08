package com.softserve.edu.task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileStrFinder extends FileParser {

    private File file;

    public FileStrFinder(String filePath) {
        super(filePath);
        file = new File(filePath);
    }

    public int getOccurences(String str) throws FileNotFoundException {
        int occurences = 0;
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(str);
        while (scanner.hasNext()) {
            scanner.next();
            occurences++;
        }
        if (occurences != 0) {
            occurences--;
        }
        scanner.close();
        return occurences;
    }
}
