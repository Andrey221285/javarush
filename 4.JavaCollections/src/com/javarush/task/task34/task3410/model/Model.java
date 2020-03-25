package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Paths;


public class Model {
    public static int FIELD_CELL_SIZE = 20;

    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("C:\\Users\\Andrey\\YandexDisk\\Java\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task34\\task3410\\res\\levels.txt"));

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restart();
    }

    public void move(Direction direction) {
        if (checkWallCollision(gameObjects.getPlayer(), direction)) {
            return;
        } else if (checkBoxCollisionAndMoveIfAvaliable(direction)) {
            return;
        } else {
            switch (direction.ordinal()) {
                case 0:
                    gameObjects.getPlayer().move(-Model.FIELD_CELL_SIZE, 0);
                    break;
                case 1:
                    gameObjects.getPlayer().move(Model.FIELD_CELL_SIZE, 0);
                    break;
                case 2:
                    gameObjects.getPlayer().move(0, -Model.FIELD_CELL_SIZE);
                    break;
                case 3:
                    gameObjects.getPlayer().move(0, Model.FIELD_CELL_SIZE);
                    break;
            }
            checkCompletion();
        }

    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall w : gameObjects.getWalls()) {
            if (gameObject.isCollision(w, direction)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction) {

        Player player = gameObjects.getPlayer();

        // найдем во что уперся игрок
        GameObject stoped = null;
        for (GameObject gameObject : gameObjects.getAll()) {
            if (!(gameObject instanceof Player) && !(gameObject instanceof Home) && player.isCollision(gameObject, direction)) {
                stoped = gameObject;
            }
        }
        //свободное место или дом
        if ((stoped == null)) {
            return false;
        }
        if (stoped instanceof Box) {
            Box stopedBox = (Box) stoped;
            if (checkWallCollision(stopedBox, direction)) {
                return true;
            }
            for (Box box : gameObjects.getBoxes()) {
                if (stopedBox.isCollision(box, direction)) {
                    return true;
                }
            }
            switch (direction) {
                case LEFT:
                    stopedBox.move(-Model.FIELD_CELL_SIZE, 0);
                    break;
                case RIGHT:
                    stopedBox.move(Model.FIELD_CELL_SIZE, 0);
                    break;
                case UP:
                    stopedBox.move(0, -Model.FIELD_CELL_SIZE);
                    break;
                case DOWN:
                    stopedBox.move(0, Model.FIELD_CELL_SIZE);
            }
        }
        return false;
    }

        public void checkCompletion() {
        int count = 0;
        for (Box b : gameObjects.getBoxes()) {
            for (Home h : gameObjects.getHomes()) {
                if (b.getX() == h.getX() && b.getY() == h.getY()) {
                    count++;
                    break;
                }
            }
        }
        if (count == gameObjects.getBoxes().size()) {
            eventListener.levelCompleted(currentLevel);
        }
    }

}
