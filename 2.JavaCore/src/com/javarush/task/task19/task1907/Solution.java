package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.regex.Pattern;


public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileReader fileReader = new FileReader(reader.readLine());
            StringBuilder a = new StringBuilder();

            while (fileReader.ready()) {
                a.append((char) fileReader.read());
            }
            String text = a.toString();
            int count =0;
            String[] words = text.split("\\W");
            for(String m :words){
                if(m.equals("world")){
                    count++;
                }
            }

            System.out.println(count);

            reader.close();
            fileReader.close();

        } catch (FileNotFoundException F) {
            System.out.println("файл не найден");
        } catch (IOException i) {
        }
    }
}
