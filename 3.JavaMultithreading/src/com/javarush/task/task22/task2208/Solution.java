package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String,String>map = new HashMap<>();
        map.put("name","Ivanov");
        map.put("country","Ukraine");
        map.put("city","Kievs");
        map.put("age",null);
        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
StringBuilder sb=new StringBuilder();
        for(Map.Entry<String,String> pair:params.entrySet()){
            if(sb.length()!=0 && pair.getValue()!=null){
                sb.append(" and ");
            }
            String key = pair.getKey();
            String value = pair.getValue();
            if(value!=null){
                sb.append(key+ " = " + "'"+value+"'");
            }
        }
        return sb.toString();
    }
}
