package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = "";
        filename = reader.readLine();
        reader.close();
        FileInputStream input = new FileInputStream(filename);
        int max = 0;
        while(input.available()>0){
            int data = input.read();
           if(data>max){
               max=data;
           }
        }
        input.close();
        System.out.println(max);
    }
}
