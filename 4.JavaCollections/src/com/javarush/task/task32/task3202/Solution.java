package com.javarush.task.task32.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());

    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        String s = "";
        StringWriter sw = new StringWriter();
        try {
            byte[] bufer = new byte[is.available()];
            is.read(bufer);
            s = new String(bufer);

            sw.write(s);
            return sw;
        } catch (IOException e) {
           return sw;
        }
        finally {
            return sw;
        }
    }

}