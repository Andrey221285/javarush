package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("d:\\tmp.txt", null);
            OutputStream outputStream = new FileOutputStream("d:\\001.txt");
            InputStream inputStream = new FileInputStream("d:\\001.txt");

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод

            if(assets==null){
                outputStream.write("no ".getBytes());
            outputStream.write((this.name).getBytes());


            }
            if(assets!=null){
                outputStream.write("yes ".getBytes());
                outputStream.write((this.name+" ").getBytes());
                for(Asset asset:assets){
                    outputStream.write((asset.getName()+" ").getBytes());
                    outputStream.write((asset.getPrice()+" ").getBytes());
                }
            }
        }


        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            byte[]bufer = new byte[inputStream.available()];
            inputStream.read(bufer);
            String s = new String(bufer);
            String []word = s.split(" ");
            if (word[0].equals("no")){
                this.name = word[1];
            }
            if(word[0].equals("yes")){
                this.name=word[1];
                for(int i = 2;i<word.length;i+=2){
                    assets.add(new Asset(word[i],Double.parseDouble(word[i+1])));
                }

            }
        }
    }
}
