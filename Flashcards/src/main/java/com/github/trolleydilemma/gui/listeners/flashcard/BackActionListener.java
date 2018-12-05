package com.github.trolleydilemma.gui.listeners.flashcard;

import com.github.trolleydilemma.core.App;
import com.github.trolleydilemma.core.datastructures.Word;
import com.github.trolleydilemma.core.enums.VocabularyType;
import com.github.trolleydilemma.gui.Flashcard;
import com.github.trolleydilemma.gui.FlashcardPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;

/**
 * ActionListener for the Back button in the Flashcard module
 * @author Michal Glogowski
 */
public class BackActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        FlashcardPanel flashcardPanel = (FlashcardPanel)App.getWindow().getButtonPanel().getMainPanel();
        Flashcard flashcard = flashcardPanel.getFlashcard();
        VocabularyType type = flashcardPanel.getVocabularyType();
        ExecutorService exec = App.getExecutorService();

        exec.execute(() -> {
            Word word = App.getVocabulary().back(type);
            boolean back = App.getVocabulary().canGetPreviousFlashcard(type);

            SwingUtilities.invokeLater(() -> {
                flashcardPanel.setEnabledBackButton(back);
                flashcardPanel.setEnabledNextButton(true);
                flashcardPanel.setCheckbox(word.isLearned());
                flashcardPanel.repaint();

                flashcardPanel.remove(flashcard);
                Flashcard newFlashcard = new Flashcard(word);
                flashcardPanel.setFlashcard(newFlashcard);
                flashcardPanel.add(newFlashcard);
            });
        });
    }
}
