package com.github.trolleydilemma.gui.listeners.flashcard;

import com.github.trolleydilemma.core.App;
import com.github.trolleydilemma.core.datastructures.Word;
import com.github.trolleydilemma.core.enums.VocabularyType;
import com.github.trolleydilemma.gui.FlashcardPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;

/**
 * ActionListener for the custom Checkbox in FlashcardPanel
 * @author Michal Glogowski
 */
public class CheckboxActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        FlashcardPanel flashcardPanel = (FlashcardPanel)App.getWindow().getButtonPanel().getMainPanel();
        ExecutorService exec = App.getExecutorService();
        VocabularyType type = flashcardPanel.getVocabularyType();
        boolean checkboxValue = !flashcardPanel.getCheckboxValue();

        flashcardPanel.setCheckbox(checkboxValue);
        exec.execute(() -> {
            Word w = App.getVocabulary().getLastDrawn(type);
            w.setLearned(checkboxValue);
            App.getVocabulary().filterVocabulary();
            SwingUtilities.invokeLater(() -> ((FlashcardPanel)App.getWindow().getButtonPanel().getMainPanel()).updateProgressBar());
        });
    }
}
