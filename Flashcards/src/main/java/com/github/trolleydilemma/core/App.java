package com.github.trolleydilemma.core;

import com.github.trolleydilemma.gui.Window;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

        vocabulary = new Vocabulary();

        SwingUtilities.invokeLater(() -> window = new Window());
    }

    public static Vocabulary getVocabulary() { return vocabulary; }
    public static Window getWindow() { return  window; }
    public static ExecutorService getExecutorService() { return executorService; }

    private static Window window;
    private static Vocabulary vocabulary;
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);
}
