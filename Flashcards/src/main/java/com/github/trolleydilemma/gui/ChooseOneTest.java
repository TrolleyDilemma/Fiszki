package com.github.trolleydilemma.gui;

import com.github.trolleydilemma.core.datastructures.TestData;

import javax.swing.*;
import java.awt.*;
//TODO: Dokumentacja
public class ChooseOneTest extends MainPanel {

    public ChooseOneTest(){

        super();
        init();

    }

    private void init(){

        word = new JPanel();
        word.setBounds(200, 30, 400, 200);
        word.setLayout(null);
        word.setBorder(BorderFactory.createLineBorder(Color.black));
        add(word);

        answerA = new JButton();
        answerA.setFont(new Font("Thoma", Font.BOLD, 18));
        answerA.setBounds(160,250,200,60);
        answerA.setFocusable(false);
        add(answerA);

        answerB = new JButton();
        answerB.setFont(new Font("Thoma", Font.BOLD, 18));
        answerB.setBounds(160,330,200,60);
        answerB.setFocusable(false);
        add(answerB);

        answerC = new JButton();
        answerC.setFont(new Font("Thoma", Font.BOLD, 18));
        answerC.setBounds(440,250,200,60);
        answerC.setFocusable(false);
        add(answerC);

        answerD = new JButton();
        answerD.setFont(new Font("Thoma", Font.BOLD, 18));
        answerD.setBounds(440,330,200,60);
        answerD.setFocusable(false);
        add(answerD);

        next = new JButton("Next");
        next.setFont(new Font("Thoma", Font.BOLD, 18));
        next.setBounds(660,415,120,45);
        next.setFocusable(false);
        next.setHorizontalTextPosition(SwingConstants.LEFT);
        next.setIcon(new ImageIcon(getClass().getResource("/images/Next.png")));
        next.setIconTextGap(10);
        add(next);

    }

    public JButton getAnswerA() { return answerA; }
    public JButton getAnswerB() { return answerB; }
    public JButton getAnswerC() { return answerC; }
    public JButton getAnswerD() { return answerD; }

    public void setAnswerA(JButton arg) { answerA = arg; }
    public void setAnswerB(JButton arg) { answerB = arg; }
    public void setAnswerC(JButton arg) { answerC = arg; }
    public void setAnswerD(JButton arg) { answerD = arg; }

    public JPanel getWord() { return word; }
    public JButton getNext() { return answerA; }

    public TestData getTestData() { return testData; }
    public void setTestData(TestData arg) { this.testData = testData; }

    private JButton answerA;
    private JButton answerB;
    private JButton answerC;
    private JButton answerD;

    private JPanel word;
    private JButton next;

    private TestData testData;

}

