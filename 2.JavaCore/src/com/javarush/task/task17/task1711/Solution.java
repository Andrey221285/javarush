package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            if (args.length > 0) {
                switch (args[0]) {

                    case ("-c"):
                        synchronized (allPeople) {
                            for (int i = 1; i <= args.length - 3; i += 3) {
                                String name = args[i];
                                String sex = args[i + 1];
                                Person person;
                                if (sex.equals("м")) {
                                    person = Person.createMale(name, df.parse(args[i + 2]));
                                    allPeople.add(person);
                                } else {
                                    person = Person.createFemale(name, df.parse(args[i + 2]));
                                    allPeople.add(person);
                                }
                                System.out.println(allPeople.indexOf(person));
                            }
                        }
                        break;
                    case ("-u"):
                        synchronized (allPeople) {
                            for (int i = 1; i <= args.length - 4; i += 4) {
                                String name = args[i + 1];
                                String sex = args[i + 2];
                                int id = Integer.parseInt(args[i]);

                                Person p = allPeople.get(id);
                                p.setName(name);
                                if (sex.equals("м")) {
                                    p.setSex(Sex.MALE);
                                } else if (sex.equals("ж")) {
                                    p.setSex(Sex.FEMALE);
                                }
                                p.setBirthDay(df.parse(args[i + 3]));
                                allPeople.set(id, p);
                            }
                        }
                        break;
                    case ("-d"):
                        synchronized (allPeople) {
                            Person person;
                            for (int i = 1; i < args.length; i++) {
                                int id = Integer.parseInt(args[i]);
                                person = allPeople.get(id);

                                person.setName(null);
                                person.setSex(null);
                                person.setBirthDay(null);
                               // person.setBirthDay(df.parse("00/00/00"));
                                allPeople.set(id, person);
                            }
                        }
                        break;
                    case ("-i"):
                        synchronized (allPeople) {
                            for (int i = 1; i < args.length; i++) {
                                int id = Integer.parseInt(args[i]);
                                Person a = allPeople.get(id);
                                String sex = "";
                                if (a.getSex().equals(Sex.MALE)) {
                                    sex = "м";
                                } else if (a.getSex().equals(Sex.FEMALE)) {
                                    sex = "ж";
                                }
                                SimpleDateFormat df1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                                System.out.println(a.getName() + " " + sex + " " + df1.format(a.getBirthDay()));
                            }
                        }

                }
            }
        } catch (ParseException p) {
            System.out.println("неверная дата");
        }

      /* for (Person a : allPeople) {
            System.out.println(a.getName() + " " + a.getSex() + " " + df.format(a.getBirthDay()));

        }*/
       //System.out.println(allPeople);
    }

}
