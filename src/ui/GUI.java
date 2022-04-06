package ui;

import Model.FungusArena;

import javax.swing.*;
import java.awt.event.*;

public class GUI extends JFrame {

    private static final int INTERVAL = 20;

    private FungusArena arena;
    private ArenaPanel ap;

    private Timer t1;

    public GUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        arena = new FungusArena();
        ap = new ArenaPanel(arena);
        add(ap);
        pack();
        setVisible(true);
        addMouseListener(new MouseHandler());
        addTimer();
        t1.start();
    }

    private void addTimer() {
        t1 = new Timer(INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arena.update();
                ap.repaint();
            }
        });
    }

    private class MouseHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            arena.mouseClick(x, y);

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
    }


    public static void main(String[] args) {new GUI();}
}
