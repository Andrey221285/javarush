package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        //48-57; //цифры
        // 65-90   //большие буквы
        // 97-122  //маленькие буквы
        HashSet<Integer> set = new HashSet<>();
        Random random = new Random();
        while (set.size() < 1) {
            int i = random.nextInt(122);
            if (i >= 48 && i <= 57) {
                set.add(i);
            }
        }
        while (set.size() < 2) {
            int i = random.nextInt(122);
            if (i >= 65 && i <= 90) {
                set.add(i);
            }
        }
        while (set.size() < 3) {
            int i = random.nextInt(122);
            if (i >= 97) {
                set.add(i);
            }
        }
        while (set.size() < 8) {
            int i = random.nextInt(122);
            if (i >= 48 && i <= 57 || i >= 65 && i <= 90 || i >= 97) {
                set.add(i);
            }
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for(Integer i:set){
            baos.write(i);
        }




        return baos;
    }
}