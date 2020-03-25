package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Solution {
    public static void main(String[] args) {
        if (args[0].equals("-u") || args[0].equals("-d")) {
            String filename = "";
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                filename = reader.readLine();
            } catch (IOException i) {
                System.out.println("IO error");
            }

            String id = args[1];
            while (id.length() < 8) {
                id += " ";
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
            } catch (FileNotFoundException f) {
            } catch (IOException i) {
                System.out.println("IO error");
            }

            if (args[0].equals("-u")) {

                String productName = args[2];
                String price = args[3];
                String quantity = args[4];

                while (productName.length() < 30) {
                    productName += " ";
                }
                if (productName.length() > 30) {
                    productName = productName.substring(0, 30);
                }
                while (price.length() < 8) {
                    price += " ";
                }
                while (quantity.length() < 4) {
                    quantity += " ";
                }
                String text = id + productName + price + quantity;
                for (int p = 0; p < list.size(); p++) {
                    String s = list.get(p);
                    if (Integer.parseInt(s.substring(0, 8).trim()) == Integer.parseInt(args[1])) {
                        list.set(p, text);
                    }
                }
            }

            if (args[0].equals("-d")) {
                int index = 0;
                for (int p = 0; p < list.size(); p++) {
                    String s = list.get(p);
                    if (Integer.parseInt(s.substring(0, 8).trim()) == Integer.parseInt(args[1])) {
                        index = p;
                    }
                }
                list.remove(index);
            }

            StringJoiner joiner = new StringJoiner("\n");
            for (String z : list) {
                joiner.add(z);
            }
            String fin = joiner.toString();
            try {
                FileOutputStream out = new FileOutputStream(filename);
                byte[] bufer = fin.getBytes();
                out.write(bufer);
                out.close();
            } catch (FileNotFoundException f) {
            } catch (IOException i) {
            }
        }
    }
}
