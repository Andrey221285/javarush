package com.javarush.task.task07.task0704;

import java.io.*;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
        int[]numbers = new int[10];
        for(int i = 0;i<numbers.length; i++){
            numbers[9-i] = Integer.parseInt(key.readLine());//напишите тут ваш код
        }
        for(int a  = 0;a<numbers.length;a++){
            System.out.println(numbers[a]);
        }
    }
}

