package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader key = new BufferedReader (new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for (int a =0; a<5;a++){
            list.add(key.readLine());//напишите тут ваш код
        }
        for (int b=0;b<13;b++){
            String s =list.get(4);
            list.remove(4);
            list.add(0,s);
        }
        for (int c = 0; c<list.size();c++){
            System.out.println(list.get(c));
        }
    }
}
