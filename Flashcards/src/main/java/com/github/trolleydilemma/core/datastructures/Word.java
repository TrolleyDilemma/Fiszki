package com.github.trolleydilemma.core.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Storage class for vocabulary
 * @author Michal Glogowski
 */
public class Word {
    /**
     * Constructor for Word class
     * @param id unique id number for identifying words
     * @param eng list with english meanings
     * @param jap list with japanese meanings
     * @param lvl level of advancement
     */
    public Word(int id, List<String> eng, List<String> jap, String lvl) { this(id,eng,jap,lvl,""); }

    /**
     * Constructor for Word class
     * @param id unique id number for identifying word
     * @param eng list with english meanings
     * @param jap list with japanese meanings
     * @param lvl level of advancement
     * @param note additional information about the meaning
     */
    public Word(int id, List<String> eng, List<String> jap, String lvl, String note) {
        this.id = id;
        this.english = eng;
        this.japanese = jap;
        this.level = lvl;
        this.note = note;
        this.learned = false;
    }

    /**
     * Create empty Word.
     */
    public Word() {
        this.id = 0;
        this.english = new ArrayList<>();
        this.japanese = new ArrayList<>();
        this.level = " ";
        this.note = " ";
        this.learned = false;
    }

    @Override
    public String toString() { return "Word #" + id; }

    public void setLearned(boolean arg) { learned = arg; }

    public int getId() { return id; }
    public List<String> getEnglish() { return english; }
    public List<String> getJapanese() { return japanese; }
    public String getLevel() { return level; }
    public String getNote() { return note; }
    public boolean isLearned() { return learned; }

    private int id;
    private List<String> english;
    private List<String> japanese;
    private String level;
    private String note;
    private boolean learned;
}
