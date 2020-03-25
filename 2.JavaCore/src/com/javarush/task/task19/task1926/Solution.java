package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader freader = new BufferedReader(new FileReader(reader.readLine()))){

            while(freader.ready()){
                StringBuffer buf = new StringBuffer(freader.readLine());
                buf.reverse();

                System.out.println(buf);
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
