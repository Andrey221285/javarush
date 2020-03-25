package com.javarush.task.task07.task0708;

import java.io.*;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<5;i++){
            list.add(key.readLine());//напишите тут ваш код
        }
        String s = list.get(0);
        int max = list.get(0).length();
        int b = 0;
           for (int a = 1;a<list.size();a++){
               if(list.get(a).length()>max){
                max = list.get(a).length();
                s =list.get(a);
                b=a;
            }
        }
        System.out.println(s);

        for (int d = 0;d<list.size();d++){
            if (d==b){
                continue;
            }
            if (max==list.get(d).length()){
                System.out.println(list.get(d));
            }
        }


    }
}
