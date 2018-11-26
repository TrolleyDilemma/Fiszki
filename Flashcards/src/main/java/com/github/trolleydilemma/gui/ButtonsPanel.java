package com.github.trolleydilemma.gui;

import com.github.trolleydilemma.gui.listeners.FlashcardAllActionListener;
import com.github.trolleydilemma.gui.listeners.FlashcardKnownActionListener;
import com.github.trolleydilemma.gui.listeners.FlashcardUnknownActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * komenarz dokumentacyjny
 * @author Blazej Zurawik, Michal Glogowski
 */
public class ButtonsPanel extends JPanel {


    public ButtonsPanel(){

        super();
        init();

    }

    private void init(){

        setLayout(null);
        setBounds(0,0,1080, 720);
        setBackground(new Color(103, 130, 106));

        JMenuBar menuBarFlashcards = new JMenuBar();
        menuBarFlashcards.setBounds(50, 40, 150, 40);
        menuBarFlashcards.setLayout(null);

            JMenu menuFlashcards = new PaintMenu("Flashcards", new Color(220,220,220));
            menuFlashcards.setFont(new Font("Thoma", Font.BOLD, 18));
            menuFlashcards.setBounds(0, 0, 150, 40);
            menuFlashcards.setBorder((BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLoweredBevelBorder())));
            menuFlashcards.setBorderPainted(true);
            menuFlashcards.setIcon(new ImageIcon(getClass().getResource("/images/FlashcardIcon.png")));


            menuFlashcards.setIconTextGap(5);

                menuFlashcards.add(createJMenuItem("All", new FlashcardAllActionListener()));
                menuFlashcards.add(createJMenuItem("Known", new FlashcardKnownActionListener()));
                menuFlashcards.add(createJMenuItem("Unknown", new FlashcardUnknownActionListener()));
                menuBarFlashcards.add(menuFlashcards);
                add(menuBarFlashcards);


        JMenuBar menuBarTest = new JMenuBar();
        menuBarTest.setBounds(220, 40, 150, 40);
        menuBarTest.setLayout(null);

            JMenu menuTest = new PaintMenu("  Test", new Color(220,220,220));
            menuTest.setFont(new Font("Thoma", Font.BOLD, 18));
            menuTest.setBounds(0, 0, 150, 40);
            menuTest.setBorder((BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLoweredBevelBorder())));
            menuTest.setBorderPainted(true);
            menuTest.setIcon(new ImageIcon(getClass().getResource("/images/TestIcon.png")));
            menuTest.setIconTextGap(10);

                menuTest.add(createJMenuItem("Test 1", null));
                menuTest.add(createJMenuItem("Test 2", null));
                menuBarTest.add(menuTest);
                add(menuBarTest);


        JMenuBar menuBarList = new JMenuBar();
        menuBarList.setBounds(390, 40, 150, 40);
        menuBarList.setLayout(null);

            JMenu menuList = new PaintMenu("   List", new Color(220,220,220));
            menuList.setFont(new Font("Thoma", Font.BOLD, 18));
            menuList.setBounds(0, 0, 150, 40);
            menuList.setBorder((BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLoweredBevelBorder())));
            menuList.setBorderPainted(true);
            menuList.setIcon(new ImageIcon(getClass().getResource("/images/ListIcon.png")));
            menuList.setIconTextGap(10);

                menuList.add(createJMenuItem("All", null));
                menuList.add(createJMenuItem("Known", null));
                menuList.add(createJMenuItem("Unknown",null));
                menuBarList.add(menuList);
                add(menuBarList);


        JMenuBar menuBarStatistics = new JMenuBar();
        menuBarStatistics.setBounds(560, 40, 150, 40);
        menuBarStatistics.setLayout(null);

            JMenu menuStatistics = new PaintMenu("Statistics", new Color(220,220,220));
            menuStatistics.setFont(new Font("Thoma", Font.BOLD, 18));
            menuStatistics.setBounds(0, 0, 150, 40);
            menuStatistics.setBorder((BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLoweredBevelBorder())));
            menuStatistics.setBorderPainted(true);
            menuStatistics.setIcon(new ImageIcon(getClass().getResource("/images/StatisticIcon.png")));
            menuStatistics.setIconTextGap(10);

                menuBarStatistics.add(menuStatistics);
                add(menuBarStatistics);


        ImageIcon icon = new ImageIcon(getClass().getResource("/images/LogiIcon.png"));
        JLabel obrazek = new JLabel(icon);
        obrazek.setBounds(910,10,125,125);
        add(obrazek);

        //TODO: REMOVE
        //mainPanel = new ChooseOneTest();
       // add(mainPanel);

       // mainPanel = new InputTest();
        //add(mainPanel);

    }

    private JMenuItem createJMenuItem(String title,  ActionListener al) {
        JMenuItem jMenuItem;
        jMenuItem = new JMenuItem(title);
        jMenuItem.addActionListener(al);
        return jMenuItem;
    }

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

    public FlashcardPanel getFlashcardPanel(){ return (FlashcardPanel)mainPanel; }
    public void setFlashcardPanel(FlashcardPanel fp) { mainPanel = fp; }

    private JPanel mainPanel;
}
