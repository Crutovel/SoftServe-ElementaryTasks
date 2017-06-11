package com.softserve.edu.task6.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.task6.HappyTicketSearcher;

public class HappyTicketSearcherTest {
    
    @Test
    public void PiterAlgCheck(){
        //Arrange
        HappyTicketSearcher searcher = new HappyTicketSearcher();
        // Act
        int expected = 55252;
        int actual = searcher.getAllPiter();

        // Assert
        Assert.assertEquals(actual, expected);
    }
    
    @Test
    public void MoskowAlgCheck(){
        //Arrange
        HappyTicketSearcher searcher = new HappyTicketSearcher();
        // Act
        int expected = 55252;
        int actual = searcher.getAllMoskow();

        // Assert
        Assert.assertEquals(actual, expected);
    }
   
}
