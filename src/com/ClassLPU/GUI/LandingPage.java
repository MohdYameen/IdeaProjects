package com.ClassLPU.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LandingPage extends JFrame implements MouseListener, MouseMotionListener, KeyListener, WindowListener {
    JButton mouseTest;
    JTextField keyTest;

    @Override
    public void keyTyped(KeyEvent ke) {
        System.out.println("Key Typed " + ke.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        System.out.println("Key Pressed " + ke.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        System.out.println("Key Released " + ke.getKeyCode());
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("Clicked");
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        System.out.println("Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        System.out.println("Released");
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        System.out.println("Entered");

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        System.out.println("Exited");
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        System.out.println("Dragged");
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        System.out.println("Moved");
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {
        System.out.println("Opened");
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        System.out.println("Did you click on close button? ");
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {
        System.out.println("Closed");
    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {
        System.out.println("Minimize");
    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {
        System.out.println("Maximized");
    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {
        System.out.println("Activated");
    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {
        System.out.println("Deactivated");
    }


    public LandingPage() {
        super("LandingPage");
        keyTest = new JTextField();
        mouseTest = new JButton("Testing Mouse Events");
        add(keyTest, BorderLayout.NORTH);
        keyTest.addKeyListener(this);
        add(mouseTest, BorderLayout.SOUTH);
        mouseTest.addMouseListener(this);
        this.addMouseListener(this);
        this.addWindowListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    }

}