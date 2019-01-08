package com.github.trolleydilemma.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Class creating "ListPanel", setting up panel with dictionary
 * @author Blazej Zurawik
 */
public class ListPanel extends MainPanel {

    public ListPanel(){

        super();
        init();

    }

    /**
     * Method creating and placing container in the right spot
     */
    private void init(){

        words = new JTextArea();
        words.setFont(new Font("Arrial", Font.BOLD, 18));
        words.setEditable(false);

        scrollP = new JScrollPane(words, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollP.setBounds(40,20,720,440);
        add(scrollP);

    }

    public void setText(String text) { words.setText(text); }

    private JTextArea words;
    private JScrollPane scrollP;

}


