package com.javarush.task.task07.task0703;

import java.io.*;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
        int [] numbers  = new int [10];
        String [] word = new String [10];
        for (int i = 0;i<numbers.length;i++){
            word[i] = key.readLine();
            numbers [i] = word[i].length();//напишите тут ваш код
        }
        for (int b = 0;b<numbers.length;b++){
            System.out.println(numbers[b]);
        }
    }
}
