package com.github.trolleydilemma.gui;

import com.github.trolleydilemma.core.datastructures.Word;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Class representing Flashcard
 * @author Blazej Zurawik, Michal Glogowski
 */
public class Flashcard extends JPanel {
    /**
     * Constructor that takes in Word which will Flashcard represent
     * @param word Word which will Flashcard represent
     */
    public Flashcard(Word word) {
        super();
        this.word = word;
        init();
    }

    /**
     * Initialize component
     */
    private void init() {
        setBounds(100, 50, 600, 315);
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.black));

        createWordTextPane();

        note = new JTextPane();
        note.setFont(new Font("Thoma", Font.PLAIN, 15));
        note.setBounds(100,240, 400,50);
        note.setEnabled(false);
        note.addMouseListener(myMouseListener);
        note.setText(word.getNote() + " ");
        //note.setBorder(BorderFactory.createLineBorder(Color.black)); //test
        StyledDocument doc = note.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        add(note);

        indexLevel = new JTextField();
        indexLevel.setBounds(555, 270, 40,20);
        indexLevel.setFont(new Font("Thoma", Font.PLAIN, 15));
        indexLevel.setEnabled(false);
        indexLevel.setBorder(null);
        //indexLevel.setBorder(BorderFactory.createLineBorder(Color.black)); //test
        indexLevel.setHorizontalAlignment(JTextField.CENTER);
        indexLevel.addMouseListener(myMouseListener);
        indexLevel.setText(word.getLevel().substring(0,1));
        add(indexLevel);

        indexNum = new JTextField();
        indexNum.setBounds(555, 290, 40,20);
        indexNum.setFont(new Font("Thoma", Font.PLAIN, 15));
        indexNum.setEnabled(false);
        indexNum.setBorder(null);
        //indexNum.setBorder(BorderFactory.createLineBorder(Color.black)); //test
        indexNum.setHorizontalAlignment(JTextField.CENTER);
        indexNum.addMouseListener(myMouseListener);
        indexNum.setText(Integer.toString(word.getId()));
        add(indexNum);

        addMouseListener(myMouseListener);
    }

    private Word word;
    private JTextPane wordTextPane;
    private JTextPane note;
    private JTextField indexLevel;
    private JTextField indexNum;
    private boolean isEnglish;

    private void setEnglish(boolean arg) { isEnglish = arg; }

    /**
     * (Re)create word TextPanes depending on isEnglish flag
     * (Flashcard can display only one meaning at the time [english or japanese])
     */
    private void createWordTextPane() {
        if(wordTextPane != null)
            remove(wordTextPane);   //remove component from JPanel

        wordTextPane = new JTextPane();
        wordTextPane.setFont(new Font("Thoma", Font.BOLD, 40));
        wordTextPane.setBounds(100,70,400,150);
        wordTextPane.setEnabled(false);
        wordTextPane.addMouseListener(myMouseListener);

        isEnglish = !isEnglish;

        StringBuilder sb = new StringBuilder();
        if(isEnglish) {
            word.getEnglish().forEach(x -> {
                sb.append(x);
                sb.append('\n');
            });
        } else {
            word.getJapanese().forEach(x -> {
                sb.append(x);
                sb.append('\n');
            });
        }

        wordTextPane.setText(sb.toString());
        //word.setBorder(BorderFactory.createLineBorder(Color.black)); //test
        StyledDocument docc = wordTextPane.getStyledDocument();
        SimpleAttributeSet centerr = new SimpleAttributeSet();
        StyleConstants.setAlignment(centerr, StyleConstants.ALIGN_CENTER);
        docc.setParagraphAttributes(0, docc.getLength(), centerr, false);
        add(wordTextPane);

    }

    /**
     * MouseListener which reloads TextPane with Word
     */
    private MouseListener myMouseListener = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) { createWordTextPane(); }

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    };
}
