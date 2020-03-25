package com.javarush.task.task39.task3913;

import java.util.Date;

public class Log {
    private String ip;
    private String name;
    private Date date;
    private Event event;
    private Integer parametr;
    private Status status;


    public Log(String ip, String name, Date date, Event event, Integer parametr, Status stratus) {
        this.ip = ip;
        this.name = name;
        this.date = date;
        this.event = event;
        this.parametr = parametr;
        this.status = stratus;
    }

    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Event getEvent() {
        return event;
    }

    public Integer getParametr() {
        return parametr;
    }

    public Status getStatus() {
        return status;
    }
}
