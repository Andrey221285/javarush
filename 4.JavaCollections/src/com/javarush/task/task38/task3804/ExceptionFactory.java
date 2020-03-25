package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable getException(Enum e) {
        if (e == null) {
            return new IllegalArgumentException();
        } else if (e instanceof ExceptionApplicationMessage) {
            String s = e.name();
            s = (s.substring(0, 1) + s.substring(1).toLowerCase()).replace("_", " ");
            return  new Exception(s);

        } else if (e instanceof ExceptionDBMessage) {
            String s = e.name();
            s = (s.substring(0, 1) + s.substring(1).toLowerCase()).replace("_", " ");
            return  new RuntimeException(s);

        } else if (e instanceof ExceptionUserMessage) {
            String s = e.name();
            s = (s.substring(0, 1) + s.substring(1).toLowerCase()).replace("_", " ");
            return new Error(s);

        } else {
            return  new IllegalArgumentException();
        }
    }
}
