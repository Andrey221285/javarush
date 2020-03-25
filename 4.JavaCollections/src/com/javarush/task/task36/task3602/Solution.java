package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {

        Class clazz = Collections.class;

        Class[] cl = clazz.getDeclaredClasses();
        for (Class c : cl) {
            if (Modifier.isPrivate(c.getModifiers()) && Modifier.isStatic(c.getModifiers())) {
                Class[] inter = c.getSuperclass().getInterfaces();
                for (Class in : inter) {
                    if (in.getSimpleName().equals("List")) {


                        try {
                            Constructor constructor = c.getDeclaredConstructor();
                            constructor.setAccessible(true);
                            List list = (List) constructor.newInstance();
                            list.get(0);

                        } catch (IndexOutOfBoundsException e) {
                            // вернуть класс
                            return c;
                        } catch (NoSuchMethodException e) {
                          //  e.printStackTrace();
                        } catch (IllegalAccessException e) {
                          //  e.printStackTrace();
                        } catch (InstantiationException e) {
                         //   e.printStackTrace();
                        } catch (InvocationTargetException e) {
                          //  e.printStackTrace();
                        }


                    }
                }
            }
        }
        return null;
    }

}
