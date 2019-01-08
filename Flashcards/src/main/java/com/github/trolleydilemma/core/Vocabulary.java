package com.github.trolleydilemma.core;

import com.github.trolleydilemma.core.datastructures.TestData;
import com.github.trolleydilemma.core.datastructures.Word;
import com.github.trolleydilemma.core.enums.VocabularyLevel;
import com.github.trolleydilemma.core.enums.VocabularyType;
import com.github.trolleydilemma.core.exceptions.OutOfWordsException;
import com.github.trolleydilemma.core.util.FileUtility;
import com.github.trolleydilemma.core.util.XMLUtility;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Main logic module of program. It contains the majority of methods to work with Vocabulary, which is also stored in this class.
 * @author Michal Glogowski
 */
public class Vocabulary {

    /**
     * Constructor which loads vocabulary from XML file and progress of learning from JSON file
     */
    public Vocabulary() {
        allVocabulary = XMLUtility.loadWords(getClass().getResourceAsStream("/words.xml"));
        random = new Random();
        learnedJson = new File("./config/learned.json");
        if(!learnedJson.exists())
            learnedJson.getParentFile().mkdirs();

        loadProgress();

        knownVocabulary = new ArrayList<>();
        unknownVocabulary = new ArrayList<>();

        filterVocabulary();
    }

    /**
     * Method responsible for filtering vocabulary.
     * It creates two new Lists of Words (knownVocabulary and unknownVocabulary).
     * Method have to be used after change of learn flag in any Word
     */
    public void filterVocabulary() {
        knownVocabulary = allVocabulary.stream().filter(word -> word.isLearned()).collect(Collectors.toList());
        unknownVocabulary = allVocabulary.stream().filter(word -> !word.isLearned()).collect(Collectors.toList());
    }

    /**
     * Getter returning vocabulary list of chosen type
     * @param type type of vocabulary (ALL, KNOWN, UNKNOWN)
     * @return list with Words of specified type
     */
    public List<Word> get(VocabularyType type) {
        switch(type) {
            case ALL: return allVocabulary;
            case KNOWN: return knownVocabulary;
            case UNKNOWN: return unknownVocabulary;
            default: return null;
        }
    }

    /**
     * Method responsible for getting a random Word from selected type of collection.
     * Used when drawing for "flashcard" panel due to save of additional information (history of draw).
     * @param type type of vocabulary (ALL, KNOWN, UNKNOWN)
     * @return random Word from selected type of collection
     * @exception OutOfWordsException thrown when list is empty
     */
    public Word draw(VocabularyType type) throws OutOfWordsException {
        switch(type) {
            case ALL: return internalDraw(allVocabulary,allDrawn,allDrawnListIterator);
            case KNOWN: return internalDraw(knownVocabulary,knownDrawn,knownDrawnListIterator);
            case UNKNOWN: return internalDraw(unknownVocabulary,unknownDrawn,unknownDrawnListIterator);
            default: return null;
        }
    }

    /**
     * Draw from vocabulary list, add selected object to drawnVocabulary List and increment iterator
     * @param vocabulary List from which will be drawn element
     * @param drawnVocabulary List to which the element will be added
     * @param iterator iterator attached to drawnVocabulary List
     * @return randomly selected Word from vocabulary excluding drawnVocabulary collection
     * @exception OutOfWordsException thrown when list is empty
     */
    private Word internalDraw(List<Word> vocabulary, List<Word> drawnVocabulary, MyListIterator iterator) throws OutOfWordsException {
        List<Word> toDraw = new ArrayList<>();

        //Draw from newly created collection (vocabulary - drawnVocabulary)
        Collections.addAll(toDraw, vocabulary.toArray(new Word[0]));
        toDraw.removeAll(drawnVocabulary);

        Word word;
        try {
            word = toDraw.get(random.nextInt(toDraw.size()));
        } catch (IllegalArgumentException e) {
            throw new OutOfWordsException();
        }

        //Add to drawn collection and set iterator on last possible position
        drawnVocabulary.add(word);
        iterator.setIteratorOnLastPosition();
        return word;
    }

