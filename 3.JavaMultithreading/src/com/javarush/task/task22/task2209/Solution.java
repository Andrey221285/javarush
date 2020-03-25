package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        //...
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader flreader = new BufferedReader(new FileReader(reader.readLine()))) {
            while (flreader.ready()) {
                sb.append(flreader.readLine());
            }
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
        StringBuilder result = getLine(sb.toString().split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> sort = new ArrayList<>();
        StringBuilder res = new StringBuilder();

        if (words != null) {
            for (String s : words) {
                list.add(s);
            }
            Collections.sort(list);
int count=0;
            for (int i = 0; i < list.size();) {


                if (sort.size() == 0) {
                    sort.add(list.get(i));
                    list.remove(i);
                    i = 0;
continue;
                }
                String sort1 = sort.get(0);
                String sort2 = sort.get(sort.size() - 1);
                String list1 = list.get(i);
                 if (sort1.substring(0, 1).equalsIgnoreCase(list.get(i).substring(list1.length() - 1))) {
                    sort.add(0, list1);
                    list.remove(i);
                    i = 0;
                    continue;
                }
                if (sort2.substring(sort2.length() - 1).equalsIgnoreCase(list1.substring(0, 1))) {
                    sort.add(list1);
                    list.remove(i);
                    i = 0;
                    continue;
                }
                else{
                     if(count-100>list.size()){
                         break;
                     }

                    String temp=list1;
                    list.remove(i);
                    list.add(temp);
                    i=0;
                    count++;
                    continue;
                }

            }
            for (String s : sort) {
                res.append(s + " ");
            }
        }
        return res;
    }
}
