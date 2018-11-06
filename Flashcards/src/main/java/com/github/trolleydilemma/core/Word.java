package com.github.trolleydilemma.core;

import java.util.List;

/**
 * Wrapper class for vocabulary
 * @author Michal Glogowski
 */
public class Word {
    public Word(int id, List<String> eng, List<String> jap, String lvl) { this(id,eng,jap,lvl,""); }

    public Word(int id, List<String> eng, List<String> jap, String lvl, String note) {
        this.id = id;
        english = eng;
        japanese = jap;
        level = lvl;
        this.note = note;
        learned = false;
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
