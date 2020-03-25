package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader key = new BufferedReader (new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for(int a =0;a<10;a++){
            list.add(key.readLine());// Считать строки с консоли и объявить ArrayList list тут
        }

        ArrayList<String> result = doubleValues(list);

        for (String b : result){
            System.out.println(b);// Вывести на экран result
        }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        ArrayList<String> doublelist = new ArrayList<String>();
        for (int c=0;c<list.size();c++){
            doublelist.add(list.get(c));
            doublelist.add(list.get(c));//напишите тут ваш код
        }
        return doublelist;
    }
}
