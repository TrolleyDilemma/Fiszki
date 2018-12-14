package com.github.trolleydilemma.gui.listeners.buttonspanel.test;

import com.github.trolleydilemma.core.App;
import com.github.trolleydilemma.core.datastructures.TestData;
import com.github.trolleydilemma.core.enums.VocabularyType;
import com.github.trolleydilemma.core.exceptions.OutOfWordsException;
import com.github.trolleydilemma.gui.ButtonsPanel;
import com.github.trolleydilemma.gui.InputTest;
import com.github.trolleydilemma.gui.MainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

/**
 * ActionListener for InputTest MenuItem. It loads InputTest Panel to main window.
 * @author Michal Glogowski
 */
public class InputTestActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonsPanel buttonsPanel = App.getWindow().getButtonPanel();
        MainPanel mainPanel = buttonsPanel.getMainPanel();

        if(App.getVocabulary().getProgress() > 4) {
            try { buttonsPanel.remove(mainPanel); }
            catch (NullPointerException ex) {}

            mainPanel = new InputTest();
            buttonsPanel.setMainPanel(mainPanel);
            buttonsPanel.add(mainPanel);
            buttonsPanel.repaint();

            inputTest = (InputTest)mainPanel;

            App.getExecutorService().execute(() -> {
                try {
                    testData = App.getVocabulary().drawForInputTest(VocabularyType.KNOWN,5);
                    SwingUtilities.invokeAndWait(() -> {
                        inputTest.setTestData(testData);
                        inputTest.getFirstWord().setText(testData.getWords().get(0).getJapanese().get(0));
                        inputTest.getSecondWord().setText(testData.getWords().get(1).getJapanese().get(0));
                        inputTest.getThirdWord().setText(testData.getWords().get(2).getJapanese().get(0));
                        inputTest.getFourthWord().setText(testData.getWords().get(3).getJapanese().get(0));
                        inputTest.getFifthWord().setText(testData.getWords().get(4).getJapanese().get(0));
                    });
                } catch (InterruptedException | InvocationTargetException ex) {
                    ex.printStackTrace();
                } catch (OutOfWordsException ex) {
                    SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(App.getWindow(),
                            "You don't have enough known vocabulary to draw from.", "No vocabulary", JOptionPane.INFORMATION_MESSAGE));
                }
            });
        } else {
            SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(App.getWindow(),
                    "You don't have enough known vocabulary to draw from.", "No vocabulary", JOptionPane.INFORMATION_MESSAGE));
        }
    }

    private TestData testData;
    private InputTest inputTest;
}
