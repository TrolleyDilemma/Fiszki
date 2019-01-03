package com.github.trolleydilemma.gui;

import com.github.trolleydilemma.gui.listeners.buttonspanel.flashcard.FlashcardAllActionListener;
import com.github.trolleydilemma.gui.listeners.buttonspanel.flashcard.FlashcardKnownActionListener;
import com.github.trolleydilemma.gui.listeners.buttonspanel.flashcard.FlashcardUnknownActionListener;
import com.github.trolleydilemma.gui.listeners.buttonspanel.list.AllListActionListener;
import com.github.trolleydilemma.gui.listeners.buttonspanel.list.KnownListActionListener;
import com.github.trolleydilemma.gui.listeners.buttonspanel.list.UnknownListActionListener;
import com.github.trolleydilemma.gui.listeners.buttonspanel.statistics.StatisticsPanelMenuListener;
import com.github.trolleydilemma.gui.listeners.buttonspanel.test.ChooseOneTestActionListener;
import com.github.trolleydilemma.gui.listeners.buttonspanel.test.InputTestActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class creating "ButtonsPanel", sets up buttons needed to navigate in application
 * @author Blazej Zurawik, Michal Glogowski
 */
public class ButtonsPanel extends JPanel {


    public ButtonsPanel(){

        super();
        init();

    }

    /**
     * Method creating and places all containers and buttons in the right spots
     */
    private void init(){

        setLayout(null);
        setBounds(0,0,1080, 720);
        setBackground(new Color(103, 130, 106));

        JMenuBar menuBarFlashcards = new JMenuBar();
        menuBarFlashcards.setBounds(50, 40, 150, 40);
        menuBarFlashcards.setLayout(null);

        JMenu menuFlashcards = new PaintMenu("Flashcards", new Color(220,220,220));
        menuFlashcards.setFont(new Font("Arial", Font.BOLD, 18));
        menuFlashcards.setBounds(0, 0, 150, 40);
        menuFlashcards.setBorder((BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLoweredBevelBorder())));
        menuFlashcards.setBorderPainted(true);
        menuFlashcards.setIcon(new ImageIcon(getClass().getResource("/images/FlashcardIcon.png")));
        menuFlashcards.setIconTextGap(5);
        menuFlashcards.add(createJMenuItem("All", new FlashcardAllActionListener(), "/images/All.png"));
        menuFlashcards.add(createJMenuItem("Known", new FlashcardKnownActionListener(), "/images/Known.png"));
        menuFlashcards.add(createJMenuItem("Unknown", new FlashcardUnknownActionListener(), "/images/Unknown.png"));
        menuBarFlashcards.add(menuFlashcards);
        add(menuBarFlashcards);

        JMenuBar menuBarTest = new JMenuBar();
        menuBarTest.setBounds(220, 40, 150, 40);
        menuBarTest.setLayout(null);

        JMenu menuTest = new PaintMenu("  Test", new Color(220,220,220));
        menuTest.setFont(new Font("Arial", Font.BOLD, 18));
        menuTest.setBounds(0, 0, 150, 40);
        menuTest.setBorder((BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLoweredBevelBorder())));
        menuTest.setBorderPainted(true);
        menuTest.setIcon(new ImageIcon(getClass().getResource("/images/TestIcon.png")));
        menuTest.setIconTextGap(10);
        menuTest.add(createJMenuItem("Choose One Test", new ChooseOneTestActionListener(),"/images/Test.png"));
        menuTest.add(createJMenuItem("Input Test", new InputTestActionListener(), "/images/Test1.png"));
        menuBarTest.add(menuTest);
        add(menuBarTest);

        JMenuBar menuBarList = new JMenuBar();
        menuBarList.setBounds(390, 40, 150, 40);
        menuBarList.setLayout(null);

        JMenu menuList = new PaintMenu("   List", new Color(220,220,220));
        menuList.setFont(new Font("Arial", Font.BOLD, 18));
        menuList.setBounds(0, 0, 150, 40);
        menuList.setBorder((BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLoweredBevelBorder())));
        menuList.setBorderPainted(true);
        menuList.setIcon(new ImageIcon(getClass().getResource("/images/ListIcon.png")));
        menuList.setIconTextGap(10);
        menuList.add(createJMenuItem("All", new AllListActionListener(),"/images/All.png"));
        menuList.add(createJMenuItem("Known", new KnownListActionListener(), "/images/Known.png"));
        menuList.add(createJMenuItem("Unknown", new UnknownListActionListener(), "/images/Unknown.png"));
        menuBarList.add(menuList);
        add(menuBarList);

        JMenuBar menuBarStatistics = new JMenuBar();
        menuBarStatistics.setBounds(560, 40, 150, 40);
        menuBarStatistics.setLayout(null);

        menuStatistics = new PaintMenu("Statistics", new Color(220,220,220));
        menuStatistics.setFont(new Font("Arial", Font.BOLD, 18));
        menuStatistics.setBounds(0, 0, 150, 40);
        menuStatistics.setBorder((BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLoweredBevelBorder())));
        menuStatistics.setBorderPainted(true);
        menuStatistics.setIcon(new ImageIcon(getClass().getResource("/images/StatisticIcon.png")));
        menuStatistics.setIconTextGap(10);
        menuStatistics.addMenuListener(new StatisticsPanelMenuListener());
        menuBarStatistics.add(menuStatistics);
        add(menuBarStatistics);

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/LogiIcon.png"));
        JLabel obrazek = new JLabel(icon);
        obrazek.setBounds(910,10,125,125);
        add(obrazek);

    }

    /**
     * Turns off selection (highlight) of menuStatistics. It needs to be used after pressing menuStatistics.
     */
    public void deselectMenuStatistics() { menuStatistics.setSelected(false); }

    /**
     * Method that allow us to create JMenuItem just by induction this function
     * @param title title of JmenuItem
     * @param al ActionListener reacts to mouse click
     * @param iconPath path to icon
     * @return
     */
    private JMenuItem createJMenuItem(String title,  ActionListener al, String iconPath) {
        JMenuItem jMenuItem;
        jMenuItem = new JMenuItem(title);
        jMenuItem.addActionListener(al);
        jMenuItem.setIcon(new ImageIcon(getClass().getResource(iconPath)));
        return jMenuItem;
    }

    /**
     * Inside class "PaintMenu" allow to change background color to JMenu
     */
    private class PaintMenu extends JMenu {
        public PaintMenu(String label, Color bgColor) {
            super(label);
            this.bgColor = bgColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(bgColor);
            g.fillRect(0,0,getWidth(),getHeight());
            super.paintComponent(g);
    }

        private Color bgColor;
    }

    public MainPanel getMainPanel(){ return mainPanel; }
    public void setMainPanel(MainPanel mp) { mainPanel = mp; }

    private MainPanel mainPanel;
    private JMenu menuStatistics;
}
