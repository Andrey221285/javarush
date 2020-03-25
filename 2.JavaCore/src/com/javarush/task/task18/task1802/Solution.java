package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        FileInputStream input = new FileInputStream(filename);
        int min = input.read();
        while(input.available()>0){
            int data = input.read();
            if(data<min){
                min=data;
            }

        }
        input.close();
        System.out.println(min);
    }
}
