package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader key  = new BufferedReader (new InputStreamReader (System.in));
        ArrayList<String> list = new ArrayList<String>(10);

        for (int a = 0; a<10;a++){
            list.add(key.readLine());//напишите тут ваш код
        }

        int minnumber = 0;
        int min = list.get(0).length();

        for (int b = 1;b<10;b++){
            if(min>list.get(b).length()){
               minnumber = b;
               min = list.get(b).length();
            }
        }
        int maxnumber = 0;
        int max = list.get(0).length();

        for (int c = 1;c<10;c++){
            if (max<list.get(c).length()){
                maxnumber = c;
                max = list.get(c).length();
            }
        }
        if (minnumber<maxnumber){
            System.out.println(list.get(minnumber));
        }
        else{
            System.out.println(list.get(maxnumber));
        }
    }
}
