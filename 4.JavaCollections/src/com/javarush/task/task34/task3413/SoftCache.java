package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        if (cacheMap.get(key) != null) {

            SoftReference<AnyObject> softReference = cacheMap.get(key);
            return softReference.get();
        } else {
            return null;
        }        //напишите тут ваш код
    }

    public AnyObject put(Long key, AnyObject value) {

        if (cacheMap.get(key) == null) {
            SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
            return null;
        } else {
            SoftReference<AnyObject> softReference = cacheMap.get(key);
            AnyObject anyObject = softReference.get();
            softReference.clear();
            return anyObject;
        }       //напишите тут ваш код
    }

    public AnyObject remove(Long key) {
        if (cacheMap.get(key) != null) {
            AnyObject anyObject = cacheMap.get(key).get();
            cacheMap.get(key).clear();
            SoftReference<AnyObject> softReference = cacheMap.remove(key);
            return anyObject;
        }
        else {
            //напишите тут ваш код
            return null;
        }
    }
}