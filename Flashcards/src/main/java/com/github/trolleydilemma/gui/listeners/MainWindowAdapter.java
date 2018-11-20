package com.github.trolleydilemma.gui.listeners;

import com.github.trolleydilemma.core.App;

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
        App.getWindow().dispose();

        exec.execute(() -> {
            App.getVocabulary().saveProgress();
            exec.shutdown();
        });
    }
}
