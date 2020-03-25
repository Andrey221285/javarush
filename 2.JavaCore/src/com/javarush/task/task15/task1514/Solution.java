package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static{
        labels.put(3434.67,"frgh");
        labels.put(35434.67,"fujuyjyjhrgh");
        labels.put(36434.67,"frfedrgh");
        labels.put(377434.67,"frweghhgh");
        labels.put(348834.67,"frththtgrrgrgrgh");

    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
