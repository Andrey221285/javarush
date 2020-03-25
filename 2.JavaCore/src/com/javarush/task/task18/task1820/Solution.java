package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.StringJoiner;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            reader.close();

            FileInputStream input = new FileInputStream(file1);
            byte[] bufer = new byte[input.available()];
            input.read(bufer);
            input.close();
            String s = new String(bufer);

            StringJoiner joiner = new StringJoiner(" ");
            for(String number : s.split(" ")){
                joiner.add(Long.toString(Math.round(Double.parseDouble(number))));
            }

            byte[]bufer2 = joiner.toString().getBytes();
            FileOutputStream out = new FileOutputStream(file2);
            out.write(bufer2);
            out.close();

        }
        catch (IOException i){
            System.out.println("IO error");
        }
    }
}
