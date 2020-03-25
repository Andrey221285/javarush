package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    public static ArrayList cats = new ArrayList();//напишите тут ваш код

    public Cat() {
    }

    public static void main(String[] args) {
        for(int i = 0;i<10;i++){
            Cat.cats.add(new Cat());//напишите тут ваш код
        }
        printCats();
    }

    public static void printCats() {
        for (int a = 0;a<cats.size();a++){
            System.out.println(Cat.cats.get(a));//напишите тут ваш код
        }
    }
}
