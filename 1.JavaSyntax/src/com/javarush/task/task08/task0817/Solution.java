package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String,String>();
        map.put("Иванов","Андрей");
        map.put("Петров","Алексей");
        map.put("Сидоров","Иван");
        map.put("Зайцев","Андрей");
        map.put("Беляков","Иван");
        map.put("Волков","Данил");
        map.put("Лисин","Максим");
        map.put("Лосев","Сергей");
        map.put("Бобров","Глеб");
        map.put("Кукушкин","Дима");
        return map;//напишите тут ваш код

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        int count = 0;
        String s ="";
        for(Map.Entry<String,String> pair : copy.entrySet()){
            s=pair.getValue();
           for (Map.Entry<String,String> pair1 : map.entrySet()){
                if(pair1.getValue().equals(s)){
                    count++;
                }
            }
            if(count>1){
                removeItemFromMapByValue(map, s);
            }
            s = "";
            count = 0;
        }
      /*  for(Map.Entry<String, String> pair : map.entrySet()){
            System.out.println(pair.getKey()+ " - " + pair.getValue());
        }*/

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
     //  removeTheFirstNameDuplicates(createMap());


    }
}