    /**
     * Get Word drawn before the last draw. Used in buttons in "flashcard" panel
     * @param type type of vocabulary (ALL, KNOWN, UNKNOWN)
     * @return Word drawn before last draw
     */
    public Word back(VocabularyType type) {
        switch(type) {
            case ALL:
                allDrawnListIterator.decrement();
                return (Word)allDrawnListIterator.getObject();
            case KNOWN:
                knownDrawnListIterator.decrement();
                return (Word)knownDrawnListIterator.getObject();
            case UNKNOWN:
                unknownDrawnListIterator.decrement();
                return (Word)unknownDrawnListIterator.getObject();
            default: return null;
        }
    }

    /**
     * Get Word that has been drawn after the current selected Word. Used in "flashcard" panel
     * @param type type of vocabulary (ALL, KNOWN, UNKNOWN)
     * @return Word that has been drawn after the current selected Word
     */
    public Word next(VocabularyType type) {
        switch(type) {
            case ALL:
                allDrawnListIterator.increment();
                return (Word)allDrawnListIterator.getObject();
            case KNOWN:
                knownDrawnListIterator.increment();
                return (Word)knownDrawnListIterator.getObject();
            case UNKNOWN:
                unknownDrawnListIterator.increment();
                return (Word)unknownDrawnListIterator.getObject();
            default: return null;
        }
    }

    /**
     * Method responsible for getting random Words from selected type of collection.
     * Used when drawing for ChooseOneTest panel.
     * @param type type of vocabulary (ALL, KNOWN, UNKNOWN)
     * @return TestData containing 4 words - one of them is mainWord.
     * @exception OutOfWordsException thrown when list is too small to draw all needed vocabulary
     */
    public TestData drawForChooseOneTest(VocabularyType type) throws OutOfWordsException {

        List<Word> toDraw = new ArrayList<>();
        Collections.addAll(toDraw, allVocabulary.toArray(new Word[0]));
        List<Word> list = new ArrayList<>();

        switch(type) {
            case ALL:
                //Draw 4 random words
                for(int i=0; i<4; i++) {
                    Word next = toDraw.remove(random.nextInt(toDraw.size()));
                    list.add(next);
                }

                return new TestData(list, random.nextInt(4));
            case KNOWN: {
                Word main;
                try {
                    main = knownVocabulary.get(random.nextInt(knownVocabulary.size()));
                } catch (IllegalArgumentException e) {
                    throw new OutOfWordsException();
                }

                //Draw 3 random words
                for(int i=0; i<3; i++) {
                    Word next = toDraw.remove(random.nextInt(toDraw.size()));
                    list.add(next);
                }

                int id = random.nextInt(4);
                list.add(id,main);
                return new TestData(list,id);
            }
            case UNKNOWN: {
                Word main;
                try {
                    main = unknownVocabulary.get(random.nextInt(unknownVocabulary.size()));
                } catch (IllegalArgumentException e) {
                    throw new OutOfWordsException();
                }

                //Draw 3 random words
                for(int i=0; i<3; i++) {
                    Word next = toDraw.remove(random.nextInt(toDraw.size()));
                    list.add(next);
                }

                int id = random.nextInt(4);
                list.add(id,main);
                return new TestData(list,id);
            }
            default: return null;
        }
    }

    /**
     * Method responsible for getting random Words from selected type of collection.
     * Used when drawing for InputTest panel.
     * @param type type of vocabulary (ALL, KNOWN, UNKNOWN)
     * @param amountOfWords amount of words to draw
     * @return TestData containing words for test
     * @exception OutOfWordsException thrown when list is too small to draw all needed vocabulary
     */
    public TestData drawForInputTest(VocabularyType type, int amountOfWords) throws OutOfWordsException {
        switch(type) {
            case ALL: return drawForInputTest(allVocabulary, amountOfWords);
            case KNOWN: return drawForInputTest(knownVocabulary, amountOfWords);
            case UNKNOWN: return drawForInputTest(unknownVocabulary, amountOfWords);
            default: return null;
        }
    }

