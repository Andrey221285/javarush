
package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Cat ded = new Cat(reader.readLine());
        Cat baba = new Cat(reader.readLine());
        Cat papa = new Cat(reader.readLine(),ded,null);
        Cat mama = new Cat(reader.readLine(),null,baba);
        Cat doch = new Cat(reader.readLine(),papa,mama);
        Cat son = new Cat(reader.readLine(),papa,mama);
        System.out.println(ded);
        System.out.println(baba);
        System.out.println(papa);
        System.out.println(mama);
        System.out.println(doch);
        System.out.println(son);
    }

    public static class Cat {
        private String name;
        private Cat father;
        private Cat mother;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat father, Cat mother) {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }

        @Override
        public String toString() {
            String text = "Cat name is "+name;
            text+=mother==null?", no mother":", mother is "+mother.name;
            text+=father==null?", no father":", father is "+father.name;

            return text;
        }
    }

}
