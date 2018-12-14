package com.github.trolleydilemma.gui;

import javax.swing.*;
import java.awt.*;

public class ListPanel extends MainPanel {

    public ListPanel(){

        super();
        init();

    }

    private void init(){

        words = new JTextArea();
        words.setFont(new Font("Thoma", Font.BOLD, 18));
        words.setEditable(false);

        scrollP = new JScrollPane(words, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollP.setBounds(40,20,720,440);
        add(scrollP);

    }

    public void setText(String text) { words.setText(text); }

    private JTextArea words;
    private JScrollPane scrollP;

/* TODO: pobwaic sie overridem
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Color color = null;
        JScrollBar sb = (JScrollBar) c;
        if (!sb.isEnabled() || r.width > r.height) {
            return;
        } else if (isDragging) {
            color = Color.DARK_GRAY;
        } else if (isThumbRollover()) {
            color = Color.LIGHT_GRAY;
        } else {
            color = Color.GRAY;
        }
        g2.setPaint(color);
        g2.fillRoundRect(r.x, r.y, r.width, r.height, 10, 10);
        g2.setPaint(Color.WHITE);
        g2.drawRoundRect(r.x, r.y, r.width, r.height, 10, 10);
        g2.dispose();
    }
*/
}


