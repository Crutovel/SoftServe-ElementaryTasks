package com.softserve.edu.task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileStrFinder extends FileParser {

    private File file;

    public FileStrFinder(String filePath) {
        super(filePath);
        file = new File(filePath);
    }

    public int getOccurences(String str) throws FileNotFoundException, IOException {
        int occurences = 0;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            Pattern p = Pattern.compile(str);
            Matcher m = p.matcher(scanner.nextLine());
            while (m.find()) {
                occurences++;
            }
        }
        scanner.close();
        return occurences;
    }
}
