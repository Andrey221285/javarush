package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
            String s;

            while ((s=fileReader.readLine())!=null){


                String a = s.replaceAll("\\.","!");
                fileWriter.write(a);
             //   System.out.println(a);
            }


                reader.close();
            fileReader.close();
            fileWriter.close();
        } catch (FileNotFoundException f) {
            System.out.println("файл не найден");
        } catch (IOException i) {
        }
    }
}
