package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream input = new FileInputStream(args[0]);
            byte[] bufer = new byte[input.available()];
            input.read(bufer);
            input.close();

            TreeSet<Byte> set = new TreeSet<>();
            for (byte b : bufer) {
                set.add(b);
            }
            for (byte b : set) {
                int count = 0;
                for (byte c : bufer) {
                    if(c==b){
                        count++;
                    }
                }
                System.out.println((char)b + " " + count);
                count=0;
            }

        } catch (IOException i) {
            System.out.println("IO error");
        }
    }
}
