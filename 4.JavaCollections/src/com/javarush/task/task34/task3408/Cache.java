package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<K, V>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {

        if (cache.get(key) != null) {
            return cache.get(key);
        } else {
            Constructor constructor = clazz.getConstructor(key.getClass());

            cache.put(key, (V)constructor.newInstance(key));
            return cache.get(key);
        }

        //TODO add your code here
    }

    public boolean put(V obj) throws InvocationTargetException, IllegalAccessException {
        //TODO add your code here
        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            cache.put((K) method.invoke(obj),obj);
            return true;

        } catch (NoSuchMethodException e) {
            //e.printStackTrace();
            return false;
        }



    }

    public int size() {
        return cache.size();
    }
}
