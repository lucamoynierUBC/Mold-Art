package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoldHead extends Mold {
    //private static final Color COLOR = new Color(0,128,0);

    private List<Mold> children;
    protected List<Mold> allChildren;
    private MoldHead parent;
    private Boolean origin;


    public MoldHead(int x, int y, MoldHead parent) {
        this.x = x;
        this.y = y;
        children = new ArrayList<>();
        origin = false;
        this.parent = parent;
        if (parent != null){
            allChildren = parent.allChildren;
        } else {
            allChildren = new ArrayList<>();
        }
        setColor();









    }



    public List<Mold> getChildren() {
        return children;
    }

    public List<Mold> getAllChildren() { return allChildren;}


    public void setOrigin() {
        origin = true;
    }


    public Mold getLastMold() {
        if (children.isEmpty()) {
            return this;
        } else {
            return children.get(children.size() - 1);
        }
    }

    public void addChildEast() {
        Mold child = new MoldChild(this.getLastMold().getX() + 1, this.getLastMold().getY(), this);
        if (!allChildren.contains(child) && !children.contains(child)) {
            children.add(child);
            allChildren.add(child);
        }
    }

    public void addChildWest() {
        Mold child = new MoldChild(this.getLastMold().getX() - 1, this.getLastMold().getY(), this);
        if (!allChildren.contains(child) && !children.contains(child)) {
            children.add(child);
            allChildren.add(child);
        }
    }

    public void addChildNorth() {
        Mold child = new MoldChild(this.getLastMold().getX(), this.getLastMold().getY() + 1, this);
        if (!allChildren.contains(child) && !children.contains(child)) {
            children.add(child);
            allChildren.add(child);

        }
    }

    public void addChildSouth() {
        Mold child = new MoldChild(this.getLastMold().getX(), this.getLastMold().getY() - 1, this);
        if (!allChildren.contains(child) && !children.contains(child)) {
            children.add(child);
            allChildren.add(child);
        }
    }

    public void addHeadEast() {
        Mold child = new MoldHead(this.getLastMold().getX() + 1, this.getLastMold().getY(), this);
        if (!allChildren.contains(child) && !children.contains(child)) {
            children.add(child);
            allChildren.add(child);

        }
    }

    public void addHeadWest() {
        Mold child = new MoldHead(this.getLastMold().getX() - 1, this.getLastMold().getY(), this);
        if (!allChildren.contains(child) && !children.contains(child)) {
            children.add(child);
            allChildren.add(child);
        }
    }

    public void addHeadNorth() {
        Mold child = new MoldHead(this.getLastMold().getX(), this.getLastMold().getY() + 1, this);
        if (!allChildren.contains(child) && !children.contains(child)) {
            children.add(child);
            allChildren.add(child);
        }
    }

    public void addHeadSouth() {
        Mold child = new MoldHead(this.getLastMold().getX(), this.getLastMold().getY() - 1, this);
        if (!allChildren.contains(child) && !children.contains(child)) {
            children.add(child);
            allChildren.add(child);
        }


    }

    public int generateNum() {
        Random rnd = new Random();
        int result = rnd.nextInt(90);
        return result;

    }
    public void setColor() {
        // finish grab index fromlist of children

        int size = allChildren.size();

        int r = size % 255;
        int g = size % 255;
        int b = size % 255;

        color = new Color(r,g,b);



    }

    @Override
    public void draw(Graphics g) {
        Color savedCol = g.getColor();
        g.setColor(color);
        g.fillRect(getX() - SIZE / 2, getY() - SIZE / 2, SIZE, SIZE);
        for (Mold child : children) {
            child.draw(g);
        }
    }


    @Override
    public void grow() {
        growMold();
        for (Mold child : children) {
            child.grow();

        }
    }


    public void growMold() {
        int growDirection = generateNum();

        if (children.size() < 100 && allChildren.size() < 5000) {

            if (growDirection < 35) {
                for (int i = 0; i < 5; i++) {
                    this.addChildEast();
                }
            } else if (growDirection < 50 && growDirection > 35) {
                for (int i = 0; i < 5; i++) {
                    this.addChildWest();
                }
            } else if (growDirection > 50 && growDirection < 65) {
                for (int i = 0; i < 5; i++) {
                    this.addChildNorth();
                }
            } else if (growDirection > 65 && growDirection < 80) {
                for (int i = 0; i < 5; i++) {
                    this.addChildSouth();
                }
            } else if (growDirection == 80 ) {
                this.addHeadEast();
            } else if (growDirection ==81) {
                this.addHeadWest();
            } else if (growDirection == 82) {
                this.addHeadNorth();
            } else if (growDirection == 83) {
                this.addHeadSouth();
            }
        }
    }


}














