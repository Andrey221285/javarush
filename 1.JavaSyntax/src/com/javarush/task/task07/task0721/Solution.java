package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        int[]numbers = new int[20];
        for (int a=0;a<numbers.length;a++){
            numbers[a]= Integer.parseInt(reader.readLine());//напишите тут ваш код
        }
        maximum = numbers[0];
        for (int b =1;b<numbers.length;b++){
            if (maximum<numbers[b]){
                maximum = numbers[b];
            }
        }
        minimum = numbers[0];
        for (int c=1;c<numbers.length;c++){
            if(minimum>numbers[c]){
                minimum = numbers[c];
            }
        }

        System.out.print(maximum+" ");
        System.out.println(minimum);
    }
}
