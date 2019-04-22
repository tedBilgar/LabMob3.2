package com.company;

import sun.awt.X11.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class Main {

    public static void main(String[] args) {
        MyPanel panel = new MyPanel();
        JFrame myFrame = new LabFrame();

        myFrame.add(panel);
        myFrame.setVisible(true);

        class TimeListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.move(4,1);
            }
        }


        ActionListener listener = new TimeListener();
        Timer timer = new Timer(50,listener);
        timer.start();
    }
}

class LabFrame extends JFrame {
  LabFrame(){
        super("Лабораторная работа №3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,400);
    }

}

class MyPanel extends JComponent{
    private Rectangle rectangle;

    public MyPanel(){
        rectangle = new Rectangle(10,10,80,50);
    }
    public void paint(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.draw(rectangle);
        graphics2D.fill(rectangle);
    }
    public void move(int x,int y){
        rectangle.translate(x,y);
        repaint();
    }
}