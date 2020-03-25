package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
        String s = key.readLine();
        int a = s.length();
        for (int b = 0; b<a;b++){
            char c = s.charAt(b);
            if(c%2!=0){
                odd++;
            }
            else{
                even++;
            }
         }

        System.out.println("Even: " + even + " Odd: " + odd);//напишите тут ваш код
    }
}
