package com.javarush.task.task14.task1409;

/* 
Мосты
*/



public class Solution {
    public static void main(String[] args) {
        println(new WaterBridge());
        println(new SuspensionBridge());
    }
    public static void println(Bridge o){
        if (o instanceof WaterBridge){
            WaterBridge bridge = (WaterBridge)o;
            System.out.println(bridge.getCarsCount());
        }
        if (o instanceof SuspensionBridge){
            SuspensionBridge bridge = (SuspensionBridge)o;
            System.out.println(bridge.getCarsCount());
        }
    }

    //add println method here
}

