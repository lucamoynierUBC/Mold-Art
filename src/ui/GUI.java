package ui;

import Model.FungusArena;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private static final int INTERVAL = 1;

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

    public static void main(String[] args) {new GUI();}
}
