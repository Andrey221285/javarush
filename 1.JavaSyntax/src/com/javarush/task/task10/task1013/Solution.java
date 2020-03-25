package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {


    }

    public static class Human {
       private String name;
        private String lastname;
        private int age;
        private int weight;
        private Human mama;
        private Human papa;

        public Human(int weight, Human mama) {
            this.weight = weight;
            this.mama = mama;
        }

        public Human(String lastname, int age) {

            this.lastname = lastname;
            this.age = age;
        }

        public Human(String name, String lastname, int age, int weight, Human mama, Human papa) {

            this.name = name;
            this.lastname = lastname;
            this.age = age;
            this.weight = weight;
            this.mama = mama;
            this.papa = papa;
        }

        public Human(String name, String lastname, int age, int weight, Human mama) {

            this.name = name;
            this.lastname = lastname;
            this.age = age;
            this.weight = weight;
            this.mama = mama;
        }

        public Human(String name, String lastname, int age, int weight) {

            this.name = name;
            this.lastname = lastname;
            this.age = age;
            this.weight = weight;
        }

        public Human(String name, String lastname, int age) {

            this.name = name;
            this.lastname = lastname;
            this.age = age;
        }

        public Human(String name, String lastname) {

            this.name = name;
            this.lastname = lastname;
        }

        public Human(String name) {

            this.name = name;
        }

        public Human() {

        }
        public Human (Human h){

        }
        // напишите тут ваши переменные и конструкторы
    }
}
