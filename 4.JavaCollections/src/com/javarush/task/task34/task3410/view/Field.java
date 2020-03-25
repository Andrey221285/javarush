package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.*;
import com.javarush.task.task34.task3410.model.Box;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

public class Field extends JPanel {
    private View view;
    private EventListener eventListener;

    public Field(View view) {
        this.view = view;
        KeyHandler keyHandler = new KeyHandler();
        addKeyListener(keyHandler);
        setFocusable(true);
    }

    public void paint(Graphics g) {
        g.setColor(new Color(0x000000));
        g.fillRect(0, 0, 500, 500);
        Set<GameObject> gameObjects = view.getGameObjects().getAll();
        for (GameObject go : gameObjects) {
            go.draw(g);
        }

    }

    public class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case 0x25:
                    eventListener.move(Direction.LEFT);
                    break;
                case 0x26:
                    eventListener.move(Direction.UP);
                    break;
                case 0x27:
                    eventListener.move(Direction.RIGHT);
                    break;
                case 0x28:
                    eventListener.move(Direction.DOWN);
                    break;
                case 0x52:
                    eventListener.restart();
                    break;
            }
        }
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
}
