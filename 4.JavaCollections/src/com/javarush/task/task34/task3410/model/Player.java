package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Player extends CollisionObject implements Movable {
    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void move(int x, int y) {
        this.setX(this.getX()+x);
        this.setY(this.getY()+y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(0xFFFF00));
        graphics.fillOval(getX()-Model.FIELD_CELL_SIZE/2,getY()-Model.FIELD_CELL_SIZE/2,getWidth(),getHeight());
    }
}
