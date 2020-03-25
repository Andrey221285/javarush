package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            reader.close();

            FileInputStream input1 = new FileInputStream(file1);
            FileInputStream input2 = new FileInputStream(file2);
            byte[]bufer1 = new byte[input1.available()];
            input1.read(bufer1);
            input1.close();
            byte[] bufer2 = new byte[input2.available()];
            input2.read(bufer2);
            input2.close();

            FileOutputStream out = new FileOutputStream(file1);
            out.write(bufer2);
            out.write(bufer1);
            out.close();


        }
        catch(IOException i){
            System.out.println("IO error");
        }

    }
}
