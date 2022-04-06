package Model;

import java.awt.*;

public abstract class Mold {
    protected int x;
    protected int y;

    protected static final int SIZE = 1;
    //protected static final Color COLOR =new Color(0,128, 0);
    protected Color color;


    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Color getColor() {
        return color;
    }



    public abstract void draw(Graphics g);


    public abstract void grow();





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mold mold = (Mold) o;

        return y == mold.y && x == mold.x;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }


}
