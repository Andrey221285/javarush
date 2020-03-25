package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
       // Locale bLocale = new Locale.Builder().setLanguage("en").setRegion("US").build();
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        Date date = new Date(reader.readLine());//напишите тут ваш код

        SimpleDateFormat d = new SimpleDateFormat("MMM dd, yyyy", Locale.US);

        String s = d.format(date);

        System.out.println(s.toUpperCase());
    }
}
