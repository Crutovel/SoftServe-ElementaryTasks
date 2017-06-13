package com.softserve.edu.task8.test;

import java.math.BigInteger;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.task8.Fibonacci;

public class FibonacciTest {
    private Fibonacci nums;
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObjectNegativeArg_ExceptionThrown() {
        new Fibonacci(-5);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObjectWrongArgs_ExceptionThrown() {
        new Fibonacci(5,3);
    }

    @Test
    public void createObjectNegativeHeight_ExceptionThrown() {
        // Arrange
        nums = new Fibonacci(22);
        // Act
        BigInteger actual = nums.getNumbers()[0];
        BigInteger expected = new BigInteger("2584");
        // Assert
        Assert.assertEquals(actual, expected);
    }
}
