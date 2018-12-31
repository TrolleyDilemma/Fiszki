package com.github.trolleydilemma.gui;

import com.github.trolleydilemma.core.App;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MenuBar extends JMenuBar {

    public MenuBar() {

        super();
        build();

    }

    private String[] menuTitles = {"File", "Help"};
    private String[] fileMenuTitles = {"Exit"};
    private String[] aboutMenuTitles = {"Help", "About"};

    private JMenu createJMenu(String title, int keyEvent) {
        JMenu jMenu = new JMenu(title);
        jMenu.setMnemonic(keyEvent);
        return jMenu;
    }

    private JMenuItem createJMenuItem(String title, int keyEvent, ActionListener al) {
        JMenuItem jMenuItem;
        jMenuItem = new JMenuItem(title);
        jMenuItem.setMnemonic(keyEvent);
        jMenuItem.addActionListener(al);
        return jMenuItem;
    }

    private void build() {
        JMenu file = createJMenu(menuTitles[0], KeyEvent.VK_F);
        JMenu help = createJMenu(menuTitles[1], KeyEvent.VK_H);

        file.add(createJMenuItem(fileMenuTitles[0], KeyEvent.VK_X, event -> App.getWindow().getWindowListeners()[0].windowClosing(null)));
        help.add(createJMenuItem(aboutMenuTitles[0], KeyEvent.VK_A, event -> new HelpWindow(App.getWindow())));
        help.add(createJMenuItem(aboutMenuTitles[1], KeyEvent.VK_A, event -> new AboutWindow(App.getWindow())));

        add(file);
        add(help);

    }
}

