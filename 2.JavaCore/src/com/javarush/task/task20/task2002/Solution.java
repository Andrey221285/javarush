package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("d:\\001.txt");
            InputStream inputStream = new FileInputStream("d:\\001.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Andrey");
            user.setLastName("Ermolaev");
            user.setBirthDate(new Date(1985-1900,11,22));
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.users.size());

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            if(users.size()==0){
                outputStream.write("no ".getBytes());

            }
            if(users.size()>0){
                outputStream.write("yes ".getBytes());
                for(User u:users){
                  //  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    outputStream.write((u.getFirstName()+" ").getBytes());
                    outputStream.write((u.getLastName()+" ").getBytes());
                    long ms = u.getBirthDate().getTime();
                    outputStream.write((ms+" ").getBytes());
                    outputStream.write((u.isMale()+" ").getBytes());
                    outputStream.write((u.getCountry().getDisplayedName()+" ").getBytes());
                }
            }
            //implement this method - реализуйте этот метод

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            byte[]bufer=new byte[inputStream.available()];
            inputStream.read(bufer);
            String s = new String(bufer);
           String[]word=s.split(" ");
            if(word[0].equals("no")){

            }
            if(word[0].equals("yes")){
                for(int i = 1;i<word.length;i+=5){
                    User user = new User();
                    user.setFirstName(word[i]);
                    user.setLastName(word[i+1]);
                    long ms = Long.parseLong(word[i+2]);

                    //String[]date=word[i+2].split("-");
                    Date date = new Date(ms);
                    user.setBirthDate(date);
                 //   user.setBirthDate(new Date(Integer.parseInt(date[0])-1900,Integer.parseInt(date[1])-1,Integer.parseInt(date[2])));
                    user.setMale(word[i+3].equals("true")?true:false);
                    if(word[i+4].equals("Ukraine")){
                        user.setCountry(User.Country.UKRAINE);
                    }
                    if(word[i+4].equals("Russia")){
                        user.setCountry(User.Country.RUSSIA);
                    }
                    if(word[i+4].equals("Other")){
                        user.setCountry(User.Country.OTHER);
                    }
                    users.add(user);

                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
