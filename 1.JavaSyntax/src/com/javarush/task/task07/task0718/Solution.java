package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for(int a =0;a<10;a++){
            list.add(key.readLine());//напишите тут ваш код
        }
        int min = list.get(0).length();
        int number = 0;
        for (int b=1;b<list.size();b++){
            if (min<list.get(b).length()){
                min = list.get(b).length();
                number = b;
            }
            else{
                System.out.println(number+1);
                break;
            }

        }

    }
}

