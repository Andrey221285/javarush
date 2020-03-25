package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        return values().size();
    }

    @Override
    public V put(K key, V value) {
        if(containsKey(key)){
            int size=map.get(key).size();
            if(size<repeatCount){
                V v = map.get(key).get(size-1);
                map.get(key).add(value);
                return v;
            }
            else if (size==repeatCount){
                V v = map.get(key).get(size-1);
                map.get(key).remove(0);
                map.get(key).add(value);
                return v;
            }
        }
        else{
            List<V>list = new ArrayList<>();
            list.add(value);
            map.put(key,list);
            return null;
        }
        //напишите тут ваш код
        return null;
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        if(containsKey(key)){
            int size = map.get(key).size();
            if(size>0){
                V v = map.get(key).get(0);
                map.get(key).remove(0);
                if(map.get(key).size()==0){
                    map.remove(key);
                }
                return v;
            }


        }
        else{
            return null;
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код

        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        ArrayList<V>list  =new ArrayList<>();
        //напишите тут ваш код
        for(List<V> listvalue : map.values()){
            for(V value : listvalue){
                list.add(value);
            }
        }
        return list;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        if(map.containsKey(key)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        if(values().contains(value)){
        return true;}
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}