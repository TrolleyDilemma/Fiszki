package com.github.trolleydilemma.gui.listeners;

import com.github.trolleydilemma.core.App;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.ExecutorService;

/**
 * WindowAdapter for main window. It saves user's Vocabulary learning progress.
 * @author Michal Glogowski
 */
public class MainWindowAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent we) {
        ExecutorService exec = App.getExecutorService();
        final int answer = JOptionPane.showConfirmDialog(App.getWindow(),"Do you want to exit the application?", "Confirm exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(answer == JOptionPane.YES_OPTION) {
            App.getWindow().dispose();
            exec.execute(() -> {
                App.getVocabulary().saveProgress();
                exec.shutdown();
            });
        }
    }
}
