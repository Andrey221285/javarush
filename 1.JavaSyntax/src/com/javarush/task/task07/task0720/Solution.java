package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        ArrayList<String> list = new ArrayList<String>();
        for (int a = 0;a<N;a++){
            list.add(reader.readLine());
        }
        for (int b=0;b<M;b++){
            list.add(list.get(0));
            list.remove(0);
        }



       for(String s : list){
            System.out.println(s);//напишите тут ваш код
       }
    }
}
