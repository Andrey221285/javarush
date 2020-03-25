package com.javarush.task.task34.task3410.model;

public abstract class CollisionObject extends GameObject {
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction){

        int a=-1000;
        int b=-1000;

        switch(direction.ordinal()){
            case 0:
                a=this.getX()-Model.FIELD_CELL_SIZE;
                b=this.getY();
                break;
            case 1:
                a=this.getX()+Model.FIELD_CELL_SIZE;
                b=this.getY();
                break;
            case 2:
                a=this.getX();
                b=this.getY()-Model.FIELD_CELL_SIZE;
                break;
            case 3:
                a=this.getX();
                b=this.getY()+Model.FIELD_CELL_SIZE;
                break;
        }
        if(a==gameObject.getX() && b==gameObject.getY()){
            return true;
        }
        else  {
            return false;
        }

    }
}
