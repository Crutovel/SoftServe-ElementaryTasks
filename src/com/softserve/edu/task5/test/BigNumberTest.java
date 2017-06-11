package com.softserve.edu.task5.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.task5.BigNumber;

public class BigNumberTest {
    @Test(expectedExceptions = NumberFormatException.class)
    public void createObjectWrongFormat_ExceptionThrown() {
        new BigNumber("10000s00001");
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void createObjectWrongFormatWithSpaces_ExceptionThrown() {
        new BigNumber(" 23333");
    }
    
    @Test(expectedExceptions = NumberFormatException.class)
    public void createObjectWrongFormatWithMinus_ExceptionThrown() {
        new BigNumber("2-3333");
    }

    @Test
    public void BigNumberToStringCheck() {
        // Arrange
        BigNumber bg = new BigNumber("1000000");
        String expected = "один миллион ";
        
        // Act
        String actual = bg.toString();

        // Assert
        Assert.assertEquals(actual, expected);
    }
    
    @Test
    public void BigNumberToStringCheckWithMinus() {
        // Arrange
        BigNumber bg = new BigNumber("-1000000");
        String expected = "минус один миллион ";
        
        // Act
        String actual = bg.toString();

        // Assert
        Assert.assertEquals(actual, expected);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObjectWithTooLargeNumber_ExceptionThrown() {
        StringBuilder str = new StringBuilder("1");
        for(int i = 1; i<100;i++){
            str.append("1");
        }
        new BigNumber(str.toString()).toString();
    }
    
}
