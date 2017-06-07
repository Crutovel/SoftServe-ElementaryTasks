package com.softserve.edu.task1.test;

import com.softserve.edu.task1.ChessBoard;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ChessBoardTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObjectNegativeWidth_ExceptionThrown() {
        new ChessBoard("4", "-5");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObjectNegativeHeight_ExceptionThrown() {
        new ChessBoard("-5", "6");
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void createObjectWrongWidthFormat_ExceptionThrown() {
        new ChessBoard("10", "gt");
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void createObjectWrongHeightFormat_ExceptionThrown() {
        new ChessBoard("rew2", "6");
    }
    
    @Test
    public void checkChessBoardResult(){
        //Arrange
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        new ChessBoard("4", "12").printInStream(System.out);;
       
        String expected = new String("* * * * * * \r\n * * * * * *\r\n* * * * * * \r\n * * * * * *\r\n");
        //Act
        String actual = out.toString();
        //Assert
        Assert.assertEquals(actual, expected);
    }
}
