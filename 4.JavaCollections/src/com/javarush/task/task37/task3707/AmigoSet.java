package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {

    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        this.map = new HashMap(Math.max(16, (int) Math.ceil(collection.size() / .75f)));
        for (E e : collection) {
            map.put(e, PRESENT);
        }
    }

    @Override
    public Iterator iterator() {
        Iterator<E> iterator = map.keySet().iterator();
        return iterator;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        if (map.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        if (map.containsKey(o)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        if (map.containsKey(o)) {
            map.remove(o);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean add(Object o) {
        if (map.containsKey(o)) {
            map.put((E) o, PRESENT);
            return false;
        } else {
            map.put((E) o, PRESENT);
            return true;
        }
    }

    @Override
    public AmigoSet<E> clone() {
        AmigoSet<E> cloneset = new AmigoSet<>();
        try {
            cloneset.map = (HashMap<E, Object>) this.map.clone();
        } catch (Exception e) {
            throw new InternalError();
        }
        return cloneset;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        objectOutputStream.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        objectOutputStream.writeInt(HashMapReflectionHelper.callHiddenMethod(map,"size"));
        for (E e : map.keySet()){
            objectOutputStream.writeObject(e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
       map= new HashMap<>(objectInputStream.readInt(),objectInputStream.readFloat());
       int size = objectInputStream.readInt();

      for(int i=0;i<size;i++){
            map.put((E)objectInputStream.readObject(),PRESENT);
        }
    }
}
