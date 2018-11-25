package com.github.trolleydilemma;

import com.github.trolleydilemma.core.util.FileUtility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *  This tests checks if  class FileUtility correctly create .json file.
 * @author Krzysztof Berda
 */
public class FileUtilityTest {
    /*
     * Save tests:
     */

    /**
     * saveTextFileStringContentTest check if creating file with string works correctly.
     * @throws FileNotFoundException
     */
    @Test
    public void saveTextFileStringContentTest()throws FileNotFoundException {
        File testFile = new File("./config/learned.json");
        String testString ="testString";
        FileUtility.saveTextFile(testFile,testString);
        Assert.assertEquals(testString.length(),testFile.length());
    }
    /**
     * saveTextFileListContentTest check if creating file with list works correctly.
     * @throws FileNotFoundException
     */
    @Test
    public void saveTextFileListContentTest()throws FileNotFoundException {
        File testFile = new File("./config/learned.json");
        List<String> testList = new ArrayList<String>();
        testList.add("testString");
        FileUtility.saveTextFile(testFile,testList);
        Assert.assertNotNull(testFile.length());
    }

    /**
     * saveTextFileFilePathTest check if creating file with filepath as File works correctly.
     * @throws FileNotFoundException
     */
    @Test
    public void saveTextFileFilePathTest()throws FileNotFoundException {
        File testFile = new File("./config/learned.json");
        FileUtility.saveTextFile(testFile,"testString");
        Assert.assertNotNull(testFile.length());
    }
    /**
     * saveTextFileStringPathTest check if creating file with filepath as String works correctly.
     * @throws FileNotFoundException
     */
    @Test
    public void saveTextFileStringPathTest()throws FileNotFoundException {
        FileUtility.saveTextFile("./config/learned.json","test");
        Assert.assertEquals(4,new File("./config/learned.json").length());
    }
    /*
     * Load Tests:
     */
    /**
     * createFile creates file needed in next tests.
     */
    @Before
    public void createFile() throws FileNotFoundException{
        File testFile = new File("./config/learned.json");
        FileUtility.saveTextFile("./config/learned.json","test");
    }

    /**
     * loadAsStringStringParamTest check if returned value is string, with filepath as string.
     * @throws IOException
     */
    @Test
    public void loadAsStringStringParamTest() throws IOException {
        Assert.assertThat(FileUtility.loadAsString("./config/learned.json"),instanceOf(String.class));
    }
    /**
     * loadAsStringFileParamTest check if returned value is string, with filepath as File.
     * @throws IOException
     */
    @Test
    public void loadAsStringFileParamTest() throws IOException {
        Assert.assertThat(FileUtility.loadAsString(new File("./config/learned.json")),instanceOf(String.class));
    }
    /**
     * loadAsListFileParamTest check if returned value is list, with filepath as File.
     * @throws IOException
     */
    @Test
    public void loadAsListFileParamTest() throws IOException {
        Assert.assertThat(FileUtility.loadAsList(new File("./config/learned.json")),instanceOf(List.class));
    }
    /**
     * loadAsStringStringParamTest check if returned value is list, with filepath as string.
     * @throws IOException
     */
    @Test
    public void loadAsListStringParamTest() throws IOException {
        Assert.assertThat(FileUtility.loadAsList("./config/learned.json"),instanceOf(List.class));
    }
    /**
     * loadAsListInputStreamParamTest check if returned value is list, with filepath as input stream.
     * @throws IOException
     */
    @Test
    public void loadAsListInputStreamParamTest() throws IOException {

        Assert.assertThat(FileUtility.loadAsList(getClass().getResourceAsStream("/words.xml")),instanceOf(List.class));
    }

}
