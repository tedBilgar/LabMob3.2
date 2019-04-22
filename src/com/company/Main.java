package com.company;

import sun.awt.X11.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {

    public static void main(String[] args) {
        MyPanel panel = new MyPanel();
        LabFrame myFrame = new LabFrame();
        int click=0;

        myFrame.add(panel);
        myFrame.setVisible(true);

        class TimeListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.move(panel.getxDirection(),panel.getyDirection());
            }
        }


        ActionListener listener = new TimeListener();
        Timer timer = new Timer(50,listener);
        timer.start();

        myFrame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                (myFrame).setClick((myFrame).getClick()+1);
                if((myFrame).getClick() == 2) {
                    (myFrame).setClick(0);
                    (myFrame).changeColor();
                }
                else panel.doReverse();
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
}

class LabFrame extends JFrame{
    private int color = 0;
    private int click = 0;
    private JPanel jPanel;

    LabFrame(){
        super("Лабораторная работа №3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,400);

    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public void changeColor(){
        color++;
        if(color == 0){
            getContentPane().setBackground(Color.BLUE);
        }
        if(color == 1){
            getContentPane().setBackground(Color.WHITE);
        }
        if(color == 2){
            getContentPane().setBackground(Color.YELLOW);
        }
        if(color == 3){
            color = -1;
            getContentPane().setBackground(Color.GREEN);
        }
    }
}

class MyPanel extends JComponent{
    private Rectangle rectangle;
    private int xDirection = 4;
    private int yDirection = 1;
    private int click = 0;
    private int color = 0;

    public MyPanel(){
        rectangle = new Rectangle(10,10,80,50);
    }

    public int getxDirection() {
        return xDirection;
    }

    public int getyDirection() {
        return yDirection;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
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
    public void doReverse(){
        if (xDirection == 4 && yDirection == 1){
            xDirection = -4;
            yDirection = -1;
        }else{
            xDirection = 4;
            yDirection = 1;
        }
    }

}