package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
       try {
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           String filename = reader.readLine();
           FileInputStream input = new FileInputStream(filename);
           int count=0;
           while (input.available()>0){
               int data=input.read();
               if(data==44){
                   count++;
               }
           }
           reader.close();
           input.close();
           System.out.println(count);
       }
       catch (IOException e){
           System.out.println("ошибка ввода");
       }
    }
}
