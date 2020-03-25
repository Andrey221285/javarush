package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader key = new BufferedReader(new InputStreamReader (System.in));
        ArrayList<Integer> listinput = new ArrayList<Integer>();
        ArrayList<Integer> list3  = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int a = 0;a<20;a++){
            listinput.add(Integer.parseInt(key.readLine()));
        }
        for (int b = 0;b<20;b++){
            if (listinput.get(b)%3==0){
                list3.add(listinput.get(b));
            }
            if (listinput.get(b)%2==0){
                list2.add(listinput.get(b));
            }
            if (listinput.get(b)%3!=0 && listinput.get(b)%2!=0){
                list.add(listinput.get(b));
            }
        }
        printList(list3);
        printList(list2);
        printList(list);


        //напишите тут ваш код
    }

    public static void printList(List<Integer> list) {
        for(int a = 0;a<list.size();a++){
            System.out.println(list.get(a));//напишите тут ваш код
        }
    }
}
