package com.github.trolleydilemma.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Class creating "AboutWindow", containing information about application
 * @author Blazej Zurawik
 */
public class AboutWindow extends JDialog {

    public AboutWindow(JFrame window){

        super(window);
        init(window);

    }

    /**
     * Method creating and places all containers in the right spots
     * @param window used in order to start position dialog
     */
    private void init(JFrame window){

        this.setTitle("About");
        this.setSize(500,470);
        this.setLocationRelativeTo(window);
        this.setLayout(null);
        this.setResizable(false);

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/LogiIcon.png"));
        JLabel obrazek = new JLabel(icon);
        obrazek.setBounds(175,10,125,125);
        add(obrazek);

        JLabel name = new JLabel("Flashcards 1.0.0");
        name.setFont(new Font("Arial", Font.BOLD, 30));
        name.setBounds(125, 130, 300,50);
        add(name);

        createLabel("Coppyright: © 2019",180);
        createLabel("Alicja Gronkiewicz",210);
        createLabel("Michał Głogowski", 230);
        createLabel("Błażej Żurawik",250);
        createLabel("Krzysztof Berda",270);
        createLabel("Bartosz Pietruszyński",290);
        JLabel git = createLabel("GitHub: TrolleyDilemma",330);

        git.setCursor(new Cursor(Cursor.HAND_CURSOR));
        git.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/TrolleyDilemma/Fiszki"));
                } catch (URISyntaxException | IOException ex) {}
            }
        });

        createLabel("License: MIT",350);

        JButton ok = new JButton("Ok");
        ok.setFont(new Font("Arial", Font.PLAIN, 14));
        ok.setBounds(400, 390, 60,30);
        ok.addActionListener(x -> dispose());
        add(ok);

        this.setModal(true);
        this.setVisible(true);

    }

    /**
     * Create label with unified font and add it to the Dialog
     * @param text text visible on the label
     * @param y y coordinate of the label
     * @return label in specific coordinates
     */
    private JLabel createLabel(String text, int y) {

        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setBounds(130, y, 150,50);
        add(label);
        return label;

    }
}
