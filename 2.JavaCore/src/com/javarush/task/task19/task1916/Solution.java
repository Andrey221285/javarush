package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        ArrayList<String> orig = new ArrayList();
        ArrayList<String> change = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
            BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()));
            String s = "";
            while ((s = file1.readLine()) != null) {
                orig.add(s);
            }
            while ((s = file2.readLine()) != null) {
                change.add(s);
            }
            reader.close();
            file1.close();
            file2.close();
        } catch (IOException i) {
            System.out.println("error input");
        }
        int count=0;

        for(int i=0;i<orig.size();i++){
            if(count<change.size() && orig.get(i).equals(change.get(count))){
                lines.add(new LineItem(Type.SAME,orig.get(i)));
                count++;

            }
            else if(count+1<change.size() && orig.get(i).equals(change.get(count+1))){
                lines.add(new LineItem(Type.ADDED, change.get(count)));
                lines.add(new LineItem(Type.SAME,orig.get(i)));
                count+=2;

            }
            else if(i+1<orig.size() && orig.get(i+1).equals(change.get(count))){
                lines.add(new LineItem(Type.REMOVED,orig.get(i)));
                //lines.add(new LineItem(Type.SAME,change.get(count)));

            }
        }
        if(change.size()-count==1){
            lines.add(new LineItem(Type.ADDED,change.get(count)));
        }

        for(LineItem l:lines){
            System.out.println(l.type+" "+l.line);
        }


    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
