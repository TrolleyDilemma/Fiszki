package com.github.trolleydilemma.gui.listeners.inputtest;

import com.github.trolleydilemma.core.App;
import com.github.trolleydilemma.core.datastructures.Word;
import com.github.trolleydilemma.gui.InputTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * ActionListener for "Check" Button in ChooseOneTest panel.
 * When action is performed it changes backgrounds of JTextFields with answers accordingly to correctness of answers.
 * @author Michal Glogowski
 */
public class CheckButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        InputTest inputTest = (InputTest) App.getWindow().getButtonPanel().getMainPanel();

        processAnswer(inputTest.getFirstAnswer(), inputTest.getTestData().getWords().get(0));
        processAnswer(inputTest.getSecondAnswer(), inputTest.getTestData().getWords().get(1));
        processAnswer(inputTest.getThirdAnswer(), inputTest.getTestData().getWords().get(2));
        processAnswer(inputTest.getFourthAnswer(), inputTest.getTestData().getWords().get(3));
        processAnswer(inputTest.getFifthAnswer(), inputTest.getTestData().getWords().get(4));
    }

    /**
     * Method responsible for checking and changing answerField accordingly to correctness of assigned Word.
     * @param answerField JTextField which frame color will change and also will be used as a source of text to base on.
     * @param word Word object containing correct answers
     */
    private void processAnswer(JTextField answerField, Word word) {
        String answer = answerField.getText();
        List<String> english = word.getEnglish();

        correct = false;
        english.forEach(x -> {
            if(x.equalsIgnoreCase(answer))
                correct = true;
        });

        if(correct)
            answerField.setBackground(green);
        else
            answerField.setBackground(red);
    }

    private boolean correct;
    private Color red = new Color(200,76,90);
    private Color green = new Color(165,199,127);
}
