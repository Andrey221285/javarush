package com.javarush.task.task13.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
            String text;
            do{
                text=reader.readLine();
                writer.write(text + "\n");
                writer.flush();
            }
            while(!text.equals("exit"));
            reader.close();
            writer.close();


        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }



    }
}
