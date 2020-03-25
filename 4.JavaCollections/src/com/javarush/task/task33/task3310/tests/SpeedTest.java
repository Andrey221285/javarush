package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        long time = 0;
        Date start = new Date();
        for(String s : strings){
            ids.add(shortener.getId(s));
        }
        Date end = new Date();
        time = end.getTime()-start.getTime();
        return time;
    }
    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        long time = 0;
        Date start = new Date();
        for(Long l : ids){
            strings.add(shortener.getString(l));
        }
        Date end = new Date();
        time = end.getTime()-start.getTime();
        return time;
    }

    @Test
    public void testHashMapStorage(){
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        Shortener shortener1 = new Shortener(hashMapStorageStrategy);

        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener2 = new Shortener(hashBiMapStorageStrategy);

        Set<String> origStrings = new HashSet<>();
        for(int i=0;i<10000;i++){
           origStrings.add(Helper.generateRandomString());
        }
        Set<Long> ids = new HashSet<>();
        Long timeIdshortener1 = getTimeForGettingIds(shortener1,origStrings,ids);
        Long timeStringshortener1 = getTimeForGettingStrings(shortener1,ids,new HashSet<>());


        Set<Long> idsBi = new HashSet<>();
        Long timeWhithHashBiMapIds = getTimeForGettingIds(shortener2, origStrings,idsBi);
        Long timeWhithHashBiMapStrings = getTimeForGettingStrings(shortener2,idsBi,new HashSet<String>());

        Assert.assertTrue(timeIdshortener1 > timeWhithHashBiMapIds);
        Assert.assertEquals(timeStringshortener1, timeWhithHashBiMapStrings,30);
    }
}
