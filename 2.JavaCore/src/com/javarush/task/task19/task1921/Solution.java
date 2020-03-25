package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        if (args.length > 0) {

            try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
                String s;
                while((s=reader.readLine())!=null){
                    String name;
                    String[] bd;
                    Pattern p = Pattern.compile("\\d");
                    Matcher m = p.matcher(s);
                    int a=0;
                    if(m.find()){
                    a =m.start();}
                    name = s.substring(0,a-1);
                    bd = s.substring(a).split(" ");


                    PEOPLE.add(new Person(name, new Date(Integer.parseInt(bd[2])-1900,Integer.parseInt(bd[1])-1,Integer.parseInt(bd[0]))));
                }
            } catch (FileNotFoundException f) {
                System.out.println(f.getMessage());
            } catch (IOException i) {
                System.out.println(i.getMessage());
            }



        }

    }
}
