package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));

        for(int a = 0;a<5;a++){
            list.add(key.readLine());
        }
        String min = list.get(0);
        int minlength = list.get(0).length();
        int numbermin = 0;
        for(int b = 1;b<list.size();b++){
            if(minlength>list.get(b).length()){
                min = list.get(b);
                minlength = list.get(b).length();
                numbermin = b;
            }
        }

        System.out.println(min);

        for(int c=0;c<list.size();c++){
            if(c==numbermin){
                continue;
            }
            if(minlength==list.get(c).length()){
                System.out.println(list.get(c));
            }
        }
    }
}
