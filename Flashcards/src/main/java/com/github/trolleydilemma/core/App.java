package com.github.trolleydilemma.core;

import com.github.trolleydilemma.gui.Window;

import javax.swing.*;

/**
 * Entry point
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        SwingUtilities.invokeLater(() -> window = new Window());
    }

    private static Window window;
}
