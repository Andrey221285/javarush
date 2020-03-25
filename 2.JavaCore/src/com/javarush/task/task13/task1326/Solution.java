package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader filereader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())))) {

            ArrayList<Integer> list = new ArrayList<Integer>();
            while(filereader.ready())


            list.add(Integer.parseInt(filereader.readLine()));


            Collections.sort(list);


            for (int a : list) {
                if (a % 2 == 0) {
                    System.out.println(a);
                }
            }
        }

        catch(IOException e){
            System.out.println("чтото пошло не так " + e.getMessage());
        }
    }
}
