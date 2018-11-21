package com.github.trolleydilemma.gui.listeners;

import com.github.trolleydilemma.core.App;
import com.github.trolleydilemma.core.enums.VocabularyType;
import com.github.trolleydilemma.gui.ButtonsPanel;
import com.github.trolleydilemma.gui.FlashcardPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener for KnownFlashcard MenuItem. It loads KnownFlashcard Panel to main window.
 * @author Michal Glogowski
 */
public class FlashcardKnownActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonsPanel buttonsPanel = App.getWindow().getButtonPanel();
        FlashcardPanel flashcardPanel = buttonsPanel.getFlashcardPanel();
        try { buttonsPanel.remove(flashcardPanel); }
        catch (NullPointerException ex) {}

        flashcardPanel = new FlashcardPanel(VocabularyType.KNOWN);
        buttonsPanel.setFlashcardPanel(flashcardPanel);
        buttonsPanel.add(flashcardPanel);
        buttonsPanel.repaint();
    }
}
