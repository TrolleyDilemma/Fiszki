package com.github.trolleydilemma.gui;

import com.github.trolleydilemma.core.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutWindow extends JDialog {

    public AboutWindow(Frame window){

        super(App.getWindow());
        init();

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

    }

    private void init(){

        this.setTitle("About");
        this.setVisible(true);
        this.setLocationRelativeTo(App.getWindow());
        this.setSize(500,350);
        this.setLayout(null);
        this.setResizable(false);
        this.setModal(true);

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/LogiIcon.png"));
        JLabel obrazek = new JLabel(icon);
        obrazek.setBounds(175,10,125,125);
        add(obrazek);

        JLabel name = new JLabel("Flashcards 1.0.0");
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        name.setBounds(125, 130, 300,50);
        add(name);

        JLabel cpr = new JLabel("Coppyright: ©Flashcards. All rights reserved");
        cpr.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cpr.setBounds(130, 180, 300,50);
        add(cpr);

        JLabel year = new JLabel("Publishment: 2018");
        year.setFont(new Font("Tahoma", Font.PLAIN, 14));
        year.setBounds(130, 210, 300,50);
        add(year);

        ok = new JButton("Ok");
        ok.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ok.setBounds(400, 270, 60,30);
        add(ok);
    }

    private void onOK() {
        dispose();
    }

    private JButton ok;
}
