package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            // напишите тут ваш код

            FileInputStream in = new FileInputStream(reader.readLine());
            while (in.available()>0){
                int b = in.read();
                System.out.print((char)b);

            }
            in.close();
            reader.close();


        }
        catch (Exception e){
            System.out.println("неправильное имя");

        }

    }
}