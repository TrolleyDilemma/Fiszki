package com.github.trolleydilemma;

import com.github.trolleydilemma.core.datastructures.TestData;
import com.github.trolleydilemma.core.util.XMLUtility;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.instanceOf;


/**
 * Unit test for XMLUtility class.
 * @author Krzysztof Berda
 */
public class XMLUtilityTest
{

    /**
     * fileLoadWithCorrectPathTest() check if method loadWords returns not empty list, if filepath is correct.
     */
    @Test
    public void fileLoadWithCorrectPathTest(){

        Assert.assertNotEquals(Collections.emptyList(), XMLUtility.loadWords(getClass().getResourceAsStream("/words.xml")));
    }
    /**
     * loadWordsReturnCorrectTypeTest() check if method loadWords return value with correct type.
     */
    @Test
    public void loadWordsReturnCorrectTypeTest(){
        Assert.assertThat(XMLUtility.loadWords(getClass().getResourceAsStream("/words.xml")),instanceOf(ArrayList.class));
    }
    /**
     * fileLoadWithWrongPathTest() check if method loadWords throw exception, if filepath is incorrect.
     */
    @Test(expected = Exception.class)
    public void fileLoadWitchWrongPathTest(){
        XMLUtility.loadWords(getClass().getResourceAsStream("/words2.xml"));
    }

}
