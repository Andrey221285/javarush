package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader key = new BufferedReader (new InputStreamReader(System.in));
        char[] s =key.readLine().replace(" ","").toCharArray();
        String vow = "";
        String novow = "";
        for(char a : s){
            if(isVowel(a)){
                vow+=a + " ";
            }
            else{
               novow+=a+ " ";
            }
        }
        System.out.println(vow + "\n"+ novow);

        //напишите тут ваш код
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}