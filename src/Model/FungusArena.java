package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FungusArena {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final Random RND = new Random();



    private List<Mold> fungus;
    private MoldHead test;



    public FungusArena(){
        fungus = new ArrayList<Mold>();
        test = new MoldHead(300, 300, null);
        test.setOrigin();


    }

    public void update() {
        test.grow();
    }

    public void draw(Graphics g) {
        test.draw(g);
    }











}
