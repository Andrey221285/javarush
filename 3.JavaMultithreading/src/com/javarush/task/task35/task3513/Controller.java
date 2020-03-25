package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private Model model;
    private View view;
    private static final int WINNING_TILE = 2048;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }

    public View getView() {
        return view;
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore(){
        return model.score;
    }

    public void resetGame(){
        model.score=0;
        view.isGameLost=false;
        view.isGameWon=false;
        model.resetGameTiles();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==0x1B){
            resetGame();
            view.repaint();
        }
        if(!model.canMove()){
            view.isGameLost=true;
            view.repaint();
        }
        if(!view.isGameLost && !view.isGameWon) {

            switch (e.getKeyCode()) {
                case (0x25):
                    model.left();
                    break;
                case (0x27):
                    model.right();
                    break;
                case (0x26):
                    model.up();
                    break;
                case (0x28):
                    model.down();
                    break;
                case (0x5A):
                    model.rollback();
                    break;
                case (0x52):
                    model.randomMove();
                    break;
                case (0x41):
                    model.autoMove();
            }
            view.repaint();
        }
        if(model.maxTile==WINNING_TILE){
            view.isGameWon=true;
            view.repaint();
        }

    }
}