    /**
     * Method responsible for getting random Words from specified list of Words.
     * @param listOfWords list from which words will be drawn
     * @param amountOfWords amount of words to draw
     * @return TestData containing words for test
     * @throws OutOfWordsException thrown when list is too small to draw all needed vocabulary
     */
    private TestData drawForInputTest(List<Word> listOfWords, int amountOfWords) throws OutOfWordsException {
        List<Word> toDraw = new ArrayList<>();
        List<Word> list = new ArrayList<>();
        Word next;

        Collections.addAll(toDraw, listOfWords.toArray(new Word[0]));

        for (int i=0; i<amountOfWords; i++) {
            try {
                next = toDraw.remove(random.nextInt(toDraw.size()));
                list.add(next);
            } catch (IllegalArgumentException e) {
                throw new OutOfWordsException();
            }
        }

        return new TestData(list,0);
    }

    /**
     * Load information about learning state of vocabulary from external file
     */
    private void loadProgress() {
        try {
            String jsonContent = FileUtility.loadAsString(learnedJson);
            JSONObject jsonObject = new JSONObject(jsonContent);
            int keySetSize = jsonObject.keySet().size();

            for(int i=0; i<keySetSize; i++) {
                boolean learned = jsonObject.getBoolean(Integer.toString(i));
                allVocabulary.get(i).setLearned(learned);
            }

        } catch (IOException e) {}      //File not found, probably first run of an application
    }

