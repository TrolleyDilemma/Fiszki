package com.github.trolleydilemma.gui;

import com.github.trolleydilemma.core.datastructures.TestData;
import com.github.trolleydilemma.gui.listeners.buttonspanel.test.InputTestActionListener;
import com.github.trolleydilemma.gui.listeners.inputtest.CheckButtonActionListener;
import com.github.trolleydilemma.gui.listeners.inputtest.RevealButtonActionListener;

import javax.swing.*;
import java.awt.*;

/**
 * Class creating "InputTest", sets up panel with input answers
 * @author Blazej Zurawik
 */
public class InputTest extends MainPanel {

    public InputTest(){

        super();
        init();

    }

    /**
     * Method creating and places all containers and buttons in the right spots
     */
    private void init(){

        firstWord = createTextField(100,30,false);
        secondWord = createTextField(100,100,false);
        thirdWord = createTextField(100,170,false);
        fourthWord = createTextField(100,240,false);
        fifthWord = createTextField(100,310,false);

        firstAnswer = createTextField(500,30,true);
        secondAnswer = createTextField(500,100,true);
        thirdAnswer = createTextField(500,170,true);
        fourthAnswer = createTextField(500,240,true);
        fifthAnswer = createTextField(500,310,true);


        next = new JButton("Next");
        next.setFont(new Font("Arial", Font.BOLD, 18));
        next.setBounds(660,415,120,45);
        next.setFocusable(false);
        next.setHorizontalTextPosition(SwingConstants.LEFT);
        next.setIcon(new ImageIcon(getClass().getResource("/images/Next.png")));
        next.setIconTextGap(10);
        next.addActionListener(new InputTestActionListener());
        add(next);


        check = new JButton("Check");
        check.setFont(new Font("Arial", Font.BOLD, 18));
        check.setBounds(325,135,150,50);
        check.setFocusable(false);
        check.setHorizontalTextPosition(SwingConstants.LEFT);
        check.addActionListener(new CheckButtonActionListener());
        add(check);


        reveal = new JButton("Reveal");
        reveal.setFont(new Font("Arial", Font.BOLD, 18));
        reveal.setBounds(325,205,150,50);
        reveal.setFocusable(false);
        reveal.setHorizontalTextPosition(SwingConstants.LEFT);
        reveal.addActionListener(new RevealButtonActionListener());
        add(reveal);

    }

    /**
     * Method creating JTextField in the right place
     * @param x x coordinate of text field
     * @param y y coordinate of text field
     * @param editable variable indicating if the text field is editable
     * @return text field in specific coordinates
     */
    private JTextField createTextField(int x, int y, boolean editable){

        JTextField textField = new JTextField();
        textField.setBounds(x,y,200,50);
        textField.setFont(new Font("Tehoma", Font.BOLD, 18));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(editable);
        add(textField);
        return textField;

    }

    public TestData getTestData() { return testData; }
    public void setTestData(TestData arg) { testData = arg; }

    public JTextField getFirstWord(){ return firstWord; }
    public JTextField getSecondWord() { return secondWord; }
    public JTextField getThirdWord() { return thirdWord; }
    public JTextField getFourthWord() { return fourthWord; }
    public JTextField getFifthWord() { return fifthWord; }

    public JTextField getFirstAnswer() { return firstAnswer; }
    public JTextField getSecondAnswer() { return secondAnswer; }
    public JTextField getThirdAnswer() { return thirdAnswer; }
    public JTextField getFourthAnswer() { return fourthAnswer; }
    public JTextField getFifthAnswer() { return fifthAnswer; }

    public JButton getCheck() { return check; }
    public JButton getReveal() { return reveal; }

    private JButton next;
    private JButton check;
    private JButton reveal;

    private JTextField firstWord;
    private JTextField secondWord;
    private JTextField thirdWord;
    private JTextField fourthWord;
    private JTextField fifthWord;

    private JTextField firstAnswer;
    private JTextField secondAnswer;
    private JTextField thirdAnswer;
    private JTextField fourthAnswer;
    private JTextField fifthAnswer;

    private TestData testData;
}
