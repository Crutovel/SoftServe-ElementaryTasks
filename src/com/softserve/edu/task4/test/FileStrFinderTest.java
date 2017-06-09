package com.softserve.edu.task4.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.task4.FileStrFinder;

public class FileStrFinderTest {

    @Test(expectedExceptions = FileNotFoundException.class)
    public void createObjectEmptyPathAndGetOccurences_ExceptionThrown() throws FileNotFoundException, IOException {
        new FileStrFinder("").getOccurences("some_string");
    }

    @Test
    public void checkGetOccurencesMethodResultNotZero() throws FileNotFoundException, IOException {
        int actual = getOccurencesFakeMethod("Test");
        int expected = 2;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void checkGetOccurencesMethodResultZero() throws FileNotFoundException, IOException {
        int actual = getOccurencesFakeMethod("Nothing");
        int expected = 0;
        Assert.assertEquals(actual, expected);
    }

    public int getOccurencesFakeMethod(String str) {
        Scanner scanner = new Scanner("Test or not to Test?");
        int occurences = 0;
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
