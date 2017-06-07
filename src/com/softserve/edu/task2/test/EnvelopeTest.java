package com.softserve.edu.task2.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.task2.Envelope;

public class EnvelopeTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObjectNegativeWidth_ExceptionThrown() {
        new Envelope("4", "-5");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObjectNegativeHeight_ExceptionThrown() {
        new Envelope("-5", "6");
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void createObjectWrongWidthFormat_ExceptionThrown() {
        new Envelope("10", "gt");
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void createObjectWrongHeightFormat_ExceptionThrown() {
        new Envelope("rew2", "6");
    }

    @Test
    public void compareEnvelopes_FirstIsBiggerThanSecond_ResultGot() {
        // Arrange
        Envelope first = new Envelope("5.6", "5.5");
        Envelope second = new Envelope("2.6", "2.5");

        // Act
        int expected = 1;
        int actual = first.compare(second);

        // Assert
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void compareEnvelopes_FirstIsSmallerThanSecond_ResultGot() {
        // Arrange
        Envelope first = new Envelope("1.6", "1.5");
        Envelope second = new Envelope("55.6", "44.5");

        // Act
        int expected = -1;
        int actual = first.compare(second);

        // Assert
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void cantPutOneInAntoherEnvelope() {
        // Arrange
        Envelope first = new Envelope("44.6", "1.5");
        Envelope second = new Envelope("33.6", "44.5");

        // Act
        int expected = 0;
        int actual = first.compare(second);

        // Assert
        Assert.assertEquals(actual, expected);
    }
}
