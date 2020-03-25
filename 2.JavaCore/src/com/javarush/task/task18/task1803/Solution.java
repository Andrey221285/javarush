package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        FileInputStream input = new FileInputStream(filename);
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        while(input.available()>0){
            int data = input.read();
            list.add(data);
            set.add(data);
        }
        input.close();

        int max = 0;

        for (int x: set){
            int a=0;
            for(int b : list){
                if(x==b){
                    a++;
                }
            }
            if(a>max){
                max=a;
            }
        }
        for (int x : set){
            int a = 0;
            for(int b : list){
                if (x==b){
                    a++;
                }
            }
            if(a==max){
                System.out.print(x + " ");
            }
        }


    }
}
