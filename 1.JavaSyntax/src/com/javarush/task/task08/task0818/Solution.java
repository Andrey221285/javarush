package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        map.put("Иванов", 100);
        map.put("Петров", 400);
        map.put("Сидоров", 500);
        map.put("Белкин", 600);
        map.put("Козлов", 700);
        map.put("Пушкин", 800);
        map.put("Лермонтов", 1000);
        map.put("Маяковский", 850);
        map.put("Державин", 900);
        map.put("Блок", 50);
        return map;//напишите тут ваш код
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String,Integer> copy = new HashMap<String,Integer>(map);
        for (Map.Entry<String, Integer> pair : copy.entrySet()){
            if(pair.getValue()<500){
                map.remove(pair.getKey());
            }
        }
        //напишите тут ваш код
    }

    public static void main(String[] args) {

    }
}