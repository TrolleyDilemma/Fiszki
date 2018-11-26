package com.github.trolleydilemma;

//import com.github.trolleydilemma.core.Word;
import com.github.trolleydilemma.core.datastructures.TestData;
import com.github.trolleydilemma.core.datastructures.Word;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;


/**
 * Unit test for Word class.
 * @author Krzysztof Berda
 */
public class WordTest
{

    @Test
    public void constructorTest(){

        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level");
        Assert.assertNotNull(word1);
    }
    @Test
    public void getIdTest(){
        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level");
        Assert.assertNotNull(word1.getId());
    }
    @Test
    public void getEnglishTest(){
        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level");
        Assert.assertNotNull(word1.getEnglish());
    }
    @Test
    public void getJapaneseTest(){
        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level");
        Assert.assertNotNull(word1.getJapanese());
    }
    @Test
    public void getLevelTest(){
        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level");
        Assert.assertNotNull(word1.getLevel());
    }
    @Test
    public void getNoteTest(){
        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level");
        Assert.assertNotNull(word1.getNote());
    }
    @Test
    public void getEnglishCorrectReturnTest(){
        List<String> testList = new ArrayList<>();
        testList.add("Test_String");
        Word word1 = new Word(new Integer(1),testList,new ArrayList<>(), "Level");
        Assert.assertEquals(testList,word1.getEnglish());
    }
    @Test
    public void getJapaneseCorrectReturnTest(){
        List<String> testList = new ArrayList<>();
        testList.add("Test_String");
        Word word1 = new Word(new Integer(1),new ArrayList<>(),testList, "Level");
        Assert.assertEquals(testList,word1.getJapanese());
    }
    @Test
    public void getLevelCorrectReturnTest(){

        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level");
        Assert.assertEquals("Level",word1.getLevel());
    }
    @Test
    public void getIdCorrectReturnTest(){

        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level");
        Assert.assertEquals(1,word1.getId());
    }
    @Test
    public void getNoteReturnWithEmptyConstructorTest(){

        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level");
        Assert.assertEquals("",word1.getNote());
    }
    @Test
    public void getNoteReturnTest(){

        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level","Note");
        Assert.assertEquals("Note",word1.getNote());
    }
    @Test
    public void isLearnedNotNullTest(){

        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level","Note");
        Assert.assertNotNull(word1.isLearned());
    }
    @Test
    public void isLearnedDefaultTest(){

        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level","Note");
        Assert.assertFalse(word1.isLearned());
    }
    @Test
    public void isLearnedSetTrueTest(){

        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level","Note");
        word1.setLearned(true);
        Assert.assertTrue(word1.isLearned());
    }
    @Test
    public void isLearnedSetFalseTest(){

        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level","Note");
        word1.setLearned(false);
        Assert.assertFalse(word1.isLearned());
    }
    @Test
    public void toStringNotNullTest(){

        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level","Note");
        Assert.assertNotNull(word1.toString());
    }
    @Test
    public void toStringTest(){

        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level","Note");
        Assert.assertEquals("Word #1",word1.toString());
    }

    /**
     *  Tests for correct type's of returned values:
     */
    @Test
    public void toStringReturnCorrectTypeTest(){
        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level","Note");
        Assert.assertThat(word1.toString(),instanceOf(String.class));
    }
    @Test
    public void getIdReturnCorrectTypeTest(){
        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level","Note");
        Assert.assertThat(word1.getId(),instanceOf(Integer.class));
    }
    @Test
    public void getEnglishReturnCorrectTypeTest(){
        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level","Note");
        Assert.assertThat(word1.getEnglish(),instanceOf(ArrayList.class));
    }
    @Test
    public void getJapaneseReturnCorrectTypeTest(){
        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level","Note");
        Assert.assertThat(word1.getJapanese(),instanceOf(ArrayList.class));
    }
    @Test
    public void getLevelReturnCorrectTypeTest(){
        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level","Note");
        Assert.assertThat(word1.getLevel(),instanceOf(String.class));
    }
    @Test
    public void getNoteReturnCorrectTypeTest(){
        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level","Note");
        Assert.assertThat(word1.getNote(),instanceOf(String.class));
    }
    @Test
    public void isLearnedReturnCorrectTypeTest(){
        Word word1 = new Word(new Integer(1),new ArrayList<>(),new ArrayList<>(), "Level","Note");
        Assert.assertThat(word1.isLearned(),instanceOf(Boolean.class));
    }
}
