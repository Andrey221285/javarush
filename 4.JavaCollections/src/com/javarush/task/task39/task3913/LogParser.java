package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.*;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {

    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    @Override
    public Set<Object> execute(String query) {
        Set<Object> set = new HashSet<>();

        if (query.contains("and date between")) {
            Pattern p = Pattern.compile("get (ip|user|date|event|status)"
                    + "( for (ip|user|date|event|status) = \"(.*?)\")?"
                    + "( and date between \"(.*?)\" and \"(.*?)\")?");

            Matcher m = p.matcher(query);

            String s1 = null;
            String s2 = null;
            String v = null;
            Date dateafter = null;
            Date datebefore = null;

            if (m.find()) {
                s1 = m.group(1);
                s2 = m.group(3);
                v = m.group(4);
                String d1 = m.group(6);
                String d2 = m.group(7);
                try {
                    dateafter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(d1);
                } catch (Exception e) {
                    dateafter = null;
                }
                try {
                    datebefore = new SimpleDateFormat("dd.MM.yyyyy HH:mm:ss").parse(d2);
                } catch (Exception e) {
                    datebefore = null;
                }
            }
            switch (s1) {
                case "ip":
                    switch (s2) {
                        case "user":
                            for (Log l : getListLog()) {
                                if (compareDate(dateafter,datebefore,l.getDate())) {
                                    if (l.getName().equals(v)) {
                                        set.add(l.getIp());
                                    }
                                }
                            }
                            break;
                        case "date":
                            Date date = null;
                            try {
                                date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(v);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            for (Log l : getListLog()) {
                                if (compareDate(dateafter,datebefore,l.getDate())) {
                                    if (l.getDate().compareTo(date)==0) {
                                        set.add(l.getIp());
                                    }
                                }
                            }
                            break;
                        case "event":
                            for (Log l : getListLog()) {
                                if (compareDate(dateafter,datebefore,l.getDate())) {
                                    if (l.getEvent() == Event.valueOf(v)) {
                                        set.add(l.getIp());
                                    }
                                }
                            }
                            break;
                        case "status":
                            for (Log l : getListLog()) {
                                if (compareDate(dateafter,datebefore,l.getDate())) {
                                    if (l.getStatus() == Status.valueOf(v)) {
                                        set.add(l.getIp());
                                    }
                                }
                            }
                            break;
                    }
                    break;
                case "user":
                    switch (s2) {
                        case "ip":
                            for (Log l : getListLog()) {
                                if (compareDate(dateafter,datebefore,l.getDate())) {
                                    if (l.getIp().equals(v)) {
                                        set.add(l.getName());
                                    }
                                }
                            }
                            break;
                        case "date":
                            Date date = null;
                            try {
                                date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(v);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            for (Log l : getListLog()) {
                                if (compareDate(dateafter,datebefore,l.getDate())) {
                                    if (l.getDate().compareTo(date) == 0) {
                                        set.add(l.getName());
                                    }
                                }
                            }
                            break;
                        case "event":
                            for (Log l : getListLog()) {
                                if (compareDate(dateafter,datebefore,l.getDate())) {
                                    if (l.getEvent() == Event.valueOf(v)) {
                                        set.add(l.getName());
                                    }
                                }
                            }
                            break;
                        case "status":
                            for (Log l : getListLog()) {
                                if (compareDate(dateafter,datebefore,l.getDate())) {
                                    if (l.getStatus() == Status.valueOf(v)) {
                                        set.add(l.getName());
                                    }
                                }
                            }
                            break;
                    }
                    break;
                case "date":
                    switch (s2) {
                        case "ip":
                            for (Log l : getListLog()) {
                                if (compareDate(dateafter,datebefore,l.getDate())) {
                                    if (l.getIp().equals(v)) {
                                        set.add(l.getDate());
                                    }
                                }
                            }
                            break;
                        case "user":
                            for (Log l : getListLog()) {
                                if (compareDate(dateafter,datebefore,l.getDate())) {
                                    if (l.getName().equals(v)) {
                                        set.add(l.getDate());
                                    }
                                }
                            }
                            break;
                        case "event":
                            for (Log l : getListLog()) {
                                if (compareDate(dateafter,datebefore,l.getDate())) {
                                    if (l.getEvent() == Event.valueOf(v)) {
                                        set.add(l.getDate());
                                    }
                                }
                            }
                            break;
                        case "status":
                            for (Log l : getListLog()) {
                                if (compareDate(dateafter,datebefore,l.getDate())) {
                                    if (l.getStatus() == Status.valueOf(v)) {
                                        set.add(l.getDate());
                                    }
                                }
                            }
                            break;
                    }
                    break;
                case "event":
                    switch (s2) {
                        case "ip":
                            for (Log l : getListLog()) {
                                if (compareDate(dateafter,datebefore,l.getDate())) {
                                    if (l.getIp().equals(v)) {
                                        set.add(l.getEvent());
                                    }
                                }
                            }
                            break;
                        case "user":
                            for (Log l : getListLog()) {
                                if (compareDate(dateafter,datebefore,l.getDate())) {
                                    if (l.getName().equals(v)) {
                                        set.add(l.getEvent());
                                    }
                                }
                            }
                            break;
                        case "date":
                            Date date = null;
                            try {
                                date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(v);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            for (Log l : getListLog()) {
                                if (compareDate(dateafter,datebefore,l.getDate())) {
                                    if (l.getDate().compareTo(date) == 0) {
                                        set.add(l.getEvent());
                                    }
                                }
                            }
                            break;
                        case "status":
                            for (Log l : getListLog()) {
                                if (compareDate(dateafter,datebefore,l.getDate())) {
                                    if (l.getStatus() == Status.valueOf(v)) {
                                        set.add(l.getEvent());
                                    }
                                }
                            }
                            break;
                    }
                    break;
                case "status":
                    switch (s2) {
                        case "ip":
                            for (Log l : getListLog()) {
                                if (compareDate(dateafter,datebefore,l.getDate())) {
                                    if (l.getIp().equals(v)) {
                                        set.add(l.getStatus());
                                    }
                                }
                            }
                            break;
                        case "user":
                            for (Log l : getListLog()) {
                                if (compareDate(dateafter,datebefore,l.getDate())) {
                                    if (l.getName().equals(v)) {
                                        set.add(l.getStatus());
                                    }
                                }
                            }
                            break;
                        case "date":
                            Date date=null;
                            try {
                                date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(v);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            for (Log l : getListLog()){
                                if (compareDate(dateafter,datebefore,l.getDate())){
                                    if(l.getDate().compareTo(date)==0){
                                        set.add(l.getStatus());
                                    }
                                }
                            }
                            break;
                        case "event":
                            for(Log l :getListLog()){
                              if(compareDate(dateafter,datebefore,l.getDate())){
                                    if (l.getEvent()==Event.valueOf(v)){
                                        set.add(l.getStatus());
                                    }
                                }
                            }
                            break;

                    }
                    break;
            }
        }


       else if (query.contains("=")) {
            String s = query.substring(0, query.indexOf("=")).trim();
            String param = query.substring(query.indexOf('"') + 1, query.lastIndexOf('"'));
            SimpleDateFormat simpleDateFormat = simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            Date date = null;
            switch (s) {
                case "get ip for user":
                    for (Object o : getIPsForUser(param, null, null)) {
                        set.add(o);
                    }
                    break;
                case "get ip for date":
                    try {
                        date = simpleDateFormat.parse(param);
                    } catch (ParseException e) {
                    }
                    for (Log l : getListLog()) {
                        if (date.compareTo(l.getDate()) == 0) {
                            set.add(l.getIp());
                        }
                    }
                    break;
                case "get ip for event":
                    for (Log l : getListLog()) {
                        if (l.getEvent() == Event.valueOf(param)) {
                            set.add(l.getIp());
                        }
                    }
                    break;
                case "get ip for status":
                    for (Log l : getListLog()) {
                        if (l.getStatus() == Status.valueOf(param)) {
                            set.add(l.getIp());
                        }
                    }
                    break;
                case "get user for ip":
                    for (Log l : getListLog()) {
                        if (l.getIp().equals(param)) {
                            set.add(l.getName());
                        }
                    }
                    break;
                case "get user for date":
                    try {
                        date = simpleDateFormat.parse(param);
                    } catch (ParseException e) {
                    }
                    for (Log l : getListLog()) {
                        if (l.getDate().compareTo(date) == 0) {
                            set.add(l.getName());
                        }
                    }
                    break;
                case "get user for event":
                    for (Log l : getListLog()) {
                        if (l.getEvent() == Event.valueOf(param)) {
                            set.add(l.getName());
                        }
                    }
                    break;
                case "get user for status":
                    for (Log l : getListLog()) {
                        if (l.getStatus() == Status.valueOf(param)) {
                            set.add(l.getName());
                        }
                    }
                    break;
                case "get date for ip":
                    for (Log l : getListLog()) {
                        if (l.getIp().equals(param)) {
                            set.add(l.getDate());
                        }
                    }
                    break;
                case "get date for user":
                    for (Log l : getListLog()) {
                        if (l.getName().equals(param)) {
                            set.add(l.getDate());
                        }
                    }
                    break;
                case "get date for event":
                    for (Log l : getListLog()) {
                        if (l.getEvent() == Event.valueOf(param)) {
                            set.add(l.getDate());
                        }
                    }
                    break;
                case "get date for status":
                    for (Log l : getListLog()) {
                        if (l.getStatus() == Status.valueOf(param)) {
                            set.add(l.getDate());
                        }
                    }
                    break;
                case "get event for ip":
                    for (Log l : getListLog()) {
                        if (l.getIp().equals(param)) {
                            set.add(l.getEvent());
                        }
                    }
                    break;
                case "get event for user":
                    for (Log l : getListLog()) {
                        if (l.getName().equals(param)) {
                            set.add(l.getEvent());
                        }
                    }
                    break;
                case "get event for date":
                    try {
                        date = simpleDateFormat.parse(param);
                    } catch (ParseException e) {
                    }
                    for (Log l : getListLog()) {
                        if (l.getDate().compareTo(date) == 0) {
                            set.add(l.getEvent());
                        }
                    }
                    break;
                case "get event for status":
                    for (Log l : getListLog()) {
                        if (l.getStatus() == Status.valueOf(param)) {
                            set.add(l.getEvent());
                        }
                    }
                    break;
                case "get status for ip":
                    for (Log l : getListLog()) {
                        if (l.getIp().equals(param)) {
                            set.add(l.getStatus());
                        }
                    }
                    break;
                case "get status for user":
                    for (Log l : getListLog()) {
                        if (l.getName().equals(param)) {
                            set.add(l.getStatus());
                        }
                    }
                    break;
                case "get status for date":
                    try {
                        date = simpleDateFormat.parse(param);
                    } catch (ParseException e) {
                    }
                    for (Log l : getListLog()) {
                        if (l.getDate().compareTo(date) == 0) {
                            set.add(l.getStatus());
                        }
                    }
                    break;
                case "get status for event":
                    for (Log l : getListLog()) {
                        if (l.getEvent() == Event.valueOf(param)) {
                            set.add(l.getStatus());
                        }
                    }
                    break;

            }
        }
        else{
        switch (query) {
            case "get ip":
                for (Log l : getListLog()) {
                    set.add(l.getIp());
                }
                break;

            case "get user":
                for (Log l : getListLog()) {
                    set.add(l.getName());
                }
                break;
            case "get date":
                for (Log l : getListLog()) {
                    set.add(l.getDate());
                }
                break;
            case "get event":
                for (Log l : getListLog()) {
                    set.add(l.getEvent());
                }
                break;
            case "get status":
                for (Log l : getListLog()) {
                    set.add(l.getStatus());
                }
                break;

        }}
        return set;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        Set<Event> allEvents = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                allEvents.add(l.getEvent());
            }
        }
        return allEvents.size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> allEvents = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                allEvents.add(l.getEvent());
            }
        }
        return allEvents;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> eventsForIP = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getIp().equals(ip)) {
                    eventsForIP.add(l.getEvent());
                }
            }
        }
        return eventsForIP;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> eventsForUser = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getName().equals(user)) {
                    eventsForUser.add(l.getEvent());
                }
            }
        }
        return eventsForUser;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> setFailedEvents = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getStatus() == Status.FAILED) {
                    setFailedEvents.add(l.getEvent());
                }
            }
        }
        return setFailedEvents;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> setErrorEvents = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getStatus() == Status.ERROR) {
                    setErrorEvents.add(l.getEvent());
                }
            }
        }
        return setErrorEvents;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getEvent() == Event.SOLVE_TASK && l.getParametr() == task) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getEvent() == Event.DONE_TASK && l.getParametr() == task) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getEvent() == Event.SOLVE_TASK) {
                    if (map.containsKey(l.getParametr())) {
                        map.put(l.getParametr(), map.get(l.getParametr()) + 1);
                    } else {
                        map.put(l.getParametr(), 1);
                    }
                }
            }
        }

        return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getEvent() == Event.DONE_TASK) {
                    if (map.containsKey(l.getParametr())) {
                        map.put(l.getParametr(), map.get(l.getParametr()) + 1);
                    } else {
                        map.put(l.getParametr(), 1);
                    }
                }
            }
        }

        return map;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> datesForUserAndEvent = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getName().equals(user) && l.getEvent() == event) {
                    datesForUserAndEvent.add(l.getDate());
                }
            }
        }
        return datesForUserAndEvent;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> datesWhenSomethingFailed = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getStatus() == Status.FAILED) {
                    datesWhenSomethingFailed.add(l.getDate());
                }
            }
        }
        return datesWhenSomethingFailed;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> datesWhenErrorHappened = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getStatus() == Status.ERROR) {
                    datesWhenErrorHappened.add(l.getDate());
                }
            }
        }
        return datesWhenErrorHappened;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        List<Date> listDate = new ArrayList<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getName().equals(user) && l.getEvent() == Event.LOGIN) {
                    listDate.add(l.getDate());
                }
            }
        }
        if (listDate.size() == 0) {
            return null;
        }
        Collections.sort(listDate);
        return listDate.get(0);
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        ArrayList<Date> dateList = new ArrayList<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getName().equals(user) && l.getEvent() == Event.SOLVE_TASK && l.getParametr() == task) {
                    dateList.add(l.getDate());
                }
            }
        }
        Collections.sort(dateList);
        if (dateList.size() == 0) {
            return null;
        }
        return dateList.get(0);
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        ArrayList<Date> dateList = new ArrayList<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getName().equals(user) && l.getEvent() == Event.DONE_TASK && l.getParametr() == task) {
                    dateList.add(l.getDate());
                }
            }
        }
        Collections.sort(dateList);
        if (dateList.size() == 0) {
            return null;
        }
        return dateList.get(0);
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> setDate = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getName().equals(user) && l.getEvent() == Event.WRITE_MESSAGE) {
                    setDate.add(l.getDate());
                }
            }
        }
        return setDate;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> setDate = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getName().equals(user) && l.getEvent() == Event.DOWNLOAD_PLUGIN) {
                    setDate.add(l.getDate());
                }
            }
        }
        return setDate;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> allUser = new HashSet<>();
        for (Log l : getListLog()) {
            allUser.add(l.getName());
        }
        return allUser;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> allUser = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                allUser.add(l.getName());
            }
        }
        return allUser.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> eventSet = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getName().equals(user)) {
                    eventSet.add(l.getEvent());
                }
            }
        }
        return eventSet.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> user = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getIp().equals(ip)) {
                    user.add(l.getName());
                }
            }
        }
        return user;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> loggedUsers = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getEvent() == Event.LOGIN) {
                    loggedUsers.add(l.getName());
                }
            }
        }
        return loggedUsers;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> downloadedPluginUsers = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getEvent() == Event.DOWNLOAD_PLUGIN && l.getStatus() == Status.OK) {
                    downloadedPluginUsers.add(l.getName());
                }
            }
        }
        return downloadedPluginUsers;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> wroteMessageUsers = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getEvent() == Event.WRITE_MESSAGE && l.getStatus() == Status.OK) {
                    wroteMessageUsers.add(l.getName());
                }
            }
        }
        return wroteMessageUsers;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> solvedTaskUsers = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getEvent() == Event.SOLVE_TASK) {
                    solvedTaskUsers.add(l.getName());
                }
            }
        }
        return solvedTaskUsers;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> solvedTaskUsers = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getEvent() == Event.SOLVE_TASK && l.getParametr() == task) {
                    solvedTaskUsers.add(l.getName());
                }
            }
        }
        return solvedTaskUsers;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> solvedTaskUsers = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getEvent() == Event.DONE_TASK) {
                    solvedTaskUsers.add(l.getName());
                }
            }
        }
        return solvedTaskUsers;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> solvedTaskUsers = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getEvent() == Event.DONE_TASK && l.getParametr() == task) {
                    solvedTaskUsers.add(l.getName());
                }
            }
        }
        return solvedTaskUsers;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                ipSet.add(l.getIp());
            }
        }
        return ipSet.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                ipSet.add(l.getIp());
            }
        }
        return ipSet;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> setIp = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getName().equals(user)) {
                    setIp.add(l.getIp());
                }
            }
        }
        return setIp;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> setIp = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getEvent() == event) {
                    setIp.add(l.getIp());
                }
            }
        }
        return setIp;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> setIp = new HashSet<>();
        for (Log l : getListLog()) {
            if (compareDate(after, before, l.getDate())) {
                if (l.getStatus() == status) {
                    setIp.add(l.getIp());
                }
            }
        }
        return setIp;
    }

    private ArrayList<Log> getListLog() {
        File[] logFile = logDir.toFile().listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                int i = pathname.getName().lastIndexOf(".");
                if (pathname.getName().substring(i).equals(".log")) {
                    return true;
                } else return false;
            }
        });

        ArrayList<Log> logs = new ArrayList<>();

        ArrayList<String> listLog = new ArrayList<>();
        for (File f : logFile) {
            try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                while (reader.ready()) {
                    listLog.add(reader.readLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (String s : listLog) {
            String[] list = s.split("\t");
            String ip = list[0];
            String name = list[1];
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            Date date = null;
            try {
                date = simpleDateFormat.parse(list[2]);
            } catch (ParseException e) {

            }
            Event event = null;

            Integer parametr = null;

            if (list[3].contains(" ")) {
                parametr = Integer.parseInt(list[3].split(" ")[1]);
                event = Event.valueOf(list[3].split(" ")[0]);
            } else {
                event = Event.valueOf(list[3]);
            }
            Status status = Status.valueOf(list[4]);

            logs.add(new Log(ip, name, date, event, parametr, status));
        }
        return logs;
    }

    private boolean compareDate(Date after, Date before, Date current) {
        if (after == null && before == null) {
            return true;
        }
        if (after != null && before != null) {
            if (current.compareTo(after) >= 0 && current.compareTo(before) <= 0) {
                return true;
            }
        }
        if (before != null && after == null) {
            if (current.compareTo(before) <= 0) {
                return true;
            }
        }
        if (after != null && before == null) {
            if (current.compareTo(after) >= 0) {
                return true;
            }
        }
        return false;
    }
}