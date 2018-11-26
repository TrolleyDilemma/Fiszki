package com.github.trolleydilemma.gui;

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

            firstAnwser = new JTextField();
            firstAnwser.setBounds(500,30,200,50);
            firstAnwser.setFont(new Font("Tehoma", Font.BOLD, 18));
            firstAnwser.setHorizontalAlignment(JTextField.CENTER);
            add(firstAnwser);

            secondAnwser = new JTextField();
            secondAnwser.setBounds(500,100,200,50);
            secondAnwser.setFont(new Font("Tehoma", Font.BOLD, 18));
            secondAnwser.setHorizontalAlignment(JTextField.CENTER);
            add(secondAnwser);

            thirdAnwser = new JTextField();
            thirdAnwser.setBounds(500,170,200,50);
            thirdAnwser.setFont(new Font("Tehoma", Font.BOLD, 18));
            thirdAnwser.setHorizontalAlignment(JTextField.CENTER);
            add(thirdAnwser);

            fourthAnwser = new JTextField();
            fourthAnwser.setBounds(500,240,200,50);
            fourthAnwser.setFont(new Font("Tehoma", Font.BOLD, 18));
            fourthAnwser.setHorizontalAlignment(JTextField.CENTER);
            add(fourthAnwser);

            fifthAnwser = new JTextField();
            fifthAnwser.setBounds(500,310,200,50);
            fifthAnwser.setFont(new Font("Tehoma", Font.BOLD, 18));
            fifthAnwser.setHorizontalAlignment(JTextField.CENTER);
            add(fifthAnwser);



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


    private JTextField firstWord;
    public JTextField getFirstWord(){ return firstWord; }
    public void setFirstWord(JTextField arg){ firstWord = arg;}

    private JTextField secondWord;
    public JTextField getSecondWord(){return secondWord;}
    public void setSecondWord(JTextField arg){secondWord = arg;}

    private JTextField thirdWord;
    public JTextField getThirdWord(){return thirdWord;}
    public void setThirdWord(JTextField arg){thirdWord = arg;}

    private JTextField fourthWord;
    public JTextField getFourthWord(){return fourthWord;}
    public void setFourthWord(JTextField arg){fourthWord = arg;}

    private JTextField fifthWord;
    public JTextField getFifthWord(){return fifthWord;}
    public void setFifthWord(JTextField arg){fourthWord = arg;}


    private JTextField firstAnwser;
    public JTextField getFirstAnwser(){return firstAnwser;}

    private JTextField secondAnwser;
    public JTextField getSecondAnwser(){return secondAnwser;}

    private JTextField thirdAnwser;
    public JTextField getThirdAnwser(){return thirdAnwser;}

    private JTextField fourthAnwser;
    public JTextField getFourthAnwser(){return fourthAnwser;}

    private JTextField fifthAnwser;
    public JTextField getFifthAnwser(){return fifthAnwser;}


    private JButton next;
    public JButton getNext (){return next;}

    private JButton check;
    public JButton getCheck(){return check;}
}
