package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread t;

    public LoggingStateThread(Thread t) {
        this.t = t;

    }

    @Override
    public void run() {

        String print="";
        while (true) {
            String s = t.getState().toString();
            if(!(s.equals(print))){
                System.out.println(s);
                print=s;

            }
        }

    }
}
