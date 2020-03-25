package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {

   static AtomicInteger a = new AtomicInteger(1);
    public MyThread() {
        setPriority(a.getAndIncrement());
        a.compareAndSet(11,1);

    }

    public MyThread(Runnable target) {
        super(target);
        setPriority(a.getAndIncrement());
        a.compareAndSet(11,1);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriority(a.getAndIncrement());
        a.compareAndSet(11,1);
    }

    public MyThread(String name) {
        super(name);
        setPriority(a.getAndIncrement());
        a.compareAndSet(11,1);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriority(a.getAndIncrement());
        a.compareAndSet(11,1);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority(a.getAndIncrement());
        a.compareAndSet(11,1);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriority(a.getAndIncrement());
        a.compareAndSet(11,1);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriority(a.getAndIncrement());
        a.compareAndSet(11,1);
    }

}
