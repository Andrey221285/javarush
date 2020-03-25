package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {

    public static Map<String, String> properties = new HashMap<>();
    Properties pr = new Properties();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream input = new FileInputStream(reader.readLine())) {
            load(input);

        } catch (FileNotFoundException f) {
        } catch (IOException i) {
        }
        catch(Exception e){}

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        for (Map.Entry<String, String> item : properties.entrySet()) {
            pr.setProperty(item.getKey(), item.getValue());
        }
        pr.store(outputStream, "1234");


    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        pr.load(inputStream);
        properties = (Map)pr;


    }

    public static void main(String[] args) {

    }
}
