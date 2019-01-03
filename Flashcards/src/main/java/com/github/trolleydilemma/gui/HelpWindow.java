package com.github.trolleydilemma.gui;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Class creating "HelpWindow", containing description and instruction(how to use) for application
 * @author Blazej Zurawik
 */
public class HelpWindow extends JDialog {

    public HelpWindow(JFrame window) {

        super(window);
        init(window);

    }
    /**
     * Method creating and places all containers and buttons in the right spots
     * @param window used in order to start position dialo
     */
    private void init(JFrame window){

        this.setTitle("Help");
        this.setSize(1200,800);
        this.setLocationRelativeTo(window);
        this.setLayout(null);
        this.setResizable(false);

        JEditorPane helpWindow = new JEditorPane();
        helpWindow.setBounds(0,0,1085,680);
        helpWindow.setEditable(false);

        try {
            URL url = getClass().getResource("/index.html");
            helpWindow.setPage(url);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane scroll = new JScrollPane(helpWindow);
        scroll.setBounds(57,25,1085,680);
        add(scroll);


        JButton ok = new JButton("Ok");
        ok.setFont(new Font("Arial", Font.PLAIN, 14));
        ok.setBounds(1120, 730, 60,30);
        ok.addActionListener(x -> dispose());
        add(ok);

        this.setModal(true);
        this.setVisible(true);

    }
}

