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
        //fungus.add(test);


    }

    public void update() {
        for (Mold fungi: fungus) {
            fungi.grow();
            test.growMold();
        }
    }

    public void draw(Graphics g) {
        for (Mold fungi: fungus) {
            fungi.draw(g);
        }
    }

    public void mouseClick(int mouseX, int mouseY){
        MoldHead mold = new MoldHead(mouseX, mouseY, null);
        mold.setOrigin();
        fungus.add(mold);







    }











}
