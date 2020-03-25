package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;


/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(;;){
            String first = reader.readLine();
            if(first.isEmpty()){
                break;
            }
            String second = reader.readLine();
            map.put(second, Integer.parseInt(first));

        }
        for(HashMap.Entry<String,Integer> pair : map.entrySet()) {

            int id = pair.getValue();
            String name = pair.getKey();

            System.out.println(id + " " + name);
        }
    }
}
