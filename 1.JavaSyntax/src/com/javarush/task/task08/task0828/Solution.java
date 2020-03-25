package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String>list= new ArrayList<String>();
        list.add("January");
        list.add("February");
        list.add("March");
        list.add("April");
        list.add("May");
        list.add("June");
        list.add("July");
        list.add("August");
        list.add("September");
        list.add("October");
        list.add("November");
        list.add("December");
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
        String s = key.readLine();
        for(int a=0;a<list.size();a++){
            if(s.equals(list.get(a))){
                System.out.println(list.get(a)+" is "+(a+1)+" month");
            }
        }

        //напишите тут ваш код
    }
}
