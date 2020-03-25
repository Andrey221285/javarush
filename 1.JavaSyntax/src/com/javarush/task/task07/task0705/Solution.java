package com.javarush.task.task07.task0705;

import java.io.*;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        int[]big = new int[20];
        int[]m1 = new int[10];
        int[]m2= new int[10];
        for (int i = 0;i<big.length;i++){
            big[i] = Integer.parseInt(input.readLine());
        }
        for (int a = 0;a<m1.length;a++){
            m1[a] = big[a];
        }
        for (int b = 0;b<m2.length;b++){
            m2[b] = big[10+b];
        }
        for(int c = 0;c<m2.length;c++){
            System.out.println(m2[c]);
        }
    }
}
