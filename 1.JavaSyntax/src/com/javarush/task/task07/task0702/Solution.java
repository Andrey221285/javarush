package com.javarush.task.task07.task0702;

import java.io.*;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String [] mas = new String[10];
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<8;i++){
            mas[i] = key.readLine();//напишите тут ваш код
        }

        for (int a = 9;a>=0;a--){
            System.out.println(mas[a]);
        }
    }
}