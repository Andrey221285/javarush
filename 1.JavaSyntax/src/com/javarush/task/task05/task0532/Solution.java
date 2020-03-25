package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int number [] = new int[N];
        for (int a=0;a<number.length;a++){
            number[a]= Integer.parseInt(reader.readLine());
        }
        int maximum = number[0];
        for(int b = 1;b<number.length;b++){
            if(number[b]>maximum){
                maximum=number[b];
            }
        }

        //напишите тут ваш код

        System.out.println(maximum);
    }
}
