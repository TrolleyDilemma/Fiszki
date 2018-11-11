package com.github.trolleydilemma.gui;

import javax.swing.*;
import java.awt.*;

public class PaintButton extends JButton {

    private JMenuBar painted;

    public PaintButton(){

        super();

     //        changeBackground();
    }

    public void changeBackground(Color color){

        Graphics g = this.getGraphics();

        g.setColor(color);
       // g.fillRect(this.getBounds());
        this.paintComponent(g);

    }

}
