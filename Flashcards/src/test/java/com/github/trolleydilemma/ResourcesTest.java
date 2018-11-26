package com.github.trolleydilemma;
import org.junit.Assert;
import org.junit.Test;



/**
 * Tests check if needed resources exists
 * @author Krzysztof Berda
 */
public class ResourcesTest {
    @Test
    public void BackExistenceTest(){
        String fileName = "/images/Back.png";
        Assert.assertNotNull("File: "+fileName+" not found",getClass().getResource(fileName));
    }
    @Test
    public void CheckBoxSelectedExistenceTest(){
        String fileName = "/images/CheckBoxSelected.png";
        Assert.assertNotNull("File: "+fileName+" not found",getClass().getResource(fileName));
    }
    @Test
    public void ListIconExistenceTest(){
        String fileName = "/images/ListIcon.png";
        Assert.assertNotNull("File: "+fileName+" not found",getClass().getResource(fileName));
    }
    @Test
    public void LogiIconExistenceTest(){
        String fileName = "/images/LogiIcon.png";
        Assert.assertNotNull("File: "+fileName+" not found",getClass().getResource(fileName));
    }
    @Test
    public void NextExistenceTest(){
        String fileName = "/images/Next.png";
        Assert.assertNotNull("File: "+fileName+" not found",getClass().getResource(fileName));
    }
    @Test
    public void RollExistenceTest(){
        String fileName = "/images/Roll.png";
        Assert.assertNotNull("File: "+fileName+" not found",getClass().getResource(fileName));
    }
    @Test
    public void StatisticIconExistenceTest(){
        String fileName = "/images/StatisticIcon.png";
        Assert.assertNotNull("File: "+fileName+" not found",getClass().getResource(fileName));
    }
    @Test
    public void TestIconExistenceTest(){
        String fileName = "/images/TestIcon.png";
        Assert.assertNotNull("File: "+fileName+" not found",getClass().getResource(fileName));
    }
    @Test
    public void FlashcardIconExistenceTest(){
        String fileName = "/images/FlashcardIcon.png";
        Assert.assertNotNull("File: "+fileName+" not found",getClass().getResource(fileName));
    }
    @Test
    public void wordsExistenceTest(){
        String fileName = "/words.xml";
        Assert.assertNotNull("File: "+fileName+" not found",getClass().getResource(fileName));
    }
}
