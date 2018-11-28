package com.github.trolleydilemma.gui.listeners.buttonspanel;

import com.github.trolleydilemma.core.App;
import com.github.trolleydilemma.core.datastructures.TestData;
import com.github.trolleydilemma.core.enums.VocabularyType;
import com.github.trolleydilemma.core.exceptions.OutOfWordsException;
import com.github.trolleydilemma.gui.ButtonsPanel;
import com.github.trolleydilemma.gui.ChooseOneTest;
import com.github.trolleydilemma.gui.MainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

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
                                //TODO: set text field to: testData.getWords().get(0).getJapanese().get(0)
                                break;
                            case 1:
                                //TODO: set text field to: testData.getWords().get(1).getJapanese().get(0)
                                break;
                            case 2:
                                //TODO: set text field to: testData.getWords().get(2).getJapanese().get(0)
                                break;
                            case 3:
                                //TODO: set text field to: testData.getWords().get(3).getJapanese().get(0)
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

    private TestData testData;
    private ChooseOneTest chooseOneTest;
}
