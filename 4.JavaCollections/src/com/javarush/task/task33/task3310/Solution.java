package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

        testStrategy(new HashMapStorageStrategy(),10000);
        testStrategy(new OurHashMapStorageStrategy(),10000);
        testStrategy(new FileStorageStrategy(),10);
        testStrategy(new OurHashBiMapStorageStrategy(),10000);
        testStrategy(new HashBiMapStorageStrategy(),10000);
        testStrategy(new DualHashBidiMapStorageStrategy(),10000);
        
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> set = new HashSet<>();
        for(String s : strings){
            set.add(shortener.getId(s));
        }
        return set;
    }
    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> set = new HashSet<>();
        for(Long l : keys){
            set.add(shortener.getString(l));
        }
        return set;
    }
    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.toString());
        Set<String> set = new HashSet<>();
        for(long i =0;i<elementsNumber;i++){
            set.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Date start = new Date();
        Set<Long>id = getIds(shortener,set);
        Date end = new Date();
        Helper.printMessage("time getIds: " + (-start.getTime()+end.getTime()));

        start = new Date();
        Set<String> strings = getStrings(shortener,id);
        end = new Date();
        Helper.printMessage("time getStrings: " + (-start.getTime()+end.getTime()));

        if(set.containsAll(strings)){
            Helper.printMessage("Тест пройден.");
        }
        else{
            Helper.printMessage("Тест не пройден.");
        }

    }
}
