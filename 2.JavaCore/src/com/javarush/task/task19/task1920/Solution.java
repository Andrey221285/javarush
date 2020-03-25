package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;


public class Solution {
    public static void main(String[] args) {
        if (args.length > 0) {
            TreeMap<String, Double> map = new TreeMap<>();
            TreeSet<String> set = new TreeSet<>();
            ArrayList<String> list = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
                String s;
                while ((s = reader.readLine()) != null) {
                    list.add(s);
                    s = s.substring(0, s.indexOf(' '));
                    set.add(s);
                }
            } catch (FileNotFoundException f) {
                System.out.println("файла нет");
            } catch (IOException i) {
            }
            for (String x : set) {

                double zp = 0;
                for (String a : list) {
                    String y = a.substring(0, a.indexOf(' '));
                    if (x.equals(y)) {

                        String z = a.substring(a.indexOf(' '));

                        zp += Double.parseDouble(z);
                    }
                }

                map.put(x,zp);
            }
            double max =0;
            for(String f : set){
                if(map.get(f)>max){
                    max=map.get(f);
                }
            }
            for(String h:set){
                if(map.get(h)==max){
                    System.out.println(h);
                }
            }





        }
    }
}
