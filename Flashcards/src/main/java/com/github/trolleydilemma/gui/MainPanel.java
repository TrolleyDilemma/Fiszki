package com.github.trolleydilemma.gui;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel(){

        super();
        init();

    }

    private void init(){

        setLayout(null);
        setBounds(50,110,800,480);
        setBackground(new Color(255, 212, 132));
        //setBorder(BorderFactory.createRaisedBevelBorder());
        setBorder((BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLoweredBevelBorder())));

    }
}
