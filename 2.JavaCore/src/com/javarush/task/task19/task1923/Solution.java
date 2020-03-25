package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 2) {
            ArrayList<String> list = new ArrayList<>();
            try(BufferedReader reader = new BufferedReader(new FileReader(args[0]));
                BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))){
                String s;
                while((s=reader.readLine())!=null){
                    list.add(s);
                }
                Pattern p = Pattern.compile("\\d");
                for(String q : list){
                    String []w=q.split(" ");
                    for(String e : w){
                        Matcher m = p.matcher(e);
                        if(m.find()){
                            writer.write(e+" ");
                        }
                    }
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
}
