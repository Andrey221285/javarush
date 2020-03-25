package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        int min = array.get(0);
        for(int a=1;a<array.size();a++){
            if(min>array.get(a)){
                min=array.get(a);
            }
        }
        // find minimum here — найти минимум тут
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = Integer.parseInt(key.readLine());
        for (int a=0; a<n;a++){
            list.add(Integer.parseInt(key.readLine()));
        }
        //create and initialize a list here - создать и заполнить список тут
        return list;
    }
}
