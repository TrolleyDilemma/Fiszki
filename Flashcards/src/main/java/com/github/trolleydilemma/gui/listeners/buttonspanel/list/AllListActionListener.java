package com.github.trolleydilemma.gui.listeners.buttonspanel.list;

import com.github.trolleydilemma.core.enums.VocabularyType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener for All List MenuItem. It loads List Panel to main window and initializes it with entire vocabulary.
 * @author Michal Glogowski
 */
public class AllListActionListener extends AbstractList implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) { createList(VocabularyType.ALL); }
}
