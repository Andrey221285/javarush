package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file = reader.readLine();
            reader.close();
            FileInputStream input = new FileInputStream(file);
            byte[] bufer = new byte[input.available()];
            input.read(bufer);
            input.close();
            String s = new String(bufer);
            String[] b = s.split("\n");
            for (String n : b){
                if(n.startsWith(args[0]+" ")){
                    System.out.println(n);
                }
            }



        } catch (IOException i) {
            System.out.println("IO ERRor");
        }
    }
}
