package com.github.trolleydilemma.gui;

import com.github.trolleydilemma.core.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class HelpWindow extends JDialog {

    public HelpWindow(Frame window){

        super(App.getWindow());
        init();

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

    }

    private void init(){

        this.setTitle("Help");
        this.setVisible(true);
        this.setLocationRelativeTo(App.getWindow());
        this.setSize(1200,800);
        this.setLayout(null);
        this.setResizable(false);
        this.setModal(true);

        JEditorPane helpWindow = new JEditorPane();
        helpWindow.setBounds(0,0,1085,680);
        helpWindow.setEditable(true);

        try {
            URL url = getClass().getResource("/index.html");
            System.out.println(url);
            helpWindow.setPage(url);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane scroll = new JScrollPane(helpWindow);
        scroll.setBounds(57,25,1085,680);
        add(scroll);


        ok = new JButton("Ok");
        ok.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ok.setBounds(1120, 730, 60,30);
        add(ok);

    }

    private void onOK() {
        dispose();
    }

    private JButton ok;
}

