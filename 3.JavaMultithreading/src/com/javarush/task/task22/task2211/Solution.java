package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        try(FileInputStream input = new FileInputStream(args[0]);
        FileOutputStream out = new FileOutputStream(args[1])){

            Charset utf8 = Charset.forName("UTF-8");
            Charset windows1251 = Charset.forName("Windows-1251");

            byte[]bufer=new byte[input.available()];
            input.read(bufer);
            String s = new String(bufer,windows1251);
            bufer=s.getBytes(utf8);
            out.write(bufer);


        }


    }
}
