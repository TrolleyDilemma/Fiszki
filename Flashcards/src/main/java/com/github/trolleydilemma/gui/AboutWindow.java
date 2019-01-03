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

        JLabel cpr = new JLabel("Coppyright: © 2019");
        cpr.setFont(new Font("Arial", Font.PLAIN, 14));
        cpr.setBounds(130, 180, 300,50);
        add(cpr);

        JLabel first = new JLabel("Alicja Gronkiewicz");
        first.setFont(new Font("Arial", Font.PLAIN, 14));
        first.setBounds(130, 210, 300,50);
        add(first);

        JLabel second = new JLabel("Michał Głogowski");
        second.setFont(new Font("Arial", Font.PLAIN, 14));
        second.setBounds(130, 230, 300,50);
        add(second);

        JLabel third = new JLabel("Błażej Żurawik");
        third.setFont(new Font("Arial", Font.PLAIN, 14));
        third.setBounds(130, 250, 300,50);
        add(third);

        JLabel fourth = new JLabel("Krzysztof Berda");
        fourth.setFont(new Font("Arial", Font.PLAIN, 14));
        fourth.setBounds(130, 270, 300,50);
        add(fourth);

        JLabel fifth = new JLabel("Bartosz Pietruszyński");
        fifth.setFont(new Font("Arial", Font.PLAIN, 14));
        fifth.setBounds(130, 290, 300,50);
        add(fifth);

        JLabel git = new JLabel("GitHub: TrolleyDilemma");
        git.setFont(new Font("Arial", Font.PLAIN, 14));
        git.setBounds(130, 330, 300,30);
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
        add(git);

        JLabel license = new JLabel("License: MIT");
        license.setFont(new Font("Arial", Font.PLAIN, 14));
        license.setBounds(130, 340, 300,50);
        add(license);

        JButton ok = new JButton("Ok");
        ok.setFont(new Font("Arial", Font.PLAIN, 14));
        ok.setBounds(400, 390, 60,30);
        ok.addActionListener(x -> dispose());
        add(ok);

        this.setModal(true);
        this.setVisible(true);

    }
}
