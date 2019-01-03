package com.github.trolleydilemma.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Abstract class
 * @author Blazej Zurawik
 */
public abstract class MainPanel extends JPanel {

    public MainPanel(){

        super();
        init();

    }

    /**
     * Method creating and places container in the right spot
     */
    private void init(){

        setLayout(null);
        setBounds(50,110,800,480);
        setBackground(new Color(255, 212, 132));
        setBorder((BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLoweredBevelBorder())));

    }
}
