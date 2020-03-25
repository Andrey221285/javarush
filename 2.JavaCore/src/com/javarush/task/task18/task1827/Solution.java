package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (args[0].equals("-c")) {
            String filename = "";
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                filename = reader.readLine();
            }
            String productName = args[1];
            String price = args[2];
            String quantity = args[3];
            String id = "1";


            while (productName.length() < 30) {
                productName += " ";
            }
            if(productName.length()>30){
                productName = productName.substring(0,30);
            }
            while (price.length() < 8) {
                price += " ";
            }
            while (quantity.length() < 4) {
                quantity += " ";
            }
            ArrayList<String> list = new ArrayList<>();
            try {
                FileInputStream input = new FileInputStream(filename);
                byte[] bufer = new byte[input.available()];
                input.read(bufer);
                input.close();

                String s = new String(bufer);

                for (String b : s.split("\n")) {
                    list.add(b);
                }
                int max = 0;
                for (String m : list) {
                    String n = m.substring(0, 8).trim();
                    int a = Integer.parseInt(n);
                    if (a > max) {
                        max = a;
                    }
                }
                max++;
                id = "" + max;
            } catch (FileNotFoundException f) {
            }
            while (id.length() < 8) {
                id += " ";
            }

            String text = id + productName + price + quantity;
            list.add(text);
            StringJoiner joiner = new StringJoiner("\n");
            for (String z : list){
                joiner.add(z);
            }
            String fin = joiner.toString();

            // System.out.println(text);
            try {
                FileOutputStream out = new FileOutputStream(filename);
                byte[] bufer = fin.getBytes();
                out.write(bufer);
                out.close();
            } catch (FileNotFoundException f) {
            }
        }
    }
}
