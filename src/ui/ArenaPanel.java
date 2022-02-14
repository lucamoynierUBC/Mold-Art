package ui;

import Model.FungusArena;

import javax.swing.*;
import java.awt.*;

public class ArenaPanel extends JPanel {

    private FungusArena arena;

    public ArenaPanel(FungusArena a){
        setPreferredSize(new Dimension(FungusArena.WIDTH, FungusArena.HEIGHT));
        setBackground(Color.black);
        arena = a;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawArena(g);
    }

    private void drawArena(Graphics g) {arena.draw(g);}
}
