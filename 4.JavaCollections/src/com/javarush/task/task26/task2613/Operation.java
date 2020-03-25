package com.javarush.task.task26.task2613;

public enum Operation {
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;


    public static Operation getAllowableOperationByOrdinal(Integer i) {
        try {
            if(i==0){
                throw new IllegalArgumentException();
            }
            Operation o = Operation.values()[i];
            return o;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
