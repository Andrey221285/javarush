package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
     //  System.out.println(c.getSimpleName());
        for (Annotation annotation : c.getDeclaredAnnotations()) {
            if (annotation.annotationType().getSimpleName().equals("PrepareMyTest")) {
               // System.out.println(annotation.annotationType().getSimpleName());

                Annotation ann = c.getAnnotation(PrepareMyTest.class);
                PrepareMyTest prepareMyTest = (PrepareMyTest) ann;
                for (String str : prepareMyTest.fullyQualifiedNames()) {
                    System.out.println(str);
                }
                return true;
            }

        }
        return false;
    }

    public static boolean printValues(Class c) {
       // System.out.println(c.getSimpleName());
        for (Annotation annotation : c.getDeclaredAnnotations()) {
            if (annotation.annotationType().getSimpleName().equals("PrepareMyTest")) {
                // System.out.println(annotation.annotationType().getSimpleName());

                Annotation ann = c.getAnnotation(PrepareMyTest.class);
                PrepareMyTest prepareMyTest = (PrepareMyTest) ann;
                for (Class cls : prepareMyTest.value()) {
                    System.out.println(cls.getSimpleName());
                }
                return true;
            }
        }
        return false;
    }
}
