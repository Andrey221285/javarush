package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread t;


    @Override
    public void run() {

        try {
            while (!t.isInterrupted()) {
                System.out.println(t.getName());
                Thread.currentThread().sleep(100);
            }
        } catch (InterruptedException i) {
           // System.out.println(i.getMessage());
        }

    }

    @Override
    public void start(String threadName) {
        t= new Thread(this,threadName);
        t.start();


    }

    @Override
    public void stop() {
        t.interrupt();


    }
}
