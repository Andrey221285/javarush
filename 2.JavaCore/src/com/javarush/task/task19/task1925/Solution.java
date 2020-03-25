package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.StringJoiner;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 2) {
            try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
                StringJoiner joiner = new StringJoiner(",");

                String s;

                while(reader.ready()){
                    s=reader.readLine();

                String[] word = s.split(" ");

                for(String w:word){
                    if(w.length()>6){
                        joiner.add(w);
                    }
                }
                }
                s=joiner.toString();
                writer.write(s);
            } catch (FileNotFoundException f) {
                System.out.println(f.getMessage());
            } catch (IOException i) {
                System.out.println(i.getMessage());
            }
        }

    }
}
