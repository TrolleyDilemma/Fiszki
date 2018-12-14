package com.github.trolleydilemma.gui.listeners.buttonspanel.test;

import com.github.trolleydilemma.core.App;
import com.github.trolleydilemma.core.datastructures.TestData;
import com.github.trolleydilemma.core.enums.VocabularyType;
import com.github.trolleydilemma.core.exceptions.OutOfWordsException;
import com.github.trolleydilemma.gui.ButtonsPanel;
import com.github.trolleydilemma.gui.ChooseOneTest;
import com.github.trolleydilemma.gui.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * ActionListener for ChooseOneTest MenuItem. It loads ChooseOneTest Panel to main window.
 * @author Michal Glogowski
 */
public class ChooseOneTestActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonsPanel buttonsPanel = App.getWindow().getButtonPanel();
        MainPanel mainPanel = buttonsPanel.getMainPanel();

        if(App.getVocabulary().getProgress() > 0) {
            try { buttonsPanel.remove(mainPanel); }
            catch (NullPointerException ex) {}

            mainPanel = new ChooseOneTest();
            buttonsPanel.setMainPanel(mainPanel);
            buttonsPanel.add(mainPanel);
            buttonsPanel.repaint();

            chooseOneTest = (ChooseOneTest)mainPanel;

            App.getExecutorService().execute(() -> {
                try {
                    testData = App.getVocabulary().drawForChooseOneTest(VocabularyType.KNOWN);
                    SwingUtilities.invokeAndWait(() -> {
                        chooseOneTest.setTestData(testData);
                        chooseOneTest.getAnswerA().setText(testData.getWords().get(0).getEnglish().get(0));
                        chooseOneTest.getAnswerB().setText(testData.getWords().get(1).getEnglish().get(0));
                        chooseOneTest.getAnswerC().setText(testData.getWords().get(2).getEnglish().get(0));
                        chooseOneTest.getAnswerD().setText(testData.getWords().get(3).getEnglish().get(0));

                        switch (testData.getMainWordId()) {
                            case 0:
                                displayWord(0);
                                break;
                            case 1:
                                displayWord(1);
                                break;
                            case 2:
                                displayWord(2);
                                break;
                            case 3:
                                displayWord(3);
                                break;
                            default: throw new UnsupportedOperationException();
                        }

                    });
                } catch (InterruptedException | InvocationTargetException ex) {
                    ex.printStackTrace();
                } catch (OutOfWordsException ex) {
                    SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(App.getWindow(),
                            "You don't have any known vocabulary to draw from.", "No vocabulary", JOptionPane.INFORMATION_MESSAGE));
                }
            });
        } else {
            SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(App.getWindow(),
                    "You don't have any known vocabulary to draw from.", "No vocabulary", JOptionPane.INFORMATION_MESSAGE));
        }
    }

    /**
     * Display japanese word(s) on TextPane in ChooseOneTest panel.
     * @param id id of the word to display in the testData
     */
    private void displayWord(int id) {
        List<String> japanese = testData.getWords().get(id).getJapanese();
        StringBuilder sb = new StringBuilder();

        japanese.forEach(jap -> {
            sb.append(jap);
            sb.append('\n');
        });

        chooseOneTest.getText().setText(sb.toString());
        chooseOneTest.getText().setFont(new Font("Thoma", Font.BOLD, getFontSize(id)));
    }

    /**
     * Get font size depending on size of japanese vocabulary List in main Word.
     * @return font size for the main TextPane
     */
    private int getFontSize(int mainWordId) {
        int count = testData.getWords().get(mainWordId).getJapanese().size();

        switch(count) {
            case 1: return 64;
            case 2: return 48;
            case 3: return 32;
            case 4: return 28;
            case 5: return 24;
            default: return 22;
        }
    }

    private TestData testData;
    private ChooseOneTest chooseOneTest;
}
