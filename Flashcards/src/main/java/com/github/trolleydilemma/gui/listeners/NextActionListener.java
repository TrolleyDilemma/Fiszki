package com.github.trolleydilemma.gui.listeners;

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
 * ActionListener for the Next button in the Flashcard module
 * @author Michal Glogowski
 */
public class NextActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        FlashcardPanel flashcardPanel = App.getWindow().getButtonPanel().getFlashcardPanel();
        Flashcard flashcard = flashcardPanel.getFlashcard();
        VocabularyType type = App.getWindow().getButtonPanel().getFlashcardPanel().getVocabularyType();
        ExecutorService exec = App.getExecutorService();

        exec.execute(() -> {
            Word word = App.getVocabulary().next(type);
            boolean next = App.getVocabulary().canGetNextFlashcard(type);

            SwingUtilities.invokeLater(() -> {
                flashcardPanel.setEnabledBackButton(true);
                flashcardPanel.setEnabledNextButton(next);
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
