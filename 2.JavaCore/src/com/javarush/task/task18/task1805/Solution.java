package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileInputStream input = new FileInputStream(filename);
        TreeSet<Integer> set = new TreeSet<>();
        while(input.available()>0){
            int data=input.read();
            set.add(data);
        }
        reader.close();
        input.close();
            for(int a : set){
                System.out.print(a + " ");
            }
    }
}
