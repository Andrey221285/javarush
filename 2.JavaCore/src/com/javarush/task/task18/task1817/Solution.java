package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream input = new FileInputStream(args[0]);
            byte[] bufer = new byte[input.available()];
            input.read(bufer);
            input.close();
            int all = bufer.length;
            int probel = 0;
            for (byte b : bufer) {
                if (b == 32) {
                    probel++;
                }
            }
            double d = (double) probel / all * 100;

            System.out.printf("%.2f", d);

        } catch (FileNotFoundException e) {
            System.out.println("файл не найден");
        } catch (IOException i) {
            System.out.println("IO error");
        }


    }
}
