package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader file = new BufferedReader(new FileReader(reader.readLine()))) {
            String s;
            while ((s = file.readLine()) != null) {
                list.add(s);
            }
        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }

        for (String x : list) {
            int n = 0;
            for (String y : words) {
                String[] word = x.split(" ");
                for(String slovo:word){
                    if(slovo.equals(y)){
                        n++;
                    }
                }

            }
            if (n == 2) {
                System.out.println(x);
            }
        }
    }
}
