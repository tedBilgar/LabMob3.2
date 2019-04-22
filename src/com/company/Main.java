package com.company;

import sun.awt.X11.Screen;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        MyPanel panel = new MyPanel();
        JFrame myFrame = new LabFrame();

        myFrame.add(panel);
        myFrame.setVisible(true);
    }
}

class LabFrame extends JFrame{
  LabFrame(){
        super("Лабораторная работа №3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,400);
    }

}

class MyPanel extends JPanel{
    public MyPanel(){
        repaint();
    }
    public void paint(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(10,10,100,100);
    }
}