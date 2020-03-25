package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            String file3 = reader.readLine();

            FileInputStream input = new FileInputStream(file1);
            FileOutputStream out1 = new FileOutputStream(file2);
            FileOutputStream out2 = new FileOutputStream(file3);

            if (input.available() > 0) {
                byte[] buffer = new byte[input.available() - input.available() / 2];
                int count = input.read(buffer);
                out1.write(buffer, 0, count);
                int count2 = input.read(buffer);
                out2.write(buffer, 0, count2);

            }
            reader.close();
            input.close();
            out1.close();
            out2.close();
        } catch (IOException e) {
            System.out.println("проверь ввод");
        }
    }
}
