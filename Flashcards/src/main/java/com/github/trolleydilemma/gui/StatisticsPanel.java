package com.github.trolleydilemma.gui;

import com.github.trolleydilemma.core.App;
import javax.swing.*;
import java.awt.*;

public class StatisticsPanel extends MainPanel {

    private int progressMin = 0;
    private int progressMax = (int)App.getVocabulary().getQuantity();
    private int progressInit = (int)App.getVocabulary().getProgress();

    public  StatisticsPanel(){

        super();
        init();

    }

    private void init(){

        //TODO: czy da sie zeobic napis Vertical?

        progressE = new JProgressBar(JProgressBar.VERTICAL);
        progressE.setBounds(200, 52, 50, 320);
        progressE.setMaximum(progressMax);
        progressE.setMinimum(progressMin);
        progressE.setValue(progressInit); //poczatkowa wartosc`
        progressE.setStringPainted(true);
        progressE.setString("");
        progressE.setBorder(BorderFactory.createLoweredBevelBorder());
        progressE.setForeground(new Color(165,199,127));
        add(progressE);

        valueEasy = new JTextField("100/100");
        valueEasy.setFont(new Font("Thoma", Font.PLAIN, 18));
        valueEasy.setBounds(175,20,100,30);
        valueEasy.setEditable(false);
        valueEasy.setOpaque(false);
        valueEasy.setBorder(null);
        valueEasy.setHorizontalAlignment(JTextField.CENTER);
        add(valueEasy);

        JTextArea easy = new JTextArea("Easy");
        easy.setFont(new Font("Thoma", Font.BOLD, 18));
        easy.setBounds(201,375,65,30);
        easy.setEditable(false);
        easy.setOpaque(false);
        add(easy);

        progressM = new JProgressBar(JProgressBar.VERTICAL);
        progressM.setBounds(375, 52, 50, 320);
        progressM.setMaximum(progressMax);
        progressM.setMinimum(progressMin);
        progressM.setValue(progressInit); //poczatkowa wartosc`
        progressM.setStringPainted(true);
        progressM.setString("");
        progressM.setBorder(BorderFactory.createLoweredBevelBorder());
        progressM.setForeground(new Color(255,212,85));
        add(progressM);

        valueMedium = new JTextField("100/100");
        valueMedium.setFont(new Font("Thoma", Font.PLAIN, 18));
        valueMedium.setBounds(350,20,100,30);
        valueMedium.setEditable(false);
        valueMedium.setOpaque(false);
        valueMedium.setBorder(null);
        valueMedium.setHorizontalAlignment(JTextField.CENTER);
        add(valueMedium);

        JTextArea medium = new JTextArea("Medium");
        medium.setFont(new Font("Thoma", Font.BOLD, 18));
        medium.setBounds(364,375,70,30);
        medium.setEditable(false);
        medium.setOpaque(false);
        add(medium);

        progressH = new JProgressBar(JProgressBar.VERTICAL);
        //progressH = new MyVerticalProgressBar();
        progressH.setBounds(550, 52, 50, 320);
        progressH.setMaximum(progressMax);
        progressH.setMinimum(progressMin);
        progressH.setValue(progressInit); //poczatkowa wartosc`
        progressH.setStringPainted(true);
        progressH.setString("");
        progressH.setBorder(BorderFactory.createLoweredBevelBorder());
        progressH.setForeground(new Color(200,76,90));
        add(progressH);

        valueHard = new JTextField("100/100");
        valueHard.setFont(new Font("Thoma", Font.PLAIN, 18));
        valueHard.setBounds(525,20,100,30);
        valueHard.setEditable(false);
        valueHard.setOpaque(false);
        valueHard.setBorder(null);
        valueHard.setHorizontalAlignment(JTextField.CENTER);
        add(valueHard);

        JTextArea hard = new JTextArea("Hard");
        hard.setFont(new Font("Thoma", Font.BOLD, 18));
        hard.setBounds(553,375,65,30);
        hard.setEditable(false);
        hard.setOpaque(false);
        add(hard);


        progressAll = new JProgressBar();
        progressAll.setBounds(50, 440, 700, 20);
        progressAll.setMaximum(progressMax);
        progressAll.setMinimum(progressMin);
        progressAll.setValue(progressInit); //poczatkowa wartosc`
        progressAll.setStringPainted(true);
        progressAll.setBorder(BorderFactory.createLoweredBevelBorder());
        progressAll.setForeground(new Color(104,130,106));
        add(progressAll);

    }

    public void updateProgressBar() {
        progressAll.setValue((int) App.getVocabulary().getProgress());
        progressE.setValue((int) App.getVocabulary().getProgress());
        progressM.setValue((int) App.getVocabulary().getProgress());
        progressH.setValue((int) App.getVocabulary().getProgress());
    }
    private JProgressBar progressAll;
    private JProgressBar progressE;
    private JProgressBar progressM;
    private JProgressBar progressH;

    private JTextField valueEasy;
    private JTextField valueMedium;
    private JTextField valueHard;

    public JTextField getValueEasy() {
        return valueEasy;
    }

    public void setValueEasy(JTextField valueEasy) {
        this.valueEasy = valueEasy;
    }

    public JTextField getValueMedium() {
        return valueMedium;
    }

    public void setValueMedium(JTextField valueMedium) {
        this.valueMedium = valueMedium;
    }

    public JTextField getValueHard() {
        return valueHard;
    }

    public void setValueHard(JTextField valueHard) {
        this.valueHard = valueHard;
    }

    public JProgressBar getProgressAll() {
        return progressAll;
    }

    public void setProgressAll(JProgressBar progressAll) {
        this.progressAll = progressAll;
    }

    public JProgressBar getProgressE() {
        return progressE;
    }

    public void setProgressE(JProgressBar progressE) {
        this.progressE = progressE;
    }

    public JProgressBar getProgressM() {
        return progressM;
    }

    public void setProgressM(JProgressBar progressM) {
        this.progressM = progressM;
    }

    public JProgressBar getProgressH() {
        return progressH;
    }

    public void setProgressH(JProgressBar progressH) {
        this.progressH = progressH;
    }
}