    /**
     * Save information about the progress of learning the vocabulary
     */
    public void saveProgress() {
        JSONStringer stringer = new JSONStringer();
        stringer.object();
        allVocabulary.forEach(word -> {
            stringer.key(Integer.toString(word.getId()));
            stringer.value(word.isLearned());
        });
        stringer.endObject();

        try {
            FileUtility.saveTextFile(learnedJson,stringer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get amount of known vocabulary from the entire collection.
     * Recommended purpose of use: progress bar.
     * @return amount of known vocabulary
     */
    public long getProgress() { return allVocabulary.stream().filter(word -> word.isLearned()).count(); }

    /**
     * Get quantity of the entire vocabulary.
     * Recommended purpose of use: progress bar.
     * @return amount of entire vocabulary
     */
    public long getQuantity() { return allVocabulary.size(); }

    /**
     * Get quantity of known vocabulary of certain level.
     * Recommended purpose of use: progress bar.
     * @param lvl level of vocabulary (EASY, MEDIUM, HARD)
     * @return quantity of known vocabulary
     */
    public long getProgress(VocabularyLevel lvl) {
        switch(lvl) {
            case EASY: return allVocabulary.stream().filter(word -> word.getLevel().equals("Easy") && word.isLearned()).count();
            case MEDIUM: return allVocabulary.stream().filter(word -> word.getLevel().equals("Medium") && word.isLearned()).count();
            case HARD: return allVocabulary.stream().filter(word -> word.getLevel().equals("Hard") && word.isLearned()).count();
            default: return 0;
        }
    }

    /**
     * Get quantity of entire vocabulary of certain level.
     * Recommended purpose of use: progress bar.
     * @param lvl level of vocabulary (EASY, MEDIUM, HARD)
     * @return quantity of entire vocabulary
     */
    public long getQuantity(VocabularyLevel lvl) {
        switch(lvl) {
            case EASY: return allVocabulary.stream().filter(word -> word.getLevel().equals("Easy")).count();
            case MEDIUM: return allVocabulary.stream().filter(word -> word.getLevel().equals("Medium")).count();
            case HARD: return allVocabulary.stream().filter(word -> word.getLevel().equals("Hard")).count();
            default: return 0;
        }
    }

    /**
     * Determine whether "Next" button can be pressed
     * @param type type of selected vocabulary (ALL, KNOWN, UNKNOWN)
     * @return true if button should be active
     */
    public boolean canGetNextFlashcard(VocabularyType type) {
        switch(type) {
            case ALL: return allDrawnListIterator.canIncrement();
            case KNOWN: return knownDrawnListIterator.canIncrement();
            case UNKNOWN: return unknownDrawnListIterator.canIncrement();
            default: return false;
        }
    }

    /**
     * Determine whether "Back" button can be pressed
     * @param type type of selected vocabulary (ALL, KNOWN, UNKNOWN)
     * @return true if button should be active
     */
    public boolean canGetPreviousFlashcard(VocabularyType type) {
        switch(type) {
            case ALL: return allDrawnListIterator.canDecrement();
            case KNOWN: return knownDrawnListIterator.canDecrement();
            case UNKNOWN: return unknownDrawnListIterator.canDecrement();
            default: return false;
        }
    }

    /**
     * Get amount of drawn vocabulary of certain type
     * @param type type of selected vocabulary (ALL, KNOWN, UNKNOWN)
     * @return amount of drawn vocabulary
     */
    public int getDrawnCount(VocabularyType type) {
        switch(type) {
            case ALL: return allDrawnListIterator.list.size();
            case KNOWN: return knownDrawnListIterator.list.size();
            case UNKNOWN: return unknownDrawnListIterator.list.size();
            default: return 0;
        }
    }

    /**
     * Get current Word of certain type from lastDrawn List
     * @param type type of selected vocabulary (ALL, KNOWN, UNKNOWN)
     * @return Word from lastDrawn List
     */
    public Word getLastDrawn(VocabularyType type) {
        switch(type) {
            case ALL: return (Word)allDrawnListIterator.getObject();
            case KNOWN: return (Word)knownDrawnListIterator.getObject();
            case UNKNOWN: return (Word)unknownDrawnListIterator.getObject();
            default: return null;
        }
    }

    private List<Word> allVocabulary;
    private List<Word> knownVocabulary;
    private List<Word> unknownVocabulary;

    private List<Word> allDrawn = new ArrayList<>();
    private List<Word> knownDrawn = new ArrayList<>();
    private List<Word> unknownDrawn = new ArrayList<>();

    private MyListIterator allDrawnListIterator = new MyListIterator(allDrawn);
    private MyListIterator knownDrawnListIterator = new MyListIterator(knownDrawn);
    private MyListIterator unknownDrawnListIterator = new MyListIterator(unknownDrawn);

    private Random random;
    private File learnedJson;

    /**
     * Inner class responsible for iterating through elements of the list.
     * @author Michal Glogowski
     */
    private class MyListIterator {
        /**
         * Constructor
         * @param list List associated with this iterator
         */
        public MyListIterator(List<?> list) {
            this.list = list;
            iterator = list.size();
        }

        /**
         * Decrement iterator if possible
         */
        public void decrement() { if(canDecrement()) iterator--; }

        /**
         * Increment iterator if possible
         */
        public void increment() { if(canIncrement()) iterator++; }

        /**
         * Determine whether iterator can be decremented
         * @return true if possible
         */
        public boolean canDecrement() { return iterator>0; }

        /**
         * Determine whether iterator can be incremented
         * @return true if possible
         */
        public boolean canIncrement() { return iterator<list.size()-1; }

        /**
         * Get current position on list of this iterator
         * @return position on list of this iterator
         */
        public int getIterator() { return iterator; }

        /**
         * Get current Object pointed by this iterator
         * @return Object pointed by this iterator
         */
        public Object getObject() { return list.get(iterator); }

        /**
         * Set iterator on last possible position
         */
        public void setIteratorOnLastPosition() { iterator = list.size()-1; }

        private int iterator;
        private List<?> list;
    }
}
