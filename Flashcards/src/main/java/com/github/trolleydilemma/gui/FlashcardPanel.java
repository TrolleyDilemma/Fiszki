package com.github.trolleydilemma.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class FlashcardPanel extends MainPanel {

    int Progress_Min = 0;
    int Progress_Max = 550;
    int Progress_Init = 0;

    public FlashcardPanel(){

        super();
        init();
        flashcard();
    }


    private void init(){

        setLayout(null);

        JButton back = new JButton("Back");
        back.setFont(new Font("Thoma", Font.BOLD, 18));
        back.setBounds(190,380,120,45);
        back.setFocusable(false);
        back.setIcon(new ImageIcon("Back.png"));
        back.setIconTextGap(10);
        add(back);

        JButton roll = new JButton("Roll");
        roll.setFont(new Font("Thoma", Font.BOLD, 18));
        roll.setBounds(340,380,120,45);
        roll.setFocusable(false);
        roll.setIcon(new ImageIcon("Roll.png"));
        roll.setIconTextGap(10);
        add(roll);

        JButton next = new JButton("Next");
        next.setFont(new Font("Thoma", Font.BOLD, 18));
        next.setBounds(490,380,120,45);
        next.setFocusable(false);
        next.setHorizontalTextPosition(SwingConstants.LEFT);
        next.setIcon(new ImageIcon("Next.png"));
        next.setIconTextGap(10);
        add(next);

        JProgressBar progress = new JProgressBar();
        progress.setBounds(50, 440, 700, 20);
        progress.setMaximum(Progress_Max);
        progress.setMinimum(Progress_Min);
        progress.setValue(200); //przykladowa wartosc
        progress.setStringPainted(true);
        progress.setBorder(BorderFactory.createLoweredBevelBorder());
        progress.setForeground(new Color(104,130,106));
        add(progress);

        JButtonBox check = new JButtonBox(false);
        check.setLocation(665, 385);
        check.setSize(35,35);
        //check.setOpaque(false);
        check.setFocusable(false);
        add(check);

    }

    private void flashcard(){

        JPanel flashcard = new JPanel();
        flashcard.setBounds(100, 50, 600, 315);
        flashcard.setLayout(null);
        flashcard.setBorder(BorderFactory.createLineBorder(Color.black));
        add(flashcard);

            JTextPane word = new JTextPane();
            word.setFont(new Font("Thoma", Font.BOLD, 40));
            word.setBounds(100,70,400,150);
            word.setEnabled(false);
            //word.setText("Test"); //test
            //word.setBorder(BorderFactory.createLineBorder(Color.black)); //test
                StyledDocument docc = word.getStyledDocument();
                SimpleAttributeSet centerr = new SimpleAttributeSet();
                StyleConstants.setAlignment(centerr, StyleConstants.ALIGN_CENTER);
                docc.setParagraphAttributes(0, docc.getLength(), centerr, false);
                flashcard.add(word);


            JTextPane note = new JTextPane();
            note.setFont(new Font("Thoma", Font.PLAIN, 15));
            note.setBounds(100,240, 400,50);
            note.setEnabled(false);
            //note.setText("NoteNoteNoteNoteNoteNoteNoteNo teNoteNoteNoteNoteNoteNot eNoteNoteNoteNote"); //test
            //note.setBorder(BorderFactory.createLineBorder(Color.black)); //test
                StyledDocument doc = note.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
                doc.setParagraphAttributes(0, doc.getLength(), center, false);
                flashcard.add(note);

            JTextField indexLevel = new JTextField();
            indexLevel.setBounds(555, 270, 40,20);
            indexLevel.setFont(new Font("Thoma", Font.PLAIN, 15));
            indexLevel.setEnabled(false);
            indexLevel.setBorder(null);
            //indexLevel.setBorder(BorderFactory.createLineBorder(Color.black)); //test
            indexLevel.setHorizontalAlignment(JTextField.CENTER);
            //indexLevel.setText("H"); //test
            flashcard.add(indexLevel);

            JTextField indexNum = new JTextField();
            indexNum.setBounds(555, 290, 40,20);
            indexNum.setFont(new Font("Thoma", Font.PLAIN, 15));
            indexNum.setEnabled(false);
            indexNum.setBorder(null);
            //indexNum.setBorder(BorderFactory.createLineBorder(Color.black)); //test
            indexNum.setHorizontalAlignment(JTextField.CENTER);
            //indexNum.setText("Num"); //test
            flashcard.add(indexNum);

    }

    private class JButtonBox extends JButton {

        private BufferedImage checkBox;
        private boolean isChecked;
        public JButtonBox(boolean isChecked){

            super();
            try{

                checkBox = ImageIO.read(new File("CheckBoxSelected.png"));
            }catch(IOException e){

                e.printStackTrace();

            }

            this.isChecked = isChecked;
            this.createMousEvent(this);

        }


        public void createMousEvent(JButtonBox b) {

            b.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    b.setChecked(!b.isChecked);
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }

        @Override
        protected void paintComponent(Graphics g){

            super.paintComponent(g);
            if(isChecked){

                Graphics2D g2 = (Graphics2D) g;
                g2.drawImage(checkBox, 0,0,this.getWidth(),this.getHeight(),this);

            }

        }

        public boolean IsChecked(){return isChecked;}
        public void setChecked(boolean isChecked){this.isChecked = isChecked;}

    }

}
