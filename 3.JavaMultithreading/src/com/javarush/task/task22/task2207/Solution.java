package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader filereader = new BufferedReader(new FileReader(reader.readLine()))) {
            while (filereader.ready()) {
                s.append(filereader.readLine()+" ");
            }
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
        ArrayList<String> list = new ArrayList<>();
        String[] bufer = s.toString().split(" ");
        for (int i = 0; i < bufer.length; i++) {
            list.add(bufer[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if(list.get(i)!=null &&list.get(j)!=null) {
                    StringBuilder sb = new StringBuilder(list.get(j));
                    sb = sb.reverse();
                    String si = sb.toString();
                    if (list.get(i).equals(si)) {
                        Pair p = new Pair(list.get(i), list.get(j));

                        result.add(p);
                        list.set(i, null);
                        list.set(j, null);
                        break;
                    }
                }
            }
        }
        for(Pair ss:result){
            System.out.println(ss.toString());
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }
        public Pair(String first,String second){
            this.first=first;
            this.second=second;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
