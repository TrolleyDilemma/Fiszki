package com.github.trolleydilemma.gui;

import com.github.trolleydilemma.core.App;
import com.github.trolleydilemma.core.enums.VocabularyLevel;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * Class creating "StatisticPanel, sets up panel with all statistics from learning
 * @author Blazej Zurawik
 */
public class StatisticsPanel extends MainPanel {

    public  StatisticsPanel(){

        super();
        init();

    }

    /**
     * Method creating and places all containers in the right spots
     */
    private void init(){

        progressE = new JProgressBar(JProgressBar.VERTICAL);
        progressE.setBounds(200, 52, 50, 320);
        progressE.setMaximum((int)App.getVocabulary().getQuantity(VocabularyLevel.EASY));
        progressE.setMinimum(0);
        progressE.setStringPainted(true);
        progressE.setString("");
        progressE.setBorder(BorderFactory.createLoweredBevelBorder());
        progressE.setForeground(new Color(165,199,127));
        add(progressE);

        valueEasy = new JTextField();
        valueEasy.setFont(new Font("Arial", Font.PLAIN, 18));
        valueEasy.setBounds(175,20,100,30);
        valueEasy.setEditable(false);
        valueEasy.setOpaque(false);
        valueEasy.setBorder(null);
        valueEasy.setHorizontalAlignment(JTextField.CENTER);
        add(valueEasy);

        JTextArea easy = new JTextArea("Easy");
        easy.setFont(new Font("Arial", Font.BOLD, 18));
        easy.setBounds(201,375,65,30);
        easy.setEditable(false);
        easy.setOpaque(false);
        add(easy);

        progressM = new JProgressBar(JProgressBar.VERTICAL);
        progressM.setBounds(375, 52, 50, 320);
        progressM.setMaximum((int)App.getVocabulary().getQuantity(VocabularyLevel.MEDIUM));
        progressM.setMinimum(0);
        progressM.setStringPainted(true);
        progressM.setString("");
        progressM.setBorder(BorderFactory.createLoweredBevelBorder());
        progressM.setForeground(new Color(255,212,85));
        add(progressM);

        valueMedium = new JTextField();
        valueMedium.setFont(new Font("Arial", Font.PLAIN, 18));
        valueMedium.setBounds(350,20,100,30);
        valueMedium.setEditable(false);
        valueMedium.setOpaque(false);
        valueMedium.setBorder(null);
        valueMedium.setHorizontalAlignment(JTextField.CENTER);
        add(valueMedium);

        JTextArea medium = new JTextArea("Medium");
        medium.setFont(new Font("Arial", Font.BOLD, 18));
        medium.setBounds(364,375,70,30);
        medium.setEditable(false);
        medium.setOpaque(false);
        add(medium);

        progressH = new JProgressBar(JProgressBar.VERTICAL);
        progressH.setBounds(550, 52, 50, 320);
        progressH.setMaximum((int)App.getVocabulary().getQuantity(VocabularyLevel.HARD));
        progressH.setMinimum(0);
        progressH.setStringPainted(true);
        progressH.setString("");
        progressH.setBorder(BorderFactory.createLoweredBevelBorder());
        progressH.setForeground(new Color(200,76,90));
        add(progressH);

        valueHard = new JTextField();
        valueHard.setFont(new Font("Arial", Font.PLAIN, 18));
        valueHard.setBounds(525,20,100,30);
        valueHard.setEditable(false);
        valueHard.setOpaque(false);
        valueHard.setBorder(null);
        valueHard.setHorizontalAlignment(JTextField.CENTER);
        add(valueHard);

        JTextArea hard = new JTextArea("Hard");
        hard.setFont(new Font("Arial", Font.BOLD, 18));
        hard.setBounds(553,375,65,30);
        hard.setEditable(false);
        hard.setOpaque(false);
        add(hard);


        progressAll = new JProgressBar();
        progressAll.setBounds(50, 440, 700, 20);
        progressAll.setMaximum((int)App.getVocabulary().getQuantity());
        progressAll.setMinimum(0);
        progressAll.setStringPainted(true);
        progressAll.setBorder(BorderFactory.createLoweredBevelBorder());
        progressAll.setForeground(new Color(104,130,106));
        add(progressAll);

        updateProgressBar();

    }

    /**
     * Method updated progress bar
     */
    private void updateProgressBar() {

        progressAll.setValue((int) App.getVocabulary().getProgress());
        progressE.setValue((int) App.getVocabulary().getProgress(VocabularyLevel.EASY));
        progressM.setValue((int) App.getVocabulary().getProgress(VocabularyLevel.MEDIUM));
        progressH.setValue((int) App.getVocabulary().getProgress(VocabularyLevel.HARD));

        valueEasy.setText(progressE.getValue() + "/" + progressE.getMaximum());
        valueMedium.setText(progressM.getValue() + "/" + progressM.getMaximum());
        valueHard.setText(progressH.getValue() + "/" + progressH.getMaximum());
        setTextForMainProgressBar();

    }

    /**
     * Method responsible for changing text on main progress bar with after decimal precision.
     */
    private void setTextForMainProgressBar() {

        double percentage = (double)progressAll.getValue() / progressAll.getMaximum();
        progressAll.setString(formatter.format(percentage));

    }

    private DecimalFormat formatter = new DecimalFormat("#.#%");

    private JProgressBar progressAll;
    private JProgressBar progressE;
    private JProgressBar progressM;
    private JProgressBar progressH;

    private JTextField valueEasy;
    private JTextField valueMedium;
    private JTextField valueHard;
}
