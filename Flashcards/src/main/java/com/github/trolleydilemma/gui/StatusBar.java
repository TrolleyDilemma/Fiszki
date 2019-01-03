package com.github.trolleydilemma.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Class creating "StatusBar", representing on real time where you are in application
 * @author Blazej Zurawik
 */
public class StatusBar extends JPanel {

    public StatusBar() {

        super();
        init();

    }

    /**
     * Method creating and places all containers in the right spots
     */
    private void init() {

        text = new JLabel();
        text.setBorder(new EmptyBorder(0,3,0,0));
        text.setFont(new Font("Arial", Font.PLAIN, 16));
        setLayout(new BorderLayout());
        add(text, BorderLayout.LINE_START);

    }

    /**
     * Method sets up text on "StatusBar"
     * @param arg text to set on "StatusBar"
     */
    public void setText(String arg) {

        text.setText(arg);

    }

    private JLabel text;
}
