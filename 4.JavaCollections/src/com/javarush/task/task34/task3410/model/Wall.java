package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Wall extends CollisionObject {
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(0x4B1900));
        graphics.fillRect(getX()-Model.FIELD_CELL_SIZE/2,getY()-Model.FIELD_CELL_SIZE/2,getWidth(),getHeight());

    }
}
