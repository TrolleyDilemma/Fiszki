package com.github.trolleydilemma.gui;

import com.github.trolleydilemma.core.datastructures.TestData;
import com.github.trolleydilemma.gui.listeners.buttonspanel.ChooseOneTestActionListener;
import com.github.trolleydilemma.gui.listeners.chooseonetest.AnswerButtonActionListener;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
//TODO: Dokumentacja
public class ChooseOneTest extends MainPanel {

    public ChooseOneTest(){

        super();
        init();

    }

    private void init(){

        word = new JPanel();
        word.setBounds(100, 25, 600, 220);
        word.setLayout(null);
        word.setBorder(BorderFactory.createLineBorder(Color.black));
        add(word);

        text = new JTextPane();
        text.setFont(new Font("Thoma", Font.PLAIN, 15));
        text.setBounds(5,20, 590,180);
        text.setEnabled(false);
        //text.setText("test raz dwa trzy");
        //text.setBorder(BorderFactory.createLineBorder(Color.black));
        StyledDocument doc = text.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        word.add(text);

        answerA = new JButton();
        answerA.setFont(new Font("Thoma", Font.BOLD, 18));
        answerA.setBounds(140,265,240,60);
        answerA.setFocusable(false);
        answerA.addActionListener(new AnswerButtonActionListener());
        add(answerA);

        answerB = new JButton();
        answerB.setFont(new Font("Thoma", Font.BOLD, 18));
        answerB.setBounds(140,345,240,60);
        answerB.setFocusable(false);
        answerB.addActionListener(new AnswerButtonActionListener());
        add(answerB);

        answerC = new JButton();
        answerC.setFont(new Font("Thoma", Font.BOLD, 18));
        answerC.setBounds(420,265,240,60);
        answerC.setFocusable(false);
        answerC.addActionListener(new AnswerButtonActionListener());
        add(answerC);

        answerD = new JButton();
        answerD.setFont(new Font("Thoma", Font.BOLD, 18));
        answerD.setBounds(420,345,240,60);
        answerD.setFocusable(false);
        answerD.addActionListener(new AnswerButtonActionListener());
        add(answerD);

        next = new JButton("Next");
        next.setFont(new Font("Thoma", Font.BOLD, 18));
        next.setBounds(660,415,120,45);
        next.setFocusable(false);
        next.setHorizontalTextPosition(SwingConstants.LEFT);
        next.setIcon(new ImageIcon(getClass().getResource("/images/Next.png")));
        next.setIconTextGap(10);
        next.addActionListener(new ChooseOneTestActionListener());
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
    public void setTestData(TestData arg) { testData = arg; }

    private JButton answerA;
    private JButton answerB;
    private JButton answerC;
    private JButton answerD;

    private JPanel word;
    private JTextPane text;
    private JButton next;

    private TestData testData;

}

