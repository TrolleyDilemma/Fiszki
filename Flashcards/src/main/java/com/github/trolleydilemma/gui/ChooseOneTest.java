package com.github.trolleydilemma.gui;

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

        anwserA = new JButton();
        anwserA.setFont(new Font("Thoma", Font.BOLD, 18));
        anwserA.setBounds(160,250,200,60);
        anwserA.setFocusable(false);
        add(anwserA);

        anwserB = new JButton();
        anwserB.setFont(new Font("Thoma", Font.BOLD, 18));
        anwserB.setBounds(160,330,200,60);
        anwserB.setFocusable(false);
        add(anwserB);

        anwserC = new JButton();
        anwserC.setFont(new Font("Thoma", Font.BOLD, 18));
        anwserC.setBounds(440,250,200,60);
        anwserC.setFocusable(false);
        add(anwserC);

        anwserD = new JButton();
        anwserD.setFont(new Font("Thoma", Font.BOLD, 18));
        anwserD.setBounds(440,330,200,60);
        anwserD.setFocusable(false);
        add(anwserD);

        next = new JButton("Next");
        next.setFont(new Font("Thoma", Font.BOLD, 18));
        next.setBounds(660,415,120,45);
        next.setFocusable(false);
        next.setHorizontalTextPosition(SwingConstants.LEFT);
        next.setIcon(new ImageIcon(getClass().getResource("/images/Next.png")));
        next.setIconTextGap(10);
        add(next);

    }

    private JPanel word;
        public JPanel getWord(){return word;}

    private JButton anwserA;
        public JButton getAnwserA(){return anwserA;}
        public void setAnwserA(JButton arg){anwserA = arg;}

    private JButton anwserB;
        public JButton getAnwserB(){return anwserB;}
        public void setAnwserB(JButton arg){anwserB = arg;}

    private JButton anwserC;
        public JButton getAnwserC(){return anwserC;}
        public void setAnwserC(JButton arg){anwserC = arg;}

    private JButton anwserD;
        public JButton getAnwserD(){return anwserD;}
        public void setAnwserD(JButton arg){anwserD = arg;}

    private JButton next;
        public JButton getNext(){return anwserA;}

}

