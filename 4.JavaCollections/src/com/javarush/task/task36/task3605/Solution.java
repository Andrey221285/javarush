package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        TreeSet<String> set = new TreeSet<>();
        int c;
        while ((c=fileReader.read())!=-1){
            if((c>=65 && c<=90)||(c>=97 && c<=122)){
            set.add(("" + (char)c).toLowerCase());
            }
        }
        fileReader.close();
        String s ="";
        for(String c1 : set){
            if(s.length()<5){
                s=s+c1;
            }
        }
        System.out.print(s);
    }
}
