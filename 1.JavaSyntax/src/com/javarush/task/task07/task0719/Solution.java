package com.javarush.task.task07.task0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Вывести числа в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int a = 0;a<10;a++){
            list.add(Integer.parseInt(reader.readLine()));
        }
        for (int b=list.size()-1;b>=0;b--){
            System.out.println(list.get(b));
        }

        //напишите тут ваш код
    }
}
