package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;



public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
            String s = "";
            String out = "";


            while ((s = fileReader.readLine()) != null) {

                String[] words = s.split(" ");
                for (String m : words) {
                    if (m.matches("(\\d+)")) {
                        out += m + " ";

                    }
                }

            }
            fileWriter.write(out);
            reader.close();
            fileReader.close();
            fileWriter.close();


        } catch (FileNotFoundException F) {
            System.out.println("файл не найден");
        } catch (IOException I) {
        }
    }
}
