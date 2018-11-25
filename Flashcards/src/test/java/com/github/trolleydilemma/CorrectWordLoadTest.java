package com.github.trolleydilemma;

import com.github.trolleydilemma.core.datastructures.Word;
import com.github.trolleydilemma.core.util.XMLUtility;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import java.util.List;


/**
 * Tests check if method loadWords correctly load data from XML file
 * @author Krzysztof Berda
 */
public class CorrectWordLoadTest {

    String XMLPath = "/words.xml";
    /**
     *  correctNumberOfElementsTest check if method loadWords() load correct number of words.
     */
    @Test
    public void correctNumberOfElementsTest(){
        List<Word> list = XMLUtility.loadWords(getClass().getResourceAsStream(XMLPath));
        Assert.assertEquals("Created incorrect number of elements",680,list.size());
    }
    /**
     * idExistanceInEveryWordTest check if every loaded word contains id.
     */
    @Test
    public void idExistanceInEveryWordTest(){
        List<Word> list = XMLUtility.loadWords(getClass().getResourceAsStream(XMLPath));
        for(int temp=0;temp < list.size();temp++){
            Assert.assertNotNull("Id not found in word #"+temp,list.get(temp).getId());
        }
    }

    /**
     * levelExistanceInEveryWordTest check if every loaded word contains not null value in Level field.
     */
    @Test
    public void levelExistanceInEveryWordTest(){
        List<Word> list = XMLUtility.loadWords(getClass().getResourceAsStream(XMLPath));
        for(int temp=0;temp < list.size();temp++){
            Assert.assertNotNull("Level not found in word #"+temp,list.get(temp).getLevel());
        }
    }
    /**
     * JapaneseListAtleastOneElementInEveryWordTest check if every loaded word contains at least one element in
     * japanese list.
     */
    @Test
    public void JapaneseListAtleastOneElementInEveryWordTest(){
        List<Word> list = XMLUtility.loadWords(getClass().getResourceAsStream(XMLPath));
        for(int temp=0;temp < list.size();temp++){
            Assert.assertNotNull("Japanese word not found in word #"+temp,list.get(temp).getJapanese().get(0));
        }
    }

    /**
     * EnglishListAtleastOneElementInEveryWordTest check if every loaded word contains at least one element in
     * english list.
     */
    @Test
    public void EnglishListAtleastOneElementInEveryWordTest(){
        List<Word> list = XMLUtility.loadWords(getClass().getResourceAsStream(XMLPath));
        for(int temp=0;temp < list.size();temp++){
            Assert.assertNotNull("English word not found in word #"+temp,list.get(temp).getEnglish().get(0));
        }
    }/**
     *  learnedDefaultSetOnFalseTest check if word is loaded with values: false of field learned.
     */
    @Test
    public void learnedDefaultSetOnFalseTest(){
        List<Word> list = XMLUtility.loadWords(getClass().getResourceAsStream(XMLPath));
        for(int temp=0;temp < list.size();temp++){
            Assert.assertEquals("Incorrect field learned status.",false,list.get(temp).isLearned());
        }
    }

    /**
     * levelEasyOrMediumOrHardTest check if Level of word belongs to values: Easy, Medium, Hard.
     */
    @Test
    public void levelEasyOrMediumOrHardTest(){
        List<Word> list = XMLUtility.loadWords(getClass().getResourceAsStream(XMLPath));
        for(int temp=0;temp < list.size();temp++){
            Assert.assertThat("Incorrect level type in word #"+temp, list.get(temp).getLevel(),anyOf(containsString("Easy"), containsString("Medium"),containsString("Hard")));
        }
    }


}
