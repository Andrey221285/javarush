package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("ппкп");
        list.add("куаку");
        list.add("уак");
        list.add("укак");
        list.add("куакакпа");
        System.out.println(list.size());
        for (int a=0;a<list.size();a++){
            System.out.println(list.get(a));
        }

        //напишите тут ваш код
    }
}
