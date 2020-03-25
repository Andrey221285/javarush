package com.javarush.task.task08.task0824;

import java.util.ArrayList;
/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        Human c1 = new Human ("Andrey", true,31);
        Human c2 = new Human("Alexey", true,29);
        Human c3 = new Human("Anna", false, 23);
        Human m = new Human("Alla", false, 58,c1,c2,c3);
        Human f = new Human("Andrey",true, 55,c1,c2,c3);
        Human gm1 = new Human("Albina", false,77,m);
        Human gf1 = new Human("Vasily",true, 78,m);
        Human gm2 = new Human("Galina", false,76,f);
        Human gf2 = new Human("Alexey", true,66,f);
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
        System.out.println(m.toString());
        System.out.println(f.toString());
        System.out.println(gm1.toString());
        System.out.println(gf1.toString());
        System.out.println(gm2.toString());
        System.out.println(gf2.toString());//напишите тут ваш код
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age= age;
            this.children = new ArrayList<Human>();

        }//напишите тут ваш код

        public Human(String name, boolean sex, int age, Human ...children) {
            this(name,sex,age);
           /* this.name = name;
            this.sex = sex;
            this.age = age;*/
           // this.children = new ArrayList<Human>();
            for(Human child : children){
                this.children.add(child);
            }
        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
