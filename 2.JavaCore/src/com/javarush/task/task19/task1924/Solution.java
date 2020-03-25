package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
static{
    map.put(0,"ноль");
    map.put(1,"один");
    map.put(2,"два");
    map.put(3,"три");
    map.put(4,"четыре");
    map.put(5,"пять");
    map.put(6,"шесть");
    map.put(7,"семь");
    map.put(8,"восемь");
    map.put(9,"девять");
    map.put(10,"десять");
    map.put(11,"одиннадцать");
    map.put(12,"двенадцать");
}
    public static void main(String[] args) {
        ArrayList<String> list =  new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader filereader = new BufferedReader(new FileReader(reader.readLine()))){
            String s;
            while((s=filereader.readLine())!=null){
                String []word = s.split(" ");
                for(int i=0;i<word.length;i++){
                    try {
                        if (map.containsKey(Integer.parseInt(word[i]))) {
                            word[i] = map.get(Integer.parseInt(word[i]));
                        }
                    }
                    catch(NumberFormatException n){}

                    s="";
                    for(String p:word){
                        s=s+p+" ";
                    }

                }
                System.out.println(s);
            }
        }
        catch(FileNotFoundException f){
            System.out.println(f.getMessage());
        }
        catch(IOException i){
            System.out.println(i.getMessage());
        }
    }
}
