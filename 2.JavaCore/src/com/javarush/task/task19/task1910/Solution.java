package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader input = new BufferedReader(new FileReader(reader.readLine()));
            BufferedWriter out = new BufferedWriter(new FileWriter(reader.readLine()));
            String s;

            while ((s = input.readLine()) != null) {

                String a = s.replaceAll("\\W", "");
                out.write(a);
            }
            reader.close();
            input.close();
            out.close();
        } catch (FileNotFoundException f) {
            System.out.println("файл не найден");
        } catch (IOException i) {
        }
    }
}
