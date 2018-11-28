package com.github.trolleydilemma.gui;

import com.github.trolleydilemma.core.App;
import com.github.trolleydilemma.core.datastructures.Word;
import com.github.trolleydilemma.core.enums.VocabularyType;
import com.github.trolleydilemma.core.exceptions.OutOfWordsException;
import com.github.trolleydilemma.gui.listeners.flashcard.BackActionListener;
import com.github.trolleydilemma.gui.listeners.flashcard.CheckboxActionListener;
import com.github.trolleydilemma.gui.listeners.flashcard.NextActionListener;
import com.github.trolleydilemma.gui.listeners.flashcard.RollActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * Panel with Flashcard and controls.
 * @author Blazej Zurawik, Michal Glogowski
 */
public class FlashcardPanel extends MainPanel {

    private int progressMin = 0;
    private int progressMax = (int)App.getVocabulary().getQuantity();
    private int progressInit = (int)App.getVocabulary().getProgress();

    /**
     * Constructor that takes in type of Vocabulary that this Panel represents
     * @param vocabularyType type of Vocabulary that this Panel represents
     */
    public FlashcardPanel(VocabularyType vocabularyType){
        super();
        this.vocabularyType = vocabularyType;
        init();
    }


    /**
     * Initialize component
     */
    private void init(){

        setLayout(null);

        back = new JButton("Back");
        back.setFont(new Font("Thoma", Font.BOLD, 18));
        back.setBounds(190,380,120,45);
        back.setFocusable(false);
        back.setIcon(new ImageIcon(getClass().getResource("/images/Back.png")));
        back.setIconTextGap(10);
        back.setEnabled(false);
        back.addActionListener(new BackActionListener());
        add(back);

        roll = new JButton("Roll");
        roll.setFont(new Font("Thoma", Font.BOLD, 18));
        roll.setBounds(340,380,120,45);
        roll.setFocusable(false);
        roll.setIcon(new ImageIcon(getClass().getResource("/images/Roll.png")));
        roll.setIconTextGap(10);
        roll.addActionListener(new RollActionListener());
        add(roll);

        next = new JButton("Next");
        next.setFont(new Font("Thoma", Font.BOLD, 18));
        next.setBounds(490,380,120,45);
        next.setFocusable(false);
        next.setHorizontalTextPosition(SwingConstants.LEFT);
        next.setIcon(new ImageIcon(getClass().getResource("/images/Next.png")));
        next.setIconTextGap(10);
        next.setEnabled(false);
        next.addActionListener(new NextActionListener());
        add(next);

        progress = new JProgressBar();
        progress.setBounds(50, 440, 700, 20);
        progress.setMaximum(progressMax);
        progress.setMinimum(progressMin);
        progress.setValue(progressInit); //poczatkowa wartosc`
        progress.setStringPainted(true);
        progress.setBorder(BorderFactory.createLoweredBevelBorder());
        progress.setForeground(new Color(104,130,106));
        add(progress);

        check = new JButtonBox(false);
        check.setLocation(665, 385);
        check.setSize(35,35);
        //check.setOpaque(false);
        check.setFocusable(false);
        add(check);

        if(App.getVocabulary().canGetNextFlashcard(vocabularyType))
            next.setEnabled(true);

        if(App.getVocabulary().canGetPreviousFlashcard(vocabularyType))
            back.setEnabled(true);

        Word w = new Word();
        if(App.getVocabulary().getDrawnCount(vocabularyType) == 0) {

            try {
                w = App.getVocabulary().draw(vocabularyType);
            } catch (OutOfWordsException e) {
                JOptionPane.showMessageDialog(this, "Empty list!");
            }

            flashcard = new Flashcard(w);
            check.setChecked(w.isLearned());
        } else {
            w = App.getVocabulary().getLastDrawn(vocabularyType);
            flashcard = new Flashcard(w);
            check.setChecked(w.isLearned());
        }
        add(flashcard);
    }

    /**
     * Method responsible for updating progress bar with current progress from Vocabulary
     */
    public void updateProgressBar() { progress.setValue((int)App.getVocabulary().getProgress()); }

    public void setEnabledBackButton(boolean arg) { back.setEnabled(arg); }
    public void setEnabledNextButton(boolean arg) { next.setEnabled(arg); }
    public void setCheckbox(boolean arg) { check.setChecked(arg); }

    public void setFlashcard(Flashcard f) { flashcard = f; }

    public Flashcard getFlashcard() { return flashcard; }
    public VocabularyType getVocabularyType() { return vocabularyType; }
    public boolean getCheckboxValue() { return check.isChecked; }

    private VocabularyType vocabularyType;

    private JButton back;
    private JButton roll;
    private JButton next;
    private JProgressBar progress;
    private JButtonBox check;
    private Flashcard flashcard;

    private class JButtonBox extends JButton {

        private BufferedImage checkBox;
        private boolean isChecked;
        public JButtonBox(boolean isChecked){

            super();
            try {
                checkBox = ImageIO.read(getClass().getResourceAsStream("/images/CheckBoxSelected.png"));
            } catch(IOException e) {
                e.printStackTrace();
            }

            this.isChecked = isChecked;
            this.addActionListener(new CheckboxActionListener());
        }

        @Override
        protected void paintComponent(Graphics g){

            super.paintComponent(g);
            if(isChecked){

                Graphics2D g2 = (Graphics2D) g;
                g2.drawImage(checkBox, 0,0,this.getWidth(),this.getHeight(),this);

            }

        }

        public boolean isChecked(){return isChecked;}
        public void setChecked(boolean isChecked){this.isChecked = isChecked;}

    }

}
