package com.github.trolleydilemma.gui.listeners.buttonspanel.statistics;

import com.github.trolleydilemma.core.App;
import com.github.trolleydilemma.gui.ButtonsPanel;
import com.github.trolleydilemma.gui.MainPanel;
import com.github.trolleydilemma.gui.StatisticsPanel;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * MenuListener for Statistics JMenu. It loads Statistics Panel to main window.
 * @author Michal Glogowski
 */
public class StatisticsPanelMenuListener implements MenuListener {
    @Override
    public void menuSelected(MenuEvent e) {
        ButtonsPanel buttonsPanel = App.getWindow().getButtonPanel();
        buttonsPanel.deselectMenuStatistics();          //get rid off highlight on menuStatistics
        MainPanel mainPanel = buttonsPanel.getMainPanel();
        try { buttonsPanel.remove(mainPanel); }
        catch (NullPointerException ex) {}

        mainPanel = new StatisticsPanel();
        buttonsPanel.setMainPanel(mainPanel);
        buttonsPanel.add(mainPanel);
        buttonsPanel.repaint();
    }

    @Override
    public void menuDeselected(MenuEvent e) { }

    @Override
    public void menuCanceled(MenuEvent e) { }
}
