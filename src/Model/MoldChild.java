package Model;

import java.awt.*;
import java.util.List;

public class MoldChild extends Mold {
    private MoldHead parent;
    //private static final Color COLOR = new Color(178,220,100);


    public MoldChild(int x, int y, MoldHead parent){
        this.x = x;
        this.y = y;
        this.parent = parent;
        setColor();


    }


    public void setColor() {
        // finish grab index fromlist of children
        List<Mold> colorList = parent.getAllChildren();
        int size = colorList.size();

        int r = size % 255;
        int g = size % 255;
        int b = size % 255;

        color = new Color(r,g,b);


    }




    @Override
    public void draw(Graphics g) {
        Color savedCol = g.getColor();
        g.setColor(color);
        g.fillRect(getX() - SIZE/ 2, getY()- SIZE / 2, SIZE, SIZE);

    }

    @Override
    public void grow() {

    }
}
