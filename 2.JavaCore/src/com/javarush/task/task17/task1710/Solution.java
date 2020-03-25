package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Person person;

        try {
            if (args.length > 0) {
                if(args[0].equals("-c")) {
                    if(args[2].equals("м")) {
                        person = Person.createMale(args[1], format.parse(args[3]));
                        allPeople.add(person);
                    } else {
                        person = Person.createFemale(args[1], format.parse(args[3]));
                        allPeople.add(person);
                    }
                    System.out.println(allPeople.indexOf(person));
                } else if (args[0].equals("-u")) {
                    person = allPeople.get(Integer.parseInt(args[1]));
                    person.setBirthDay(format.parse(args[4]));
                    person.setName(args[2]);
                    if(args[3].equals("м")) {
                        person.setSex(Sex.MALE);
                    } else if(args[3].equals("ж")) {
                        person.setSex(Sex.FEMALE);
                    }
                    allPeople.set(Integer.parseInt(args[1]), person);
                } else if(args[0].equals("-d")) {
                    person = allPeople.get(Integer.parseInt(args[1]));
                    person.setSex(null);
                    person.setName(null);
                    person.setBirthDay(null);
                    allPeople.set(Integer.parseInt(args[1]), person);
                } else if(args[0].equals("-i")) {
                    format = new SimpleDateFormat("dd-MMM-yyyy");
                    person = allPeople.get(Integer.parseInt(args[1]));
                    String out = "";
                    out += person.getName();
                    if(person.getSex().equals(Sex.MALE)) {
                        out += " м ";
                    } else {
                        out += " ж ";
                    }
                    out += format.format(person.getBirthDay());
                    System.out.println(out);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    }

