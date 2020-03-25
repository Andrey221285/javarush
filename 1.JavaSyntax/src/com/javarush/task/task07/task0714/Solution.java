package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader key = new BufferedReader (new InputStreamReader(System.in));
        ArrayList<String>list = new ArrayList<String>();
            for (int a=0;a<5;a++){
            list.add(key.readLine());//напишите тут ваш код
        }
        list.remove(2);
        for (int b = list.size()-1;b>=0;b--){
            System.out.println(list.get(b));
        }

    }
}


