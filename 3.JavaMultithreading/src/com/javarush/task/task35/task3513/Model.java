package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {

    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] temp = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for(int i=0;i<FIELD_WIDTH;i++){
            for(int j=0;j<FIELD_WIDTH;j++){
                temp[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(temp);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void randomMove(){
        int n = ((int) (Math.random() * 100)) % 4;

        switch (n){
            case (0):
                left();
                break;
            case (1):
                right();
                break;
            case (2):
                up();
                break;
            case (3):
                down();
                break;
        }
    }

    public void rollback() {
        if (!previousStates.empty() && !previousScores.empty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        if (getEmptyTiles().size() > 0) {
            return true;
        } else {
            for (int i = 0; i < FIELD_WIDTH - 1; i++) {
                for (int j = 0; j < FIELD_WIDTH - 1; j++) {
                    if (gameTiles[i][j].value == gameTiles[i][j + 1].value || gameTiles[i][j].value == gameTiles[i + 1][j].value) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean isChange = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {

            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                isChange = true;
            }
        }
        if (isChange) {

            addTile();
        }
        isSaveNeeded = true;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isCompressed = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            for (int j = 0; j < tiles.length - 1; j++) {
                if (tiles[j].isEmpty() && !tiles[j + 1].isEmpty()) {
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = new Tile();
                    isCompressed = true;
                }
            }
        }
        return isCompressed;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isMerges = false;
        for (int j = 0; j < tiles.length - 1; j++) {
            if (tiles[j].value == tiles[j + 1].value && !tiles[j].isEmpty() && !tiles[j + 1].isEmpty()) {
                tiles[j].value = tiles[j].value * 2;
                isMerges = true;
                score += tiles[j].value;
                maxTile = maxTile > tiles[j].value ? maxTile : tiles[j].value;
                tiles[j + 1] = new Tile();
                compressTiles(tiles);
            }
        }
        return isMerges;
    }

    void right() {
        saveState(gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    void up() {
        saveState(gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    void down() {
        saveState(gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    private void rotate() {
        Tile[][] temp = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int m = 0; m < FIELD_WIDTH; m++) {
            for (int n = 0; n < FIELD_WIDTH; n++) {
                temp[n][FIELD_WIDTH - 1 - m] = gameTiles[m][n];
            }
        }
        gameTiles = temp;
    }


    void resetGameTiles() {
        score = 0;
        maxTile = 0;
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();

    }

    private void addTile() {
        if (!getEmptyTiles().isEmpty()) {
            getEmptyTiles().get((int) (getEmptyTiles().size() * Math.random())).value = (Math.random() < 0.9 ? 2 : 4);
        }

    }

    private List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0) {
                    list.add(gameTiles[i][j]);
                }
            }
        }
        return list;
    }
    private  boolean hasBoardChanged(){
        int first=0;
        int second =0;
        for(int i=0;i<FIELD_WIDTH;i++){
            for(int j=0;j<FIELD_WIDTH;j++){
                first+=gameTiles[i][j].value;
                second+= previousStates.peek()[i][j].value;
            }
        }
        if(first==second){
            return false;
        }
        else return true;
    }

    private MoveEfficiency getMoveEfficiency(Move move){

        move.move();
        if(hasBoardChanged()){
            rollback();
            return new MoveEfficiency(getEmptyTiles().size(),score,move);

        }
        else {
            rollback();
            return new MoveEfficiency(-1,0,move);
        }

    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue(4, Collections.reverseOrder());
        queue.add(getMoveEfficiency(this::left));
        queue.add(getMoveEfficiency(this::right));
        queue.add(getMoveEfficiency(this::up));
        queue.add(getMoveEfficiency(this::down));
        Move move = queue.peek().getMove();
        move.move();
    }
}
