package com.github.trolleydilemma.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class StatusBar extends JPanel {

    public StatusBar() {

        super();
        init();

    }

    private void init() {

        text = new JLabel();
        text.setBorder(new EmptyBorder(0,10,0,0));
        setBorder(new TitledBorder("Status:")); //przykladowy text
        setLayout(new BorderLayout());
        add(text, BorderLayout.LINE_START);

    }

    public void setText(String arg) {

        text.setText(arg);

    }

    private JLabel text;
}
