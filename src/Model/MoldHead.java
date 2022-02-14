package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoldHead extends Mold {
    // protected color

    private List<Mold> children;
    private List<Mold> allChildren;
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





    }

    public List<Mold> getChildren() {
        return children;
    }


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
        if (!allChildren.contains(child) && children.contains(child)) {
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

    @Override
    public void draw(Graphics g) {
        Color savedCol = g.getColor();
        g.setColor(COLOR);
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

        if (children.size() < 20 && allChildren.size() < 2000) {

            if (growDirection < 20) {
                this.addChildEast();
            } else if (growDirection < 40 && growDirection > 20) {
                this.addChildWest();
            } else if (growDirection > 40 && growDirection < 60) {
                this.addChildNorth();
            } else if (growDirection > 60 && growDirection < 80) {
                this.addChildSouth();
            } else if (growDirection > 80 && growDirection < 83) {
                this.addHeadEast();
            } else if (growDirection > 83 && growDirection < 85) {
                this.addHeadWest();
            } else if (growDirection > 85 && growDirection < 87) {
                this.addHeadNorth();
            } else if (growDirection > 87) {
                this.addHeadSouth();
            }
        }
    }


}














