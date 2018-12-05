package com.github.trolleydilemma.gui.listeners.chooseonetest;

import com.github.trolleydilemma.core.App;
import com.github.trolleydilemma.gui.ChooseOneTest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener for "Answer" Button in ChooseOneTest panel.
 * When action is performed it changes frames of buttons with answers accordingly to correctness of answers.
 * @author Michal Glogowski
 */
public class AnswerButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ChooseOneTest chooseOneTest = (ChooseOneTest) App.getWindow().getButtonPanel().getMainPanel();

        chooseOneTest.getAnswerA().setBackground(Color.RED);
        chooseOneTest.getAnswerB().setBackground(Color.RED);
        chooseOneTest.getAnswerC().setBackground(Color.RED);
        chooseOneTest.getAnswerD().setBackground(Color.RED);

        switch(chooseOneTest.getTestData().getMainWordId()) {
            case 0:
                chooseOneTest.getAnswerA().setBackground(Color.GREEN);
                break;
            case 1:
                chooseOneTest.getAnswerB().setBackground(Color.GREEN);
                break;
            case 2:
                chooseOneTest.getAnswerC().setBackground(Color.GREEN);
                break;
            case 3:
                chooseOneTest.getAnswerD().setBackground(Color.GREEN);
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
