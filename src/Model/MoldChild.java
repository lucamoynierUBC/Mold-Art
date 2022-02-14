package Model;

import java.awt.*;

public class MoldChild extends Mold {
    private MoldHead parent;

    public MoldChild(int x, int y, MoldHead parent){
        this.x = x;
        this.y = y;
        this.parent = parent;
    }


    @Override
    public void draw(Graphics g) {
        Color savedCol = g.getColor();
        g.setColor(COLOR);
        g.fillRect(getX() - SIZE/ 2, getY()- SIZE / 2, SIZE, SIZE);

    }

    @Override
    public void grow() {

    }
}
