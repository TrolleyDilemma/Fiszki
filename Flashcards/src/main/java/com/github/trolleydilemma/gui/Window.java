package com.github.trolleydilemma.gui;

import com.github.trolleydilemma.gui.listeners.MainWindowAdapter;

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

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new MainWindowAdapter());
        setSize(1080, 720);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        contentPane_1 = new JPanel();
       // contentPane_1.setBorder(new EmptyBorder(5,5,5,5));
        contentPane_1.setLayout(new BorderLayout());
        add(contentPane_1, BorderLayout.CENTER);

        add(new StatusBar(), BorderLayout.PAGE_END);

        add(new MenuBar(), BorderLayout.PAGE_START);

        buttonPanel = new ButtonsPanel();
        add(buttonPanel, BorderLayout.CENTER);

    }

    public ButtonsPanel getButtonPanel() {return buttonPanel;}

    private ButtonsPanel buttonPanel;
}
