package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String[]s=getTokens("level22.lesson13.task01", ".");
        for(String g:s){
            System.out.println(g);
        }
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer st=new StringTokenizer(query,delimiter);
        ArrayList<String>list=new ArrayList<>();
        while(st.hasMoreTokens()){
            list.add(st.nextToken());
        }
        String []res=list.toArray(new String[list.size()]);

        return res;
    }
}
