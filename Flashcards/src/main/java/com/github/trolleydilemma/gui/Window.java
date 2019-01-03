package com.github.trolleydilemma.gui;

import com.github.trolleydilemma.gui.listeners.MainWindowAdapter;

import javax.swing.*;
import java.awt.*;

/**
 * Class creating "Window" which is main window of application
 * @author Blazej Zurawik
 */
public class Window extends JFrame {

    private JPanel contentPane_1;

    public Window() {

        super("Flashcards");
        init();
        setVisible(true);

    }


    /**
     * Method creating and places all containers in the right spots
     */
    private void init() {

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new MainWindowAdapter());
        setSize(1080, 720);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        contentPane_1 = new JPanel();
        contentPane_1.setLayout(new BorderLayout());
        add(contentPane_1, BorderLayout.CENTER);

        statusBar = new StatusBar();
        add(statusBar, BorderLayout.PAGE_END);

        add(new MenuBar(), BorderLayout.PAGE_START);

        buttonPanel = new ButtonsPanel();
        add(buttonPanel, BorderLayout.CENTER);

        statusBar.setText("Application is running");

    }

    public ButtonsPanel getButtonPanel() { return buttonPanel; }
    public StatusBar getStatusBar() { return statusBar; }

    private ButtonsPanel buttonPanel;
    private StatusBar statusBar;
}
