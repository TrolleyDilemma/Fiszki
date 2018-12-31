package com.github.trolleydilemma.gui.listeners.buttonspanel.flashcard;

import com.github.trolleydilemma.core.enums.VocabularyType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener for AllFlashcard MenuItem. It loads AllFlashcard Panel to main window.
 * @author Michal Glogowski
 */
public class FlashcardAllActionListener extends AbstractFlashcard implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) { createFlashcard(VocabularyType.ALL); }
}
