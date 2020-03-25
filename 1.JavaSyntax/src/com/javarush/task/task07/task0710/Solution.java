package com.javarush.task.task07.task0710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
В начало списка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));

        for (int a = 0;a<10;a++){
            list.add(0, key.readLine());//напишите тут ваш код
        }
        for(int b = 0;b<list.size();b++){
            System.out.println(list.get(b));
        }
    }
}
