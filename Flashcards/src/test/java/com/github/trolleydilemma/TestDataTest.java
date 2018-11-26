package com.github.trolleydilemma;

import com.github.trolleydilemma.core.datastructures.TestData;
import com.github.trolleydilemma.core.datastructures.Word;
import com.github.trolleydilemma.core.util.XMLUtility;
import org.junit.Assert;
import org.junit.Test;
import org.hamcrest.core.IsInstanceOf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Unit test for TestData class.
 * @author Krzysztof Berda
 */
public class TestDataTest {
    /**
     * TestDataTest check if constructor create object.
     */
    @Test
    public void TestDataTest(){
        TestData test = new TestData(new ArrayList<>(), 1);
        Assert.assertNotNull(test);
    }
    /**
     * getWordsNotNullReturnTest check if getWords method return not null value.
     */
    @Test
    public void getWordsNotNullReturnTest(){
        TestData test = new TestData(new ArrayList<>(), 1);
        Assert.assertNotNull(test.getWords());
    }
    /**
     * getWordsReturnCorrectTypeTest check if getWords method return value as list.
     */
    @Test
    public void getWordsReturnCorrectTypeTest(){
        TestData test = new TestData(new ArrayList<>(), 1);
        Assert.assertThat(test.getWords(),instanceOf(ArrayList.class));
    }
    /**
     * getMainWordIdNotNullReturnTest check if getMainWordId method return not null value.
     */
    @Test
    public void getMainWordIdNotNullReturnTest(){
        TestData test = new TestData(new ArrayList<>(), 1);
        Assert.assertNotNull(test.getMainWordId());
    }
    /**
     * getMainWordIdReturnCorrectTypeTest check if getMainWordId method return value as Integer.
     */
    @Test
    public void getMainWordIdReturnCorrectTypeTest(){
        TestData test = new TestData(new ArrayList<>(), 1);
        Assert.assertThat(test.getMainWordId(),instanceOf(Integer.class));
    }
    /**
     * getWordsCorrectSizeOfReturnListTest check if getWords method return correct number of elements from list.
     */
    @Test
    public void getWordsCorrectSizeOfReturnListTest(){
        List<Word> list1 = XMLUtility.loadWords(getClass().getResourceAsStream("/words.xml"));
        List<Word> list2 = XMLUtility.loadWords(getClass().getResourceAsStream("/words.xml"));
        TestData data1 = new TestData(list1, 1);
        Assert.assertEquals(list2.size(),data1.getWords().size());
    }
    /**
     * getMainWordIdCorrectReturnTest check if getMainWordId method return correct value.
     */
    @Test
    public void getMainWordIdCorrectReturnTest(){
        List<Word> list1 = XMLUtility.loadWords(getClass().getResourceAsStream("/words.xml"));
        List<Word> list2 = XMLUtility.loadWords(getClass().getResourceAsStream("/words.xml"));
        TestData data1 = new TestData(list1, 1);
        Assert.assertEquals(list2.get(1).getId(),data1.getMainWordId());
    }
}
