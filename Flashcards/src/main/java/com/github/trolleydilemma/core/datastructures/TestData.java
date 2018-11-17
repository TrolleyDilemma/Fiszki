package com.github.trolleydilemma.core.datastructures;

import java.util.List;

/**
 * Storage class for test data. It contains 4 words in List and id of main Word.
 * Main Word means Word that is displayed in test module, and user is asked for correct info about it.
 * @author Michal Glogowski
 */
public class TestData {
    /**
     * Constructor for TestData class
     * @param words List full of words. One of them is mainWord. It is pointed by second argument.
     * @param mainWordId "Pointer" to mainWord
     */
    public TestData(List<Word> words, int mainWordId) {
        this.words = words;
        this.mainWordId = mainWordId;
    }

    public List<Word> getWords() { return words; }
    public int getMainWordId() { return mainWordId; }

    private List<Word> words;
    private int mainWordId;
}
