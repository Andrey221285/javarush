package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Иванов", "Иван");
        map.put("Петров", "Петр");
        map.put("Сидоров", "Сидор");
        map.put("Чуйкин", "Чуйка");
        map.put("Иванович", "Петрич");
        map.put("Петрович", "Иванич");
        map.put("Алексеев", "Алексей");
        map.put("Андреев", "Андрей");
        map.put("Лехов", "Леха");
        map.put("Романов", "Роман");
        return map;//напишите тут ваш код

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int i=0;
        for(HashMap.Entry<String, String> pair : map.entrySet()){
            if(pair.getValue().equals(name)){
                i++;
            }
        }
        return i;//напишите тут ваш код
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int j=0;
        for(HashMap.Entry<String, String> pair : map.entrySet()){
            if(pair.getKey().equals(lastName)){
                j++;
            }
        }
        return j;//напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}
