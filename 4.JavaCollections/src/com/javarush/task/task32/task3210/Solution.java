package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        raf.seek(number);
        byte[] bufer = new byte[text.length()];
        raf.read(bufer, 0, text.length());
        String read = new String(bufer);
        if(read.equals(text)){
            raf.seek(raf.length());
            raf.write("true".getBytes());
        }
        else{
            raf.seek(raf.length());
            raf.write("false".getBytes());
        }

    }
}
