package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        if (args.length > 0) {
            ArrayList<String> list = new ArrayList<>();
            TreeSet<String> set = new TreeSet<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {

                String s;
                while ((s = reader.readLine()) != null) {
                    list.add(s);
                    s = s.substring(0, s.indexOf(' '));
                    set.add(s);
                }
                for (String x : set) {

                    double zp = 0;
                    for (String a : list) {
                        String y = a.substring(0, a.indexOf(' '));
                        if (x.equals(y)) {

                            String z = a.substring(a.indexOf(' '));

                           zp += Double.parseDouble(z);
                        }
                    }

                    System.out.println(x + " " + zp);
                }

            } catch (FileNotFoundException F) {
                System.out.println("файл не найден");
            } catch (IOException i) {
            }

        }
    }
}
