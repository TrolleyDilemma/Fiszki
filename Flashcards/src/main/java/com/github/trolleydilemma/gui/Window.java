package com.github.trolleydilemma.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

public class Window extends JFrame {

    private JPanel contentPane_1;

    public Window() {

        super("Flashcards");
        init();
        setVisible(true);

    }

    private void init() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1080, 720);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        contentPane_1 = new JPanel();
        contentPane_1.setBorder(new EmptyBorder(5,5,5,5));
        contentPane_1.setBackground(new Color(103, 130,106));
        contentPane_1.setLayout(new BorderLayout());
        add(contentPane_1, BorderLayout.CENTER);

       // statusBar = new StatusBar();
        add(new StatusBar(), BorderLayout.PAGE_END);

        add(new MenuBar(), BorderLayout.PAGE_START);

        //trzeba zrobic tymi przeniesieniami...
        add(new ButtonsPanel(), BorderLayout.CENTER);


    }

    //public StatusBar getStatusBar() {
    //    return statusBar;
   // }
}
