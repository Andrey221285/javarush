package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileInputStream input = new FileInputStream(filename);
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        int min = input.available();

        while (input.available() > 0) {
            int data = input.read();
            list.add(data);
            set.add(data);
        }
        reader.close();
        input.close();

        for (int x : set) {
            int a = 0;
            for (int y : list) {
                if (x == y) {
                    a++;
                }
            }
            if (a < min) {
                min = a;
            }
        }
        for (int x : set) {
            int a = 0;
            for (int y : list){
                if (x == y){
                    a++;
                }
            }
            if (a == min){
                System.out.print(x + " ");
            }
        }

    }

}
