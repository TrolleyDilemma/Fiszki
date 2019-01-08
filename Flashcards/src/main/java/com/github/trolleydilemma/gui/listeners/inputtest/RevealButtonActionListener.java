package com.github.trolleydilemma.gui.listeners.inputtest;

import com.github.trolleydilemma.core.datastructures.Word;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * ActionListener for "Reveal" Button in ChooseOneTest panel.
 * When action is performed it changes backgrounds of JTextFields with answers appropriately to correctness of answers.
 * Additionally it sets correct answer in text fields if user was wrong also disabling "Check" and "Reveal" Buttons.
 * @author Michal Glogowski
 */
public class RevealButtonActionListener extends CheckButtonActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        revealAnswer(inputTest.getFirstAnswer(), inputTest.getTestData().getWords().get(0));
        revealAnswer(inputTest.getSecondAnswer(), inputTest.getTestData().getWords().get(1));
        revealAnswer(inputTest.getThirdAnswer(), inputTest.getTestData().getWords().get(2));
        revealAnswer(inputTest.getFourthAnswer(), inputTest.getTestData().getWords().get(3));
        revealAnswer(inputTest.getFifthAnswer(), inputTest.getTestData().getWords().get(4));

        inputTest.getCheck().setEnabled(false);
        inputTest.getReveal().setEnabled(false);
    }

    /**
     * Method responsible for setting correct word in answerField based on background color of answerField (correctness of answer)
     * @param answerField JTextField which text will change
     * @param word Word object containing correct answers
     */
    private void revealAnswer(JTextField answerField, Word word) {
        if(answerField.getBackground().equals(red))
            answerField.setText(word.getEnglish().get(0));
    }
}
