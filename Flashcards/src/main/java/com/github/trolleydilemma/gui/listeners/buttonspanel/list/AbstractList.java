package com.github.trolleydilemma.gui.listeners.buttonspanel.list;

import com.github.trolleydilemma.core.App;
import com.github.trolleydilemma.core.datastructures.Word;
import com.github.trolleydilemma.core.enums.VocabularyType;
import com.github.trolleydilemma.gui.ButtonsPanel;
import com.github.trolleydilemma.gui.ListPanel;
import com.github.trolleydilemma.gui.MainPanel;

import javax.swing.*;
import java.util.List;

/**
 * Base class for listeners creating specified types of ListPanel.
 * @author Michal Glogowski
 */
public class AbstractList {

    /**
     * Create ListPanel with vocabulary of specified type
     * @param type type of vocabulary which will be displayed on ListPanel
     */
    protected void createList(VocabularyType type) {
        ButtonsPanel buttonsPanel = App.getWindow().getButtonPanel();
        mainPanel = buttonsPanel.getMainPanel();
        try { buttonsPanel.remove(mainPanel); }
        catch (NullPointerException ex) {}

        mainPanel = new ListPanel();
        ListPanel listPanel = (ListPanel) mainPanel;

        App.getExecutorService().execute(() -> {
            StringBuilder sb = new StringBuilder();
            List<Word> words = App.getVocabulary().get(type);
            words.forEach(word -> {
                word.getJapanese().forEach(jap -> {
                    sb.append(jap);
                    sb.append("、");
                });

                sb.deleteCharAt(sb.length() - 1);
                sb.append(" - ");

                word.getEnglish().forEach(eng -> {
                    sb.append(eng);
                    sb.append(", ");
                });

                sb.delete(sb.length() - 2, sb.length() - 1);
                sb.append("\n");
            });

            if(sb.length() > 1)
                sb.deleteCharAt(sb.length() - 1);

            listPanel.setText(sb.toString());

            SwingUtilities.invokeLater(() -> {
                buttonsPanel.setMainPanel(mainPanel);
                buttonsPanel.add(mainPanel);
                buttonsPanel.repaint();
                buttonsPanel.validate();
            });
        });
    }

    private MainPanel mainPanel;
}
