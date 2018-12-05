package com.github.trolleydilemma.gui.listeners.buttonspanel;

import com.github.trolleydilemma.core.App;
import com.github.trolleydilemma.core.enums.VocabularyType;
import com.github.trolleydilemma.gui.ButtonsPanel;
import com.github.trolleydilemma.gui.FlashcardPanel;
import com.github.trolleydilemma.gui.MainPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener for AllFlashcard MenuItem. It loads AllFlashcard Panel to main window.
 * @author Michal Glogowski
 */
public class FlashcardAllActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonsPanel buttonsPanel = App.getWindow().getButtonPanel();
        MainPanel mainPanel = buttonsPanel.getMainPanel();
        try { buttonsPanel.remove(mainPanel); }
        catch (NullPointerException ex) {}

        mainPanel = new FlashcardPanel(VocabularyType.ALL);
        buttonsPanel.setMainPanel(mainPanel);
        buttonsPanel.add(mainPanel);
        buttonsPanel.repaint();
    }
}