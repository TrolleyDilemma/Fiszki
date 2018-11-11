package com.github.trolleydilemma.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class ButtonsPanel extends JPanel {


    public ButtonsPanel(){

        super();
        init();

    }

    private void init(){

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(1080,720));


        JPanel buttons = buttons();
        buttons.setPreferredSize(new Dimension(1065,720));
        add(buttons);
    }

    private JMenuItem createJMenuItem(String title,  ActionListener al) {
        JMenuItem jMenuItem;
        jMenuItem = new JMenuItem(title);
        jMenuItem.addActionListener(al);
        return jMenuItem;
    }

    private JPanel buttons(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(103, 130, 106));


        JMenuBar menuBarFlashcards = new JMenuBar();
        menuBarFlashcards.setBounds(10, 20, 150, 40);
        menuBarFlashcards.setLayout(null);

            JMenu menuFlashcards = new PaintMenu("Flashcards", new Color(220,220,220));
            menuFlashcards.setFont(new Font("Thoma", Font.BOLD, 18));
            menuFlashcards.setBounds(0, 0, 150, 40);
            menuFlashcards.setBorder(BorderFactory.createLineBorder(Color.black));
            menuFlashcards.setBorderPainted(true);
            menuFlashcards.setIcon(new ImageIcon("FlashcardIcon.png"));
            menuFlashcards.setIconTextGap(5);

                menuFlashcards.add(createJMenuItem("All", null));
                menuFlashcards.add(createJMenuItem("Known", null));
                menuFlashcards.add(createJMenuItem("Unknown", null));
                menuBarFlashcards.add(menuFlashcards);
                panel.add(menuBarFlashcards);


        JMenuBar menuBarTest = new JMenuBar();
        menuBarTest.setBounds(180, 20, 150, 40);
        menuBarTest.setLayout(null);

            JMenu menuTest = new PaintMenu("  Test", new Color(220,220,220));
            menuTest.setFont(new Font("Thoma", Font.BOLD, 18));
            menuTest.setBounds(0, 0, 150, 40);
            menuTest.setBorder(BorderFactory.createLineBorder(Color.black));
             menuTest.setBorderPainted(true);
            menuTest.setIcon(new ImageIcon("TestIcon.png"));
            menuTest.setIconTextGap(10);

                menuTest.add(createJMenuItem("Test 1", null));
                menuTest.add(createJMenuItem("Test 2", null));
                menuBarTest.add(menuTest);
                 panel.add(menuBarTest);


        JMenuBar menuBarList = new JMenuBar();
        menuBarList.setBounds(350, 20, 150, 40);
        menuBarList.setLayout(null);

            JMenu menuList = new PaintMenu("   List", new Color(220,220,220));
            menuList.setFont(new Font("Thoma", Font.BOLD, 18));
             menuList.setBounds(0, 0, 150, 40);
            menuList.setBorder(BorderFactory.createLineBorder(Color.black));
            menuList.setBorderPainted(true);
            menuList.setIcon(new ImageIcon("ListIcon.png"));
            menuList.setIconTextGap(10);

                menuList.add(createJMenuItem("All", null));
                menuList.add(createJMenuItem("Known", null));
                menuList.add(createJMenuItem("Unknown",null));
                menuBarList.add(menuList);
                panel.add(menuBarList);


        // TODO: Dopisac funkcje, ktora nie podswietla przycisku po starcie aplikacji
        JButton btnStat = new JButton("Statistics");
        btnStat.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnStat.setBounds(520, 20, 150, 40);
        btnStat.setBorder(BorderFactory.createEmptyBorder());
        // TODO: kolor ofc...
        btnStat.setIcon(new ImageIcon("StatisticIcon.png"));
        btnStat.setIconTextGap(10);
        panel.add(btnStat);


        ImageIcon icon = new ImageIcon("LogiIcon.png");
        JLabel obrazek = new JLabel(icon);
        obrazek.setBounds(915,20,125,125);
        panel.add(obrazek);

        return panel;
    }


    // TODO: Przeanalizowac kod ponizej
    private class PaintMenu extends JMenu {
        public PaintMenu(String label, Color bgColor) {
            super(label);
            this.bgColor = bgColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(bgColor);
            g.fillRect(0,0,getWidth(),getHeight()); //rysuj PRZED komponentem
            super.paintComponent(g);                      //rysuj komponent
        }

        private Color bgColor;
    }
}
