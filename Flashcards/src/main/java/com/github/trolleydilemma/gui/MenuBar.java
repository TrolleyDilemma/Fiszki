package com.github.trolleydilemma.gui;

import com.github.trolleydilemma.core.App;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Class creating "MenuBar", sets up Bar with "File" and "Help" menu
 * @author Blazej Zurawik
 */
public class MenuBar extends JMenuBar {

    public MenuBar() {

        super();
        build();

    }

    private String[] menuTitles = {"File", "Help"};
    private String[] fileMenuTitles = {"Exit"};
    private String[] aboutMenuTitles = {"Help", "About"};

    /**
     * Method creating JMenu
     * @param title name of JMenu
     * @param keyEvent event when key clicked
     * @return
     */
    private JMenu createJMenu(String title, int keyEvent) {
        JMenu jMenu = new JMenu(title);
        jMenu.setMnemonic(keyEvent);
        return jMenu;
    }

    /**
     * Method creating JMenuItem
     * @param title name of JMenuItem
     * @param keyEvent event when key clicked (alt + key)
     * @param al ActionListener
     * @param iconPath path to folder with icons
     * @return
     */
    private JMenuItem createJMenuItem(String title, int keyEvent, ActionListener al, String iconPath) {
        JMenuItem jMenuItem;
        jMenuItem = new JMenuItem(title);
        jMenuItem.setMnemonic(keyEvent);
        jMenuItem.addActionListener(al);
        jMenuItem.setIcon(new ImageIcon(getClass().getResource(iconPath)));
        return jMenuItem;
    }

    /**
     * Method creating containers
     */
    private void build() {
        JMenu file = createJMenu(menuTitles[0], KeyEvent.VK_F);
        JMenu help = createJMenu(menuTitles[1], KeyEvent.VK_H);

        file.add(createJMenuItem(fileMenuTitles[0], KeyEvent.VK_X, event -> App.getWindow().getWindowListeners()[0].windowClosing(null), "/images/Exit.png"));
        help.add(createJMenuItem(aboutMenuTitles[0], KeyEvent.VK_H, event -> new HelpWindow(App.getWindow()), "/images/Help.png"));
        help.add(createJMenuItem(aboutMenuTitles[1], KeyEvent.VK_A, event -> new AboutWindow(App.getWindow()), "/images/About.png"));

        add(file);
        add(help);
    }
}

