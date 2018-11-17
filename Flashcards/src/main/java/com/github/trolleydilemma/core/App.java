package com.github.trolleydilemma.core;

import com.github.trolleydilemma.gui.Window;

import javax.swing.*;
import java.io.File;

/**
 * Entry point
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        //TODO: put it in config class with window's config
        File configFile = new File("./config/learned.json");
        if(!configFile.exists())
            configFile.getParentFile().mkdirs();

        Vocabulary vocabulary = new Vocabulary();

        SwingUtilities.invokeLater(() -> window = new Window());
    }

    private static Window window;
}
