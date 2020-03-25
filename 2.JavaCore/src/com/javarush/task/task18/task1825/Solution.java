package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = "";
            while (!(s = reader.readLine()).equals("end")) {
                set.add(s);
            }
        } catch (IOException i) {
            System.out.println("IO error");
        }
        String outname = set.first();
        outname = outname.substring(0, outname.lastIndexOf("."));
        try {
            FileOutputStream out = new FileOutputStream(outname);

            for (String filename : set) {
                FileInputStream input = new FileInputStream(filename);
                byte[] bufer = new byte[input.available()];
                input.read(bufer);
                out.write(bufer);
                input.close();
            }
            out.close();

        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
        }
        catch(IOException i){
            System.out.println(i.getMessage());
        }
    }
}
