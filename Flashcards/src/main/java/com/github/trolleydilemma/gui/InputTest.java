package com.github.trolleydilemma.gui;

import com.github.trolleydilemma.core.datastructures.TestData;

import javax.swing.*;
import java.awt.*;

public class InputTest extends MainPanel {

    public InputTest (){

        super();
        init();

    }

    private void init(){

        firstWord = new JTextField();
        firstWord.setBounds(100,30,200,50);
        firstWord.setFont(new Font("Tehoma", Font.BOLD, 18));
        firstWord.setHorizontalAlignment(JTextField.CENTER);
        firstWord.setText("firstWord");
        firstWord.setEditable(false);
        add(firstWord);

        secondWord = new JTextField();
        secondWord.setBounds(100,100,200,50);
        secondWord.setFont(new Font("Tehoma", Font.BOLD, 18));
        secondWord.setHorizontalAlignment(JTextField.CENTER);
        secondWord.setText("secondWord");
        secondWord.setEditable(false);
        add(secondWord);

        thirdWord = new JTextField();
        thirdWord.setBounds(100,170,200,50);
        thirdWord.setFont(new Font("Tehoma", Font.BOLD, 18));
        thirdWord.setHorizontalAlignment(JTextField.CENTER);
        thirdWord.setText("thirdWord");
        thirdWord.setEditable(false);
        add(thirdWord);

        fourthWord = new JTextField();
        fourthWord.setBounds(100,240,200,50);
        fourthWord.setFont(new Font("Tehoma", Font.BOLD, 18));
        fourthWord.setHorizontalAlignment(JTextField.CENTER);
        fourthWord.setText("fourthWord");
        fourthWord.setEditable(false);
        add(fourthWord);

        fifthWord = new JTextField();
        fifthWord.setBounds(100,310,200,50);
        fifthWord.setFont(new Font("Tehoma", Font.BOLD, 18));
        fifthWord.setHorizontalAlignment(JTextField.CENTER);
        fifthWord.setText("fifthWord");
        fifthWord.setEditable(false);
        add(fifthWord);

            firstAnswer = new JTextField();
            firstAnswer.setBounds(500,30,200,50);
            firstAnswer.setFont(new Font("Tehoma", Font.BOLD, 18));
            firstAnswer.setHorizontalAlignment(JTextField.CENTER);
            add(firstAnswer);

            secondAnswer = new JTextField();
            secondAnswer.setBounds(500,100,200,50);
            secondAnswer.setFont(new Font("Tehoma", Font.BOLD, 18));
            secondAnswer.setHorizontalAlignment(JTextField.CENTER);
            add(secondAnswer);

            thirdAnswer = new JTextField();
            thirdAnswer.setBounds(500,170,200,50);
            thirdAnswer.setFont(new Font("Tehoma", Font.BOLD, 18));
            thirdAnswer.setHorizontalAlignment(JTextField.CENTER);
            add(thirdAnswer);

            fourthAnswer = new JTextField();
            fourthAnswer.setBounds(500,240,200,50);
            fourthAnswer.setFont(new Font("Tehoma", Font.BOLD, 18));
            fourthAnswer.setHorizontalAlignment(JTextField.CENTER);
            add(fourthAnswer);

            fifthAnswer = new JTextField();
            fifthAnswer.setBounds(500,310,200,50);
            fifthAnswer.setFont(new Font("Tehoma", Font.BOLD, 18));
            fifthAnswer.setHorizontalAlignment(JTextField.CENTER);
            add(fifthAnswer);



        next = new JButton("Next");
        next.setFont(new Font("Thoma", Font.BOLD, 18));
        next.setBounds(660,415,120,45);
        next.setFocusable(false);
        next.setHorizontalTextPosition(SwingConstants.LEFT);
        next.setIcon(new ImageIcon(getClass().getResource("/images/Next.png")));
        next.setIconTextGap(10);
        add(next);


        check = new JButton("Check");
        check.setFont(new Font("Thoma", Font.BOLD, 18));
        check.setBounds(325,170,150,50);
        check.setFocusable(false);
        check.setHorizontalTextPosition(SwingConstants.LEFT);
        add(check);

    }

    public JButton getNext () { return next; }
    public JButton getCheck() { return check; }

    public TestData getTestData() { return testData; }
    public void setTestData(TestData arg) { this.testData = testData; }

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

    public void setFirstWord(JTextField arg) { firstWord = arg; }
    public void setSecondWord(JTextField arg) { secondWord = arg; }
    public void setThirdWord(JTextField arg) { thirdWord = arg; }
    public void setFourthWord(JTextField arg) { fourthWord = arg; }
    public void setFifthWord(JTextField arg) { fourthWord = arg; }

    private JButton next;
    private JButton check;

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
