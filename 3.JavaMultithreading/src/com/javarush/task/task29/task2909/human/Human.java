package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
    private static int nextId = 0;
    private int id;
    protected String name;
    protected int age;
    protected Size size;
    private BloodGroup bloodGroup;

    private List<Human> children = new ArrayList<>();

    public void addChild(Human h) {
        children.add(h);
    }

    public void removeChild(Human h) {
        children.remove(children.indexOf(h));
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }


   /* public void setBloodGroup(int code) {
        switch (code) {
            case (1):
                bloodGroup = BloodGroup.first();
                break;
            case (2):
                bloodGroup = BloodGroup.second();
                break;
            case (3):
                bloodGroup = BloodGroup.third();
                break;
            case (4):
                bloodGroup = BloodGroup.fourth();
                break;
        }
    }*/

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Human(boolean isSoldier) {
        //this.isSoldier = isSoldier;
        this.id = nextId;
        nextId++;
    }

    public void live() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return "Человек";
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public class Size {
        public int height;
        public int weight;

    }
}