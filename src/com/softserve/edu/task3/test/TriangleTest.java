package com.softserve.edu.task3.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.task3.Triangle;


public class TriangleTest {
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void TriangleValueOfOneComma_ExceptionThrown() {
        Triangle.valueOf("3,2");
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void TriangleValueOfTwoComma_ExceptionThrown() {
        Triangle.valueOf("4,6,6");
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void TriangleValueOfEmptyString_ExceptionThrown() {
        Triangle.valueOf("");
    }
    
    @Test
    public void TriangleValueOfSuccess_ExceptionNotThrown() {
        Triangle.valueOf("triangle,2,3,4");
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void TriangleIncorrectSides_ExceptionThrown() {
        Triangle.valueOf("triangle,2,2,42");
    }
    
    @Test
    public void TriangleCheckGeronCalculation() {
        double expected = 6.49519052838329;
        double actual = Triangle.valueOf("triangle,3,5,7").getArea();
        Assert.assertEquals(actual, expected);
    }
    
    
}
