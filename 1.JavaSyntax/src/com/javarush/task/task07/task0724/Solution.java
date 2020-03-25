package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human h1 = new Human("Alexey", true, 65);
        Human h2 = new Human ("Galina", false, 60);
        Human h3 = new Human ("Andrey", true, 54, h1, h2);
        Human h4 = new Human ("Vasiliy", true, 77);
        Human h5 = new Human ("Albina", false, 66);
        Human h6 = new Human ("Alla", false, 58,h4, h5);
        Human h7 = new Human ("And", true, 31, h3, h6);
        Human h8 = new Human ("Alex",true, 28,h3,h6);
        Human h9 = new Human ("Anna", false,24,h3,h6);

        System.out.println(h1.toString());
        System.out.println(h2.toString());
        System.out.println(h3.toString());
        System.out.println(h4.toString());
        System.out.println(h5.toString());
        System.out.println(h6.toString());
        System.out.println(h7.toString());
        System.out.println(h8.toString());
        System.out.println(h9.toString());//напишите тут ваш код
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;//напишите тут ваш код

        public Human (String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human (String name, boolean sex,int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















