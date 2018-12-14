package com.github.trolleydilemma.gui.listeners.buttonspanel.flashcard;

import com.github.trolleydilemma.core.App;
import com.github.trolleydilemma.core.enums.VocabularyType;
import com.github.trolleydilemma.gui.ButtonsPanel;
import com.github.trolleydilemma.gui.FlashcardPanel;
import com.github.trolleydilemma.gui.MainPanel;

/**
 * Base class for listeners creating specified types of FlashcardPanel.
 * @author Michal Glogowski
 */
public abstract class AbstractFlashcard {

    /**
     * Create FlashcardPanel with vocabulary of specified type
     * @param type type of vocabulary which will be displayed on FlashcardPanel
     */
    protected void createFlashcard(VocabularyType type) {
        ButtonsPanel buttonsPanel = App.getWindow().getButtonPanel();
        MainPanel mainPanel = buttonsPanel.getMainPanel();
        try { buttonsPanel.remove(mainPanel); }
        catch (NullPointerException ex) {}

        mainPanel = new FlashcardPanel(type);
        buttonsPanel.setMainPanel(mainPanel);
        buttonsPanel.add(mainPanel);
        buttonsPanel.repaint();
    }
}
