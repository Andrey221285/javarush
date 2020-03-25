package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int a = 0; a < 10; a++) {
            list.add(Integer.parseInt(key.readLine()));//напишите тут ваш код
        }

        int dlina = 1;
        int max = 1;
        int i = list.get(0);
        for (int a = 1; a < list.size(); a++) {
            if (i == list.get(a)) {
                dlina++;

                if (dlina > max) {
                    max=dlina;
                }
            } else {
                i = list.get(a);
                dlina = 1;
            }



        }
        System.out.println(max);
    }
}