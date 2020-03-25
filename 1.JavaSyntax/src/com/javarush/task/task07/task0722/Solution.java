package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for(int a=0;;a++){
            String s = reader.readLine();
            if(s.equals("end")){
                break;
            }
            list.add(s);
        }
        for(String b : list){
            System.out.println(b);
        }

        //напишите тут ваш код
    }
}